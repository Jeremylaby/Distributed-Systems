### 12:
![img.png](img/img.png)
Są w różne base więc poszły 2 requesty i 2 reply 
takie jest body request:
![img.png](img/img2.png)
takie jest body replay:
![img.png](img3.png)
Żeby się połączyć pomiędzy różnymi maszynami należy:
- Ustawić na sewerze adres ip na którym nasłuchujemy (albo 0.0.0.0 jeżeli na wszystkich interface)
- Ustawić na serwerze port na którym nasłuchujemy
- Ustawić u klienta adres ip taki jak ma serwer (jeżeli w sieci lokalnej to taki jaki ma maszyna jeżeli WLAN to taki jaki na zewnątrz)
- Ustawić u klienta port na którym nasłuchuje serwer może byc efeeryczny
