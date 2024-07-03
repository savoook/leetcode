package testTasks.parseGrz.parser;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.input.BOMInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ParserImpl<T> implements Parser {

    final Class<T> typeParameterClass;


    public ParserImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public <T> List<T> parseCsv(String fileName) {

        List<T> listGrz = null;

        try {
            listGrz = new CsvToBeanBuilder(
                    new InputStreamReader(
                            new BOMInputStream(
                                    new FileInputStream(fileName)), StandardCharsets.UTF_8))
                    .withSeparator(';')
                    .withType(typeParameterClass)
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listGrz;
    }
}