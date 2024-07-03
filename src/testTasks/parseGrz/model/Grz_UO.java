package testTasks.parseGrz.model;

import com.opencsv.bean.CsvBindByName;

public class Grz_UO extends Grz {

    @CsvBindByName(column = "corp_id")
    private String corpId;

    @CsvBindByName(column = "corp_title")
    private String corpTitle;

    public String getCorpId() {
        return corpId;
    }

    public String getCorpTitle() {
        return corpTitle;
    }
}
