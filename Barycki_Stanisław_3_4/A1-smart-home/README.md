# Instrukcja uruchomienia serwera i klienta „Inteligentny dom” z ICE

## 1. Wymagania wstępne

- Java JDK 11+
- Python 3.8+
- ZeroC Ice z modułami Java i Python
- IntelliJ IDEA (serwer)
- PyCharm (klient)

## 2. Generowanie stubów z IDL

Z katalogu głównego projektu `smart-home` uruchom:

```bash
slice2java --output-dir ./smart-home-server/generated ./idl/SmartHome.ice

slice2py --output-dir ./smart-home-client ./idl/SmartHome.ice
```



## 3. Konfiguracja serwera (IntelliJ)

1. Otwórz moduł `smart-home-server` w IntelliJ.
2. W **Run → Edit Configurations** utwórz konfigurację „IceServer”:
    - **Working directory**: katalog główny serwera (`/smart-home-server`)
    - **Program arguments**:
      ```
      --Ice.Config=config.server
      ```  
3. Upewnij się, że masz plik `config.server` komunikaty serwera zostały ograniczone::
   ```properties
   Ice.Trace.Network=0
   ```

## 4. Konfiguracja klienta (PyCharm)

1. Otwórz moduł `smart-home-client` w PyCharm.
2. W **Run → Edit Configurations** utwórz konfigurację „SmartHomeClient”:
   - **Working directory**: katalog główny klienta (`/smart-home-client`)
     - **Script parameters**:
      ```
      --Ice.Config=config.client
      ```  

3. Jeżeli dostaniesz `ModuleNotFoundError: No module named 'Ice'`, zainstaluj pakiet:
   ```bash
   pip install zeroc-ice
   ```

## 5. Uruchomienie

- **Serwer** w IntelliJ uruchom konfigurację „IceServer”.
- **Klient** w PyCharm uruchom konfigurację „SmartHomeClient”.
ko z katalogu `smart-home`, aby ścieżki i konfiguracje się zgadzały. ```