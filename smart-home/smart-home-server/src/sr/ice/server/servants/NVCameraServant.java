package sr.ice.server.servants;

import SmartHome.CameraSettings;
import SmartHome.DeviceError;
import SmartHome.NVCamera;
import com.zeroc.Ice.Current;

public class NVCameraServant extends CameraServant implements NVCamera {

    private boolean isNightVision = false;

    public NVCameraServant(CameraSettings cameraSettings, String deviceName, boolean isConnected) {
        super(cameraSettings, deviceName, isConnected);
    }

    public NVCameraServant(String deviceName) {
        super(deviceName);
    }

    @Override
    public void enableNightVision(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        if (isNightVision) {
            throw new DeviceError(getDeviceName() + " night vision is already enabled.");
        }
        isNightVision = true;
        System.out.println("[NVCamera] Night vision enabled for " + getDeviceName());
    }

    @Override
    public void disableNightVision(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        if (!isNightVision) {
            throw new DeviceError(getDeviceName() + " night vision is already disabled.");
        }
        isNightVision = false;
        System.out.println("[NVCamera] Night vision disabled for " + getDeviceName());
    }

    @Override
    public boolean isNightVisionEnabled(Current current) throws DeviceError {
        if (!isDeviceOn()) {
            throw new DeviceError("You must turn ON the device first. " + getDeviceName());
        }
        return isNightVision;
    }
}
