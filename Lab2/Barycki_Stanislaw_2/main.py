import httpx
from fastapi import FastAPI, Request, Header, Depends, HTTPException
from pydantic import BaseModel
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from fastapi.responses import JSONResponse
from typing import List, Optional
import requests


class Product(BaseModel):
    title: str
    author: str
    epoch: str
    genres: List[str]
    kind: str
    cover: str

    def to_dict(self):
        return {"title": self.title,
                "author": self.author,
                "epoch": self.epoch,
                "genres": self.genres,
                "kind": self.kind,
                "cover": self.cover}


COVER_PREFIX = "https://wolnelektury.pl/media/"
app = FastAPI()
templates = Jinja2Templates(directory="templates")
WEB_API = "https://wolnelektury.pl/api"
WEB_SUFFIX = "?format=json"
API_KEY = "nie_chce_mi_sie_robic_jwt_albo_auth_albo_https"


@app.get("/", response_class=HTMLResponse)
async def get_form(request: Request):
    return templates.TemplateResponse("index.html", {"request": request})


def verify_api_key(x_api_key: str = Header(...)):
    if x_api_key != API_KEY:
        raise HTTPException(status_code=403, detail="Invalid or missing API Key")


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}


def get_names(endpoint, retries=5):
    response = None
    error_code = ""
    content = ""
    for i in range(retries):
        try:
            url = WEB_API + endpoint + WEB_SUFFIX
            print(f"Fetching: {url}")
            response = requests.get(url, timeout=5)
            response.raise_for_status()

            data = response.json()
            data_names = [""]
            for item in data:
                data_names.append(item["name"])
            return True, data_names, response.status_code

        except requests.exceptions.RequestException as e:
            error_code = response.status_code if response is not None else 500
            content = {"error": str(e)}
        print("retry")
    return False, content, error_code


@app.get("/authors")
async def get_authors():
    success, content, status_code = get_names("/authors/")
    if success:
        return JSONResponse(content=content, status_code=status_code)
    else:
        return JSONResponse(content=content, status_code=status_code)


@app.get("/epochs")
async def get_epochs():
    success, content, status_code = get_names("/epochs/")
    if success:
        return JSONResponse(content=content, status_code=status_code)
    else:
        return JSONResponse(content=content, status_code=status_code)


@app.get("/genres")
async def get_genres():
    success, content, status_code = get_names("/genres/")
    if success:
        return JSONResponse(content=content, status_code=status_code)
    else:
        return JSONResponse(content=content, status_code=status_code)


@app.get("/kinds")
async def get_kinds():
    success, content, status_code = get_names("/kinds/")
    if success:
        return JSONResponse(content=content, status_code=status_code)
    else:
        return JSONResponse(content=content, status_code=status_code)


class SearchRequest(BaseModel):
    types: str
    authors: Optional[str] = None
    epochs: Optional[str] = None
    genres: Optional[str] = None
    kinds: Optional[str] = None


@app.post("/search")
async def search_form(search_request: SearchRequest, api_key: str = Depends(verify_api_key)):

    if search_request.types not in ["audiobooks", "books"]:
        return JSONResponse(
            status_code=400,
            content={"error": "Invalid type. Allowed values are 'audiobook' or 'book'."}
        )

    url = f"{WEB_API}/{search_request.types}/?format=json"
    print(f"Fetching: {url}")

    async with httpx.AsyncClient() as client:
        try:
            response = await client.get(url, timeout=10.0)
            response.raise_for_status()
            data = response.json()
        except httpx.RequestError as e:
            return JSONResponse(
                status_code=502,
                content={"error": f"External API connection error: {str(e)}"}
            )
        except httpx.HTTPStatusError as e:
            return JSONResponse(
                status_code=response.status_code,
                content={"error": "External API returned an error", "details": response.text}
            )
    types = search_request.types
    authors = search_request.authors
    epochs = search_request.epochs
    genres = search_request.genres
    kinds = search_request.kinds

    products = []

    for item in data:
        products.append(Product(
            title=item["title"],
            author=item["author"],
            epoch=item["epoch"],
            genres=item["genre"].split(", "),
            kind=item["kind"],
            cover=COVER_PREFIX + item["cover"]
        ))
    if authors:
        products = [p for p in products if p.author == authors]
    if epochs:
        products = [p for p in products if p.epoch == epochs]
    if genres:
        products = [p for p in products if genres in p.genres]
    if kinds:
        products = [p for p in products if p.kind == kinds]
    products_json = [product.to_dict() for product in products]
    return JSONResponse(content=products_json, status_code=response.status_code)
