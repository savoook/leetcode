package testTasks.parseGrz.model;

public class BarrierDto {
    private int unom;
    private String deviceId;
    private String type;
    private String name;
    private String status;
    private String cameraId;

    public int getUnom() {
        return unom;
    }

    public void setUnom(int unom) {
        this.unom = unom;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }
}

