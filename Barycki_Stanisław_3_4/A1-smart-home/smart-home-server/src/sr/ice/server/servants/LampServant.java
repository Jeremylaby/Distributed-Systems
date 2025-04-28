package sr.ice.server.servants;

public class LampServant extends Device implements SmartHome.Lamp {
    public LampServant(String deviceName, boolean isConnected) {
        super(deviceName, isConnected);
    }

    public LampServant(String deviceName) {
        super(deviceName);
    }
}
