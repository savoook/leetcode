package testTasks.parseGrz;

import com.opencsv.bean.CsvBindByName;

public class Grz {

    @CsvBindByName(column = "id")
    private int id;
    @CsvBindByName(column = "unom")
    private int unom;
    @CsvBindByName(column = "user_guid")
    private String residentId;

    @CsvBindByName(column = "grz_number")
    private String grzNumber;
    @CsvBindByName(column = "expires_at")
    private String grzTtlType;

    @CsvBindByName(column = "user_place_id")
    private int placeId;

    public String getGrzTtlType() {
        return grzTtlType;
    }

    public Integer getUnom() {
        return unom;
    }

   public int getPlaceId() {
        return placeId;
    }

    public String getGrzNumber() {
        return grzNumber;
    }

    public int getId() {
        return id;
    }

    public String getResidentId() {
        return residentId;
    }
}
