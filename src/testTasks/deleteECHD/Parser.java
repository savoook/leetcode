package testTasks.deleteECHD;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.input.BOMInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Parser {

    public List<GrzNumber> parseCsv(String fileName) {

        List<GrzNumber> listGrz = null;

        try {
            listGrz = new CsvToBeanBuilder(
                    new InputStreamReader(
                            new BOMInputStream(
                                    new FileInputStream(fileName)), StandardCharsets.UTF_8))
                    .withSeparator(';')
                    .withType(GrzNumber.class)
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listGrz;
    }
}
