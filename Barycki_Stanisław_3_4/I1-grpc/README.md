# Instrukcja uruchomienia serwera i klienta “DynamicList” z gRPC


## 1. Generowanie stubów Java

1. Upewnij się, że masz zainstalowany `protoc` i w PATH:
   ```bash
   protoc --version
   ```
2. Z katalogu projektu `/dynamic-list-server` uruchom:
   ```bash
   protoc.exe -I. --java_out=gen --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java-1.71.0-windows-x86_64.exe --grpc-java_out=gen dynamic-list.proto
   ```

## 2. Ustawienie środowiska Python
1. Zainstaluj zależności w katalogu `/dynamic-list-client`:
   ```bash
   pip install grpcio grpcio-reflection protobuf
   ```





