package testTasks.parseGrz.model;

import com.opencsv.bean.CsvBindByName;

public class Grz_FIZ extends Grz {

     @CsvBindByName(column = "user_guid")
    private String residentId;

    @CsvBindByName(column = "expires_at")
    private String grzTtlType;

    @CsvBindByName(column = "user_place_id")
    private int placeId;

    public String getResidentId() {
        return residentId;
    }

    public String getGrzTtlType() {
        return grzTtlType;
    }

    public int getPlaceId() {
        return placeId;
    }
}
