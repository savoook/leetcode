package testTasks.parseGrz.model;


import com.google.gson.annotations.SerializedName;

public class Barrier {
    private String id;
    private String type;
    private String name;
    @SerializedName("allowVideo")
    private boolean isVideoAllowed;
    @SerializedName("allowOpen")
    private boolean isOpenAllowed;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isVideoAllowed() {
        return isVideoAllowed;
    }

    public boolean isOpenAllowed() {
        return isOpenAllowed;
    }
}
