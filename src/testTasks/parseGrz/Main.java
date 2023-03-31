package testTasks.parseGrz;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvParser parser = new CsvParser();
        List<Grz> grzs = parser.parseCsv("C:\\Users\\savoo\\OneDrive\\Рабочий стол\\result.csv");
        CsvBuilder builder = new CsvBuilder();
        builder.build(grzs);
    }
}
