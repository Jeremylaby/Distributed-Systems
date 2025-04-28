package sr.ice.server.servants;

import SmartHome.DeviceManager;
import com.zeroc.Ice.Current;
import java.util.List;

public class DeviceManagerServant implements DeviceManager {
    private final String[] devices;

    public DeviceManagerServant(List<String> devices) {
        this.devices = devices.toArray(new String[0]);
    }

    @Override
    public String[] listDevices(Current current) {
        return devices;
    }
}
