package testTasks.parseGrz;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvBuilder {

    private static final String CSV_SEPARATOR = ",";

    private static String TOKEN = "TOKEN";


    public void build(List<Grz> list) {

        File file = new File("C:\\Users\\savoo\\OneDrive\\Рабочий стол\\grzCurl.csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), StandardCharsets.UTF_8));
            for (Grz grz : list) {
                String type = grz.getGrzTtlType().isEmpty() ? "permanent" : "temporary";
                StringBuffer oneLine = new StringBuffer();
                oneLine.append("curl --location -k --request POST 'https://integration-sm-echd.mos.ru/ihome/api/v1/devices/DEVICEID/vehicles/" + grz.getGrzNumber() + "' \\\n " +
                        " --header 'Master-System: eHome' \\\n " +
                        " --header 'Content-Type: application/json' \\\n " +
                        " --header 'Accept: application/json' \\\n " +
                        " --header 'Authorization: Bearer " + TOKEN + "' \\\n " +
                        " --data '{\"residentId\":\"" + grz.getResidentId() + "\",\"options\": {\"grzTtlType\":\"" + type + "\",\"unom\":" + grz.getUnom() + ",\"placeId\":" + grz.getPlaceId() + "}}'");
                bw.write(oneLine.toString());
                bw.newLine();
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

