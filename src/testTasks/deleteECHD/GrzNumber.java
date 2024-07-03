package testTasks.deleteECHD;

import com.opencsv.bean.CsvBindByName;

public class GrzNumber {

    @CsvBindByName(column = "number")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
