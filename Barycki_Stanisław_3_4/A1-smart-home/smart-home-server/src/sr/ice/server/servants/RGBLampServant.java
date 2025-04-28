package sr.ice.server.servants;

import SmartHome.*;
import com.zeroc.Ice.Current;

public class RGBLampServant extends LampServant implements RGBLamp {

    private Color color;

    public RGBLampServant(String deviceName, boolean isConnected) {
        super(deviceName, isConnected);
        this.color = new Color(255, 255, 255);
    }

    public RGBLampServant(String deviceName) {
        this(deviceName, true);
    }

    @Override
    public Color setColor(Color color, Current current) throws DeviceError, InvalidParameterError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        if (!isValidColor(color)) {
            throw new InvalidParameterError("Invalid color values: (R=" + color.R + ", G=" + color.G + ", B=" + color.B + ")");
        }
        this.color = color;
        System.out.println("[RGBLamp] " + getDeviceName() + " color set to (R=" + color.R + ", G=" + color.G + ", B=" + color.B + ")");
        return this.color;
    }

    @Override
    public Color getColor(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        return color;
    }

    private boolean isValidColor(Color color) {
        return isComponentValid(color.R) && isComponentValid(color.G) && isComponentValid(color.B);
    }

    private boolean isComponentValid(int value) {
        return value >= 0 && value <= 255;
    }
}
