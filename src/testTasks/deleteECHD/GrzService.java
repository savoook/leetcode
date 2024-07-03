package testTasks.deleteECHD;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class GrzService {

    protected static final String TOKEN = "TOKEN";

    public BufferedWriter generateRequest(BufferedWriter bw, GrzNumber grz, String token) throws IOException {
        DeviceData deviceData = getDeviceId(token, grz.getNumber());
        if (Objects.nonNull(deviceData)) {
            for (Device device : deviceData.getDevices()) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(generateDeleteRequest(device.getId(), grz.getNumber()));
                bw.write(oneLine.toString());
                bw.newLine();
            }
        }
        return bw;
    }

    private DeviceData getDeviceId(String token, String number) {
        DeviceData data = null;
        try {
            String url = "https://integration-sm-echd.mos.ru/ihome/api/v1/devices/vehicles/" + number;
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
            data = gson.fromJson(String.valueOf(response), DeviceData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private String generateDeleteRequest(int deviceId, String number) {

        return "curl --location --request DELETE 'https://integration-sm-echd.mos.ru/ihome/api/v1/devices/" + deviceId + "/vehicles/" + number + "' \\\n" +
                "--header 'Master-System: eHome' \\\n" +
                "--header 'Authorization: Bearer " + TOKEN + "'";
    }
}
