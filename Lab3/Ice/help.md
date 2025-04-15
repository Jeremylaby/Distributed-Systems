### 12:
![img.png](img/img.png)

Są w różne base więc poszły 2 requesty i 2 reply 
takie jest body request:

![img.png](img/img2.png)

takie jest body replay:

![img.png](img/img3.png)

Żeby się połączyć pomiędzy różnymi maszynami należy:
- Ustawić na sewerze adres ip na którym nasłuchujemy (albo 0.0.0.0 jeżeli na wszystkich interface)
- Ustawić na serwerze port na którym nasłuchujemy
- Ustawić u klienta adres ip taki jak ma serwer (jeżeli w sieci lokalnej to taki jaki ma maszyna jeżeli WLAN to taki jaki na zewnątrz)
- Ustawić u klienta port na którym nasłuchuje serwer może byc efeeryczny
### 15. Operacje idempotentne:
Wywołanie tej samej operacji z tymi samymi parametrami zawsze kończy się tym samyn
indempotentne:
- GET
- DELETE
- PUT
- add
Nie indempotentne:
- POST
- increment
### 19. Efektywność komunikacji – wywołania oneway:
Wysyłamy tylko w jedną stronę nie dostajemy odpowiedzi
Nie czekamy na potwierdzenie odbioru prze co mniej pakietów w sieci
Nie blokuje klienta
Mogą być tak zrealizowane metody które są void i nie zwracają wyjątków
czyli op
### 21. Efektywność komunikacji – wywołania datagramowe:
op2 jest kompresowane bo zawiera długą wiadomość wiadomości są tylko kolpresowane od danej długości
Gdy usuniemy parametr z obydwie wiadomości nie są skompresowne
### 22. Efektywność komunikacji – agregacja wywołań:
Osczedzamy czas który jest potrzebny na wysłanie wielu requestów po sobie tylko wysyłamy jako jeden większy.
Nie mogą to być operacja która oczekuje odpowiedź czyli albo oneway albo datagram
op może być tak realizowany
różnica polega na tym że zamiast wysyłać każdy request z wywołaniem osobno wysyłay to razem plus nie dostajemy odpowiedzi tylko ack transmisji
![img.png](img/img4.png)

W formacie datagram po prostu wysyłamy 
![img.png](img/img5.png)

### 23. Efektywność komunikacji – czas podtrzymywania połączenia TCP:
Przy obecnych ustawieniach przy każdej komunikacji jest wymieniany handshake
