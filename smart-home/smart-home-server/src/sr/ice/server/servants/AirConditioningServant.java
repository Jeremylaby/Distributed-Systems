package sr.ice.server.servants;

import SmartHome.AirConditioning;
import SmartHome.DeviceError;
import SmartHome.InvalidParameterError;
import SmartHome.TemperatureSettings;
import com.zeroc.Ice.Current;

public class AirConditioningServant extends Device implements AirConditioning {

    private TemperatureSettings settings;

    public AirConditioningServant(String deviceName, boolean isConnected, int currTemp, int minTemp, int maxTemp) {
        super(deviceName, isConnected);
        this.settings = new TemperatureSettings(currTemp, maxTemp, minTemp);
    }

    public AirConditioningServant(String deviceName) {
        this(deviceName, true, 22, 10, 30);
    }

    @Override
    public TemperatureSettings getTemperatureSettings(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        return settings;
    }

    protected int getCurrentTemperature() {
        return settings.currTemp;
    }

    @Override
    public void setTemperature(int temp, Current current) throws DeviceError, InvalidParameterError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        if (temp < settings.minTemp || temp > settings.maxTemp) {
            throw new InvalidParameterError("Invalid temperature: " + temp + "°C");
        }
        settings.currTemp = temp;
        System.out.println("[AirConditioning] " + getDeviceName() + " temperature set to " + temp + "°C");
    }
}
