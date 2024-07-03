package testTasks.deleteECHD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Builder {

    static final String CSV_SEPARATOR = ",";

    static String TOKEN = "TOKEN";

    public void build(List<GrzNumber> list, String filename, String token) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), StandardCharsets.UTF_8));
            for (GrzNumber grz : list) {
                    new GrzService().generateRequest(bw, grz, token);
                }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println("��������� �� ��");
        } catch (FileNotFoundException e) {
            System.out.println("���� �� ������");
        } catch (IOException e) {
            System.out.println("���� �����-��");
        }
    }
}
