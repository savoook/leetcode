package testTasks.parseGrz.builder;

import testTasks.parseGrz.model.Grz_FIZ;
import testTasks.parseGrz.model.Grz_UO;
import testTasks.parseGrz.service.FIZGrzService;
import testTasks.parseGrz.service.UoGrzService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BuilderGrz implements Builder {


    @Override
    public <T> void build(List<T> list, String token,String tokenUjin, String filename, boolean UO) {
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
            for (T grz : list) {
                if (UO) {
                    new UoGrzService().generateRequest(bw, (Grz_UO) grz, token, tokenUjin);
                } else {
                    new FIZGrzService().generateRequest(bw, (Grz_FIZ) grz, token, tokenUjin);
                }
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка не та");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Херь какая-то");
        }
    }
}