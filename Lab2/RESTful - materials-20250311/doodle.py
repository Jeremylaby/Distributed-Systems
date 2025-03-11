from fastapi import FastAPI, Body, status
from pydantic import BaseModel
from typing import Dict, List
from fastapi.responses import JSONResponse

app = FastAPI()


class Poll(BaseModel):
    id: str
    question: str
    options: List[str]
    votes: Dict[str, int] = {}


polls: Dict[str, Poll] = {}


@app.post("/polls/")
def create_poll(poll: Poll):
    if poll.id in polls:
        return JSONResponse(
            status_code=status.HTTP_409_CONFLICT,
            content={"error": "Poll already exists"}
        )

    # Inicjalizacja głosów na 0 dla każdej opcji
    poll.votes = {option: 0 for option in poll.options}
    polls[poll.id] = poll

    return JSONResponse(
        status_code=status.HTTP_201_CREATED,
        content={"message": "Poll created", "poll": poll.dict()}
    )


@app.get("/polls/{poll_id}/")
def get_poll(poll_id: str):
    if poll_id not in polls:
        return JSONResponse(
            status_code=status.HTTP_404_NOT_FOUND,
            content={"error": "Poll with this ID not found"}
        )
    return polls[poll_id]


@app.post("/polls/{poll_id}/vote/")
def vote_for(poll_id: str, option: str):
    if poll_id not in polls:
        return JSONResponse(
            status_code=status.HTTP_404_NOT_FOUND,
            content={"error": "Poll with this ID not found"}
        )

    if option not in polls[poll_id].options:
        return JSONResponse(
            status_code=status.HTTP_400_BAD_REQUEST,
            content={"error": "Invalid voting option"}
        )

    polls[poll_id].votes[option] += 1

    return JSONResponse(
        status_code=status.HTTP_200_OK,
        content={
            "message": "Vote recorded successfully",
            "poll": polls[poll_id].dict()
        }
    )


@app.delete("/polls/{poll_id}/vote/")
def delete_vote(poll_id: str, option: str):
    if poll_id not in polls:
        return JSONResponse(
            status_code=status.HTTP_404_NOT_FOUND,
            content={"error": "Poll with this ID not found"}
        )

    if option not in polls[poll_id].options:
        return JSONResponse(
            status_code=status.HTTP_400_BAD_REQUEST,
            content={"error": "Invalid voting option"}
        )

    if polls[poll_id].votes[option] <= 0:
        return JSONResponse(
            status_code=status.HTTP_400_BAD_REQUEST,
            content={"error": "No votes to remove for this option"}
        )

    polls[poll_id].votes[option] -= 1

    return JSONResponse(
        status_code=status.HTTP_200_OK,
        content={
            "message": "Vote deleted successfully",
            "poll": polls[poll_id].dict()
        }
    )
