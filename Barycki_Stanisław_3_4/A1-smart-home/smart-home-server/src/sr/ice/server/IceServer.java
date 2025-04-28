package sr.ice.server;

import SmartHome.CameraSettings;
import SmartHome.ZoomLevel;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import sr.ice.server.servants.*;

import java.util.ArrayList;
import java.util.List;

public class IceServer {
    public static void main(String[] args) {
        IceServer app = new IceServer();
        app.t1(args);
    }

    public void t1(String[] args) {
        int status = 0;
        Communicator communicator = null;

        try {
            communicator = Util.initialize(args);
            ObjectAdapter adapter1 = communicator.createObjectAdapter("Adapter1");
            ObjectAdapter adapter2 = communicator.createObjectAdapter("Adapter2");
            List<String> deviceIds = new ArrayList<>();

            LampServant lampUnconnected = new LampServant("lampDisconnected", false);
            adapter1.add(lampUnconnected, new Identity("lampDisconnected", "Lamp"));
            adapter2.add(lampUnconnected, new Identity("lampDisconnected", "Lamp"));
            deviceIds.add("Lamp/lampDisconnected");

            LampServant lamp1 = new LampServant("lamp1");
            adapter1.add(lamp1, new Identity("lamp1", "Lamp"));
            adapter2.add(lamp1, new Identity("lamp1", "Lamp"));
            deviceIds.add("Lamp/lamp1");

            RGBLampServant rgbLamp1 = new RGBLampServant("rgbLamp1");
            adapter1.add(rgbLamp1, new Identity("rgbLamp1", "RGBLamp"));
            adapter2.add(rgbLamp1, new Identity("rgbLamp1", "RGBLamp"));
            deviceIds.add("RGBLamp/rgbLamp1");

            CameraSettings wideSettings = new CameraSettings(0, 200, 0, 200, ZoomLevel.ZoomX1, ZoomLevel.ZoomX3);
            CameraServant wideCam1 = new CameraServant(wideSettings, "wideCam1", true);
            adapter1.add(wideCam1, new Identity("wideCam1", "Camera"));
            adapter2.add(wideCam1, new Identity("wideCam1", "Camera"));
            deviceIds.add("Camera/wideCam1");

            CameraSettings defaultSettings = new CameraSettings(0, 100, 0, 100, ZoomLevel.ZoomX1, ZoomLevel.ZoomX5);
            NVCameraServant nvCam1 = new NVCameraServant(defaultSettings, "nvCam1", true);
            adapter1.add(nvCam1, new Identity("nvCam1", "NVCamera"));
            adapter2.add(nvCam1, new Identity("nvCam1", "NVCamera"));
            deviceIds.add("NVCamera/nvCam1");

            AirConditioningServant ac1 = new AirConditioningServant("ac1");
            adapter1.add(ac1, new Identity("ac1", "AirConditioning"));
            adapter2.add(ac1, new Identity("ac1", "AirConditioning"));
            deviceIds.add("AirConditioning/ac1");

            AirConditioningWithThermometerServant acTherm1 =
                    new AirConditioningWithThermometerServant("acTherm1", true, 22, 18, 30);
            adapter1.add(acTherm1, new Identity("acTherm1", "AirConditioningWithThermometer"));
            adapter2.add(acTherm1, new Identity("acTherm1", "AirConditioningWithThermometer"));
            deviceIds.add("AirConditioningWithThermometer/acTherm1");

            DeviceManagerServant manager = new DeviceManagerServant(deviceIds);
            adapter1.add(manager, new Identity("deviceManager", "DeviceManager"));
            adapter2.add(manager, new Identity("deviceManager", "DeviceManager"));

            adapter1.activate();
            adapter2.activate();
            communicator.waitForShutdown();

        } catch (Exception e) {
            e.printStackTrace(System.err);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                status = 1;
            }
        }
        System.exit(status);
    }
}