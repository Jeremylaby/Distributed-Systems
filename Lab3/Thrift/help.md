### 7. Analiza komunikacji sieciowej:
- Json - 45 bytes TCP
- Binary - 30 bytes THRIFT
- Compact - 12 bytes THRIFT
### 8. Zmiana serializacji wiadomości w komunikacji sieciowej:
- Json - 68 bytes TCP 
- Binary - 54 bytes THRIFT TCP Strict binary protocol
- Compact - 45 bytes THRIFT TCP Compact protocol
### 9. Podejście obiektowe czy usługowe?:
nie da się wywołać operacji op ponieważ mimo że korzystamy z advenced calculator to wskazujemy na ten sam obiekt ponieważ po stronie serwera działa tylko jeden obiekt bo mamy ograniczenie w tej formie jeden port jeden obiekt dodatkowo 2 klientów nie może w tym samym czasie korzystać z serwera


### 10. Podejście obiektowe czy usługowe?:
W multiplexie da się korzystać z różnych obiektów.