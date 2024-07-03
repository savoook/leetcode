package testTasks.parseGrz.scam;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import testTasks.parseGrz.model.Barrier;
import testTasks.parseGrz.model.DeviceDataUjin;
import testTasks.parseGrz.model.Grz_FIZ;
import testTasks.parseGrz.model.Grz_UO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class CsvBuilder {

    private static final String CSV_SEPARATOR = ",";

    private static String TOKEN = "TOKEN";


    public void build(List<Grz_FIZ> list, String token, String filename) {

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
            for (Grz_FIZ grzFIZ : list) {
                String type = grzFIZ.getGrzTtlType().isEmpty() ? "permanent" : "temporary";
                DeviceDataUjin deviceData = getDeviceId(token);
                if (Objects.nonNull(deviceData)) {
                    List<Barrier> barriers = deviceData.getItems();
                    if (Objects.nonNull(barriers)) {
                        for (Barrier barrier : barriers) {
                            StringBuffer oneLine = new StringBuffer();
                                oneLine.append("curl --location -k --request POST 'https://integration-sm-echd.mos.ru/ihome/api/v1/devices/" + barrier.getId() + "/vehicles/" + grzFIZ.getGrzNumber() + "' \\\n " +
                                        " --header 'Master-System: eHome' \\\n " +
                                        " --header 'Content-Type: application/json' \\\n " +
                                        " --header 'Accept: application/json' \\\n " +
                                        " --header 'Authorization: Bearer " + TOKEN + "' \\\n " +
                                        " --data '{\"residentId\":\"" + grzFIZ.getResidentId() + "\",\"options\": {\"grzTtlType\":\"" + type + "\",\"unom\":" + grzFIZ.getUnom() + ",\"placeId\":" + grzFIZ.getPlaceId() + "}}'");
                                bw.write(oneLine.toString());
                                bw.newLine();
                        }
                    }
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

    public void buildUO(List<Grz_UO> list, String token, String filename) {

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
            for (Grz_UO grzUo : list) {
//                DeviceData deviceData = getDeviceId(token);
//                if (Objects.nonNull(deviceData)) {
//                    List<Barrier> barriers = deviceData.getItems();
//                    if (Objects.nonNull(barriers)) {
//                        for (Barrier barrier : barriers) {
                            StringBuffer oneLine = new StringBuffer();
                            oneLine.append("curl --location -k --request POST 'https://integration-sm-echd.mos.ru/ihome/api/v1/devices/" + /*barrier.getId()*/grzUo.getId() + "/vehicles/" + grzUo.getGrzNumber() + "' \\\n " +
                                    " --header 'Master-System: eHome' \\\n " +
                                    " --header 'Content-Type: application/json' \\\n " +
                                    " --header 'Content-Length: 254' \\\n " +
                                    " --header 'Accept: application/json' \\\n " +
                                    " --header 'User-Agent: eHome' \\\n " +
                                    " --header 'Authorization: Bearer " + TOKEN + "' \\\n " +
                                    " --data '{\"residentId\":\"" + grzUo.getCorpId() + "\",\"options\": {\"creatorType\":\"UO\",\"corpId\":\"" + grzUo.getCorpId() + "\",\"corpTitle\":\"" + grzUo.getCorpTitle() + "\",\"unom\":"+grzUo.getUnom()+",\"grzTtlType\":null,\"placeId\":null}}'");
                            bw.write(oneLine.toString());
                            bw.newLine();
                        }
//                    }
//                }
//            }
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

    private DeviceDataUjin getDeviceId(String token) {
        DeviceDataUjin data = null;
        try {
            String url = "https://public.proptech.ru/devices/v1/devices?unom=15675";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Устанавливаем метод запроса
            con.setRequestMethod("GET");

            // Устанавливаем заголовок Authorization
            con.setRequestProperty("Authorization", "Bearer " + token);

            // Получаем ответ от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            data = gson.fromJson(String.valueOf(response), DeviceDataUjin.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private String getToken() {
        try {
            String url = "https://id.dom.ru/realms/lk/protocol/openid-connect/token";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Устанавливаем метод запроса
            con.setRequestMethod("POST");

            // Получаем ответ от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(String.valueOf(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}