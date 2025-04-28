package sr.ice.server.servants;

import SmartHome.AirConditioningWithThermometer;
import SmartHome.DeviceError;
import com.zeroc.Ice.Current;

public class AirConditioningWithThermometerServant extends AirConditioningServant implements AirConditioningWithThermometer {

    public AirConditioningWithThermometerServant(String deviceName, boolean isConnected, int currTemp, int minTemp, int maxTemp) {
        super(deviceName, isConnected, currTemp, minTemp, maxTemp);
    }

    public AirConditioningWithThermometerServant(String deviceName) {
        super(deviceName);
    }

    @Override
    public int getRoomTemp(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        int roomTemp = simulateRoomTemperature();
        System.out.println("[AirConditioningWithThermometer] " + getDeviceName() + " room temperature: " + roomTemp + "°C");
        return roomTemp;
    }

    private int simulateRoomTemperature() {
        int variation = (int) (Math.random() * 5) - 2;
        return super.getCurrentTemperature() + variation;
    }


}
