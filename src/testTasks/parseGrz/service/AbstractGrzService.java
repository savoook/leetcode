package testTasks.parseGrz.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import testTasks.parseGrz.model.BarrierDto;
import testTasks.parseGrz.model.DeviceData;
import testTasks.parseGrz.model.Grz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public abstract class AbstractGrzService<T extends Grz> {

    protected static final String TOKEN = "TOKEN";


    abstract BufferedWriter generateRequest(BufferedWriter bw, T grz, String token, String tokenUjin) throws IOException;

    DeviceData getDeviceId(String token, int unom) {
        DeviceData data = null;
        try {
            String url = "https://public.proptech.ru/devices/v1/devices?unom=" + unom;
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

    List<BarrierDto> getDeviceIdUJIN(String tokenUjin, int unom) {
        List<BarrierDto> data = null;
        try {
            String url = "https://dit-api.ujin.tech/" + unom + "/devices";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Устанавливаем метод запроса
            con.setRequestMethod("GET");

            // Устанавливаем заголовок Authorization
            con.setRequestProperty("Authorization", "Bearer " + tokenUjin);

            // Получаем ответ от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            // Используем TypeToken для указания, что JSON содержит список объектов типа Barrier
            Type listType = new TypeToken<List<BarrierDto>>() {
            }.getType();
            data = gson.fromJson(String.valueOf(response), listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
