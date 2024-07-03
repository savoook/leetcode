package testTasks.parseGrz.service;

import testTasks.parseGrz.model.Barrier;
import testTasks.parseGrz.model.BarrierDto;
import testTasks.parseGrz.model.DeviceData;
import testTasks.parseGrz.model.Grz_FIZ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FIZGrzService extends AbstractGrzService<Grz_FIZ> {

    @Override
    public BufferedWriter generateRequest(BufferedWriter bw, Grz_FIZ grz, String token, String tokenUjin) throws IOException {
        DeviceData deviceData = getDeviceId(token, grz.getUnom());
        List<BarrierDto> deviceData1 = getDeviceIdUJIN(tokenUjin, grz.getUnom());
        if (Objects.nonNull(deviceData)) {
            List<Barrier> barriers = deviceData.getItems();
            if (Objects.nonNull(barriers)) {
                String type = grz.getGrzTtlType().isEmpty() ? "permanent" : "temporary";
                for (Barrier barrier : barriers) {
                    StringBuffer oneLine = new StringBuffer();
                    oneLine.append(generateGrzRequest(barrier.getId(), grz.getGrzNumber(), grz.getResidentId(), type, grz.getUnom(), grz.getPlaceId()));
                    bw.write(oneLine.toString());
                    bw.newLine();
                }
            }
        }
        if (Objects.nonNull(deviceData1)) {
            String type = grz.getGrzTtlType().isEmpty() ? "permanent" : "temporary";
            for (BarrierDto barrier : deviceData1) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(generateGrzRequest(barrier.getDeviceId(), grz.getGrzNumber(), grz.getResidentId(), type, grz.getUnom(), grz.getPlaceId()));
                bw.write(oneLine.toString());
                bw.newLine();
            }
        }
        return bw;
    }

    private String generateGrzRequest(String barrierId, String grzNumber, String rezidentId, String type, Integer unom, int placeId) {
        return "curl --location -k --request POST 'https://integration-sm-echd.mos.ru/ihome/api/v1/devices/" + barrierId + "/vehicles/" + grzNumber + "' \\\n " +
                " --header 'Master-System: eHome' \\\n " +
                " --header 'Content-Type: application/json' \\\n " +
                " --header 'Accept: application/json' \\\n " +
                " --header 'Authorization: Bearer " + TOKEN + "' \\\n " +
                " --data '{\"residentId\":\"" + rezidentId + "\",\"options\": {\"grzTtlType\":\"" + type + "\",\"unom\":" + unom + ",\"placeId\":" + placeId + "}}'";
    }
}