import sys

import SmartHome
import Ice
def do_set_zoom(proxy):
    levels = [lvl for _, lvl in sorted(SmartHome.ZoomLevel._enumerators.items())]
    for i, lvl in enumerate(levels):
        print(f"{i}: {lvl}")
    choice = input("Wybierz poziom zoomu (numer): ")
    if not choice.isdigit():
        print("Nieprawidłowy wybór")
        return
    idx = int(choice)
    if 0 <= idx < len(levels):
        proxy.setZoom(levels[idx])
        print(f"Zoom ustawiony na {levels[idx]}")
    else:
        print("Indeks poza zakresem")
lamp_commands = {
    "turnOn": lambda d: d.turnOn(),
    "turnOff": lambda d: d.turnOff()
}

rgb_lamp_commands = lamp_commands|{
    "setColor" : lambda d: d.setColor(
        int(input("R: ")), int(input("G: ")), int(input("B: "))
    ),
    "getColor": lambda d: print(d.getColor())
}

camera_commands = lamp_commands|{
    "move" : lambda d: d.move(
        int(input("X: ")), int(input("Y: "))
    ),
    "getPosition": lambda d: print(d.getPosition()),
    "setZoom": do_set_zoom,
    "getZoom": lambda d: print(d.getZoom()),
    "getCameraSettings": lambda d: print(d.getCameraSettings())
}

nv_camera_commands = camera_commands|{
    "enableNightVision": lambda d: d.enableNightVision(),
    "disableNightVision": lambda d: d.disableNightVision(),
    "isNightVisionEnabled": lambda d: d.isNightVisionEnabled()
}

air_conditioning_commands = lamp_commands|{
    "getTemperatureSettings": lambda d: print(d.getTemperatureSettings()),
    "setTemperature": lambda d: d.setTemperature(
        int(input("T: "))
    )
}

air_conditioning_with_thermometer_commands = air_conditioning_commands|{
    "getRoomTemp": lambda d: print(d.getRoomTemp())
}
command_map = {
    "Lamp": lamp_commands,
    "RGBLamp": rgb_lamp_commands,
    "Camera": camera_commands,
    "NVCamera": nv_camera_commands,
    "AirConditioning": air_conditioning_commands,
    "AirConditioningWithThermometer": air_conditioning_with_thermometer_commands
}

def display_commands(category, proxy):
    commands = command_map[category]
    keys = list(commands.keys())
    while True:
        print(f"{category}:")
        for i, command in enumerate(keys):
            print(f"{i}: {command}")
        print("Wybierz komendę lub x aby anulować: ")
        cmd = input("==> ")
        if cmd == "x":
            break
        if not cmd.isdigit():
            continue
        idx = int(cmd)
        if idx < 0 or idx >= len(keys):
            print("Zła komenda")
            continue
        try:
            commands[keys[idx]](proxy)
        except ValueError:
            print("Niepoprawna liczba")
        except SmartHome.DeviceError as e:
            print(f"DeviceError: {e.reason}")
        except SmartHome.ConnectionError as e:
            print(f"ConnectionError: {e.reason}")
        except SmartHome.InvalidParameterError as e:
            print(f"InvalidParameterError: {e.reason}")
        finally:
            break


def main():
    communicator = Ice.initialize(sys.argv)
    try:
        mgr_keys = ["DeviceManager.Proxy1", "DeviceManager.Proxy2"]
        mgrs = [
            SmartHome.DeviceManagerPrx.checkedCast(
                communicator.propertyToProxy(k)
            )
            for k in mgr_keys
        ]
        device_lists = []
        proxies_list = []
        for mgr in mgrs:
            devices = mgr.listDevices()
            device_lists.append(devices)
            proxies = {}
            for full in devices:
                category, identity = full.split("/", 1)
                prop_key = f"{category}.{identity}.Proxy"
                base = communicator.propertyToProxy(prop_key)
                if category == "Lamp":
                    prx = SmartHome.LampPrx.checkedCast(base)
                elif category == "RGBLamp":
                    prx = SmartHome.RGBLampPrx.checkedCast(base)
                elif category == "Camera":
                    prx = SmartHome.CameraPrx.checkedCast(base)
                elif category == "NVCamera":
                    prx = SmartHome.NVCameraPrx.checkedCast(base)
                elif category == "AirConditioning":
                    prx = SmartHome.AirConditioningPrx.checkedCast(base)
                elif category == "AirConditioningWithThermometer":
                    prx = SmartHome.AirConditioningWithThermometerPrx.checkedCast(base)
                else:
                    continue
                if prx:
                    proxies[identity] = prx
            proxies_list.append(proxies)
        index = 0
        while True:
            choice = input("Czy chcesz włączyć wszystkie urządzenia? [y/n]: ").lower()
            if choice == "n":
                break
            if choice == "y":
                for name, prx in proxies.items():
                    try:
                        prx.turnOn()
                        print(f"{name} został włączony")
                    except SmartHome.DeviceError as e:
                        print(f"Błąd urządzenia {name}: {e.reason}")
                    except SmartHome.ConnectionError as e:
                        print(f"Błąd połączenia z {name}: {e.reason}")
                break
        index = 1 - index
        items_list = [
            [tuple(s.split("/", 1)) for s in devices]
            for devices in device_lists
        ]
        while True:
            if index==0:
                print("Adapter1:")
            else:
                print("Adapter2:")
            items = items_list[index]
            for i, (cat, name) in enumerate(items):
                print(f"{i} - {cat} - {name}")
            print("Wybierz numer urządzenia lub x aby wyjść: ")
            cmd = input("==> ")
            if cmd == "x":
                break
            if not cmd.isdigit():
                print("Zła komenda")
                continue
            idx = int(cmd)
            if idx < 0 or idx >= len(items):
                continue
            category, name = items[idx]
            proxy = proxies[name]
            display_commands(category, proxy)
            index = 1 - index
    finally:
        communicator.destroy()


if __name__ == "__main__":
    main()
