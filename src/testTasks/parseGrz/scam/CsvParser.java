package testTasks.parseGrz.scam;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.input.BOMInputStream;
import testTasks.parseGrz.model.Grz_FIZ;
import testTasks.parseGrz.model.Grz_UO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvParser {

    public List<Grz_FIZ> parseCsv(String fileName) {

        List<Grz_FIZ> listGrzFIZ = null;

        try {

            listGrzFIZ = new CsvToBeanBuilder(new InputStreamReader(new BOMInputStream(new FileInputStream(fileName)), StandardCharsets.UTF_8))
                    .withSeparator(';')
                    .withType(Grz_FIZ.class)
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listGrzFIZ;

    }

    public List<Grz_UO> parseCsvUO(String fileName) {

        List<Grz_UO> grzUoList = null;
        try {

            grzUoList = new CsvToBeanBuilder(new InputStreamReader(new BOMInputStream(new FileInputStream(fileName)), StandardCharsets.UTF_8))
                    .withSeparator(';')
                    .withType(Grz_UO.class)
                    .build()
                    .parse();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return grzUoList;

    }
}

