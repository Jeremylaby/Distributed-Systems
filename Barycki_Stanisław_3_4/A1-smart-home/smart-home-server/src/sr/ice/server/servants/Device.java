package sr.ice.server.servants;

import SmartHome.ConnectionError;
import SmartHome.DeviceError;
import com.zeroc.Ice.Current;

public abstract class Device implements SmartHome.Device {
    protected final String deviceName;
    protected final boolean isConnected;
    protected boolean isOn;

    public Device(String deviceName, boolean isConnected) {
        this.isConnected = isConnected;
        this.isOn = false;
        this.deviceName = deviceName;
    }

    public Device(String deviceName) {
        this(deviceName, true);
    }

    @Override
    public void turnOn(Current current) throws DeviceError, ConnectionError {
        if (isDeviceDisconnected()) {
            throw new ConnectionError(getDeviceName() + " is not connected.");
        }
        if (isDeviceOn()) {
            throw new DeviceError(getDeviceName() + " is already turned on.");
        }
        this.isOn = true;
        System.out.println("[Device] " + getDeviceName() + " turned ON.");
    }

    @Override
    public void turnOff(Current current) throws DeviceError, ConnectionError {
        if (isDeviceDisconnected()) {
            throw new ConnectionError(getDeviceName() + " is not connected.");
        }
        if (!isDeviceOn()) {
            throw new DeviceError(getDeviceName() + " is already turned off.");
        }
        this.isOn = false;
        System.out.println("[Device] " + getDeviceName() + " turned OFF.");
    }


    public boolean isDeviceOn() {
        return isOn;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean isDeviceDisconnected() {
        return !isConnected;
    }
}

