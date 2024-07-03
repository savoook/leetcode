package testTasks.parseGrz.builder;

import java.util.List;

public interface Builder {

    static final String CSV_SEPARATOR = ",";

    static String TOKEN = "TOKEN";

    <T> void build(List<T> list, String token,String tokenUjin, String filename, boolean UO);

}
