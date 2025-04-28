package sr.ice.server.servants;

import SmartHome.*;
import com.zeroc.Ice.Current;

public class CameraServant extends Device implements Camera {

    private final CameraSettings cameraSettings;
    private int posX;
    private int posY;
    private ZoomLevel zoomLevel;

    public CameraServant(CameraSettings cameraSettings, String deviceName, boolean isConnected) {
        super(deviceName, isConnected);
        this.cameraSettings = cameraSettings;
        this.posX = 0;
        this.posY = 0;
        this.zoomLevel = ZoomLevel.ZoomX1;
    }

    public CameraServant(String deviceName) {
        this(new CameraSettings(0, 100, 0, 100, ZoomLevel.ZoomX1, ZoomLevel.ZoomX5), deviceName, false);
    }


    @Override
    public void move(Position pos, Current current) throws DeviceError, InvalidParameterError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        if (!isPositionValid(pos)) {
            throw new InvalidParameterError("Invalid position: (" + pos.x + ", " + pos.y + ")");
        }
        posX = pos.x;
        posY = pos.y;
        System.out.println("[Camera] " + getDeviceName() + " moved to position (" + posX + ", " + posY + ")");
    }

    @Override
    public Position getPosition(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        return new Position(posX, posY);
    }

    @Override
    public void setZoom(ZoomLevel zoom, Current current) throws DeviceError, InvalidParameterError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        if (!isZoomValid(zoom)) {
            throw new InvalidParameterError("Invalid zoom: " + zoom.name());
        }
        zoomLevel = zoom;
        System.out.println("[Camera] " + getDeviceName() + " zoom set to " + zoom.name());
    }

    @Override
    public ZoomLevel getZoom(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        return zoomLevel;
    }

    @Override
    public CameraSettings getCameraSettings(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        return cameraSettings;
    }

    private boolean isPositionValid(Position pos) {
        return (pos.x >= cameraSettings.minX && pos.x <= cameraSettings.maxX)
                && (pos.y >= cameraSettings.minY && pos.y <= cameraSettings.maxY);
    }

    private boolean isZoomValid(ZoomLevel zoom) {
        return (zoom.value() >= cameraSettings.minZoom.value()
                && zoom.value() <= cameraSettings.maxZoom.value());
    }
}
