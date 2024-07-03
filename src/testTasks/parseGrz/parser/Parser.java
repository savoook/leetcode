package testTasks.parseGrz.parser;

import java.util.List;

public interface Parser {

    <T> List<T> parseCsv(String fileName);
}
