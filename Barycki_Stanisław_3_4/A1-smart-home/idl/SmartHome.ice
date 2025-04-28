#ifndef HOME_ICE
#define HOME_ICE

module SmartHome
{

    struct TemperatureSettings {
        int currTemp;
        int maxTemp;
        int minTemp;
    };

    struct Color {
        int R;
        int G;
        int B;
    };

    struct Position {
        int x;
        int y;
    };

    enum ZoomLevel {
        ZoomX1,
        ZoomX2,
        ZoomX3,
        ZoomX4,
        ZoomX5
    };

    struct CameraSettings {
        int minX;
        int maxX;
        int minY;
        int maxY;
        ZoomLevel minZoom;
        ZoomLevel maxZoom;
    };

    exception DeviceError {
        string reason;
    };

    exception ConnectionError {
        string reason;
    };

    exception InvalidParameterError {
        string reason;
    };

    interface Device {
        void turnOn() throws DeviceError, ConnectionError;
        void turnOff() throws DeviceError, ConnectionError;
    };

    interface Lamp extends Device {
    };

    interface RGBLamp extends Lamp {
        Color setColor(Color color) throws DeviceError, InvalidParameterError;
        Color getColor() throws DeviceError;
    };

    interface AirConditioning extends Device {
        TemperatureSettings getTemperatureSettings() throws DeviceError;
        void setTemperature(int temp) throws DeviceError, InvalidParameterError;
    };

    interface AirConditioningWithThermometer extends AirConditioning {
        int getRoomTemp() throws DeviceError;
    };



    interface Camera extends Device {
        void move(Position pos) throws DeviceError, InvalidParameterError;
        Position getPosition() throws DeviceError;
        void setZoom(ZoomLevel zoom) throws DeviceError, InvalidParameterError;
        ZoomLevel getZoom() throws DeviceError;
        CameraSettings getCameraSettings() throws DeviceError;
    };

    interface NVCamera extends Camera {
        void enableNightVision() throws DeviceError;
        void disableNightVision() throws DeviceError;
        bool isNightVisionEnabled() throws DeviceError;
    };

    sequence<string> StringSeq;

    interface DeviceManager {
        StringSeq listDevices();
    };

};

#endif
