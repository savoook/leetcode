package testTasks.parseGrz.model;

import com.opencsv.bean.CsvBindByName;

public class Grz {
    @CsvBindByName(column = "id")
    private int id;
    @CsvBindByName(column = "unom")
    private int unom;
    @CsvBindByName(column = "grz_number")
    private String grzNumber;

    public int getId() {
        return id;
    }

    public int getUnom() {
        return unom;
    }

    public String getGrzNumber() {
        return grzNumber;
    }
}
