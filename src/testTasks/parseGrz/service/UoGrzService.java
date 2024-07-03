package testTasks.parseGrz.service;

import testTasks.parseGrz.model.Barrier;
import testTasks.parseGrz.model.BarrierDto;
import testTasks.parseGrz.model.DeviceData;
import testTasks.parseGrz.model.Grz_UO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UoGrzService extends AbstractGrzService<Grz_UO> {

    @Override
    public BufferedWriter generateRequest(BufferedWriter bw, Grz_UO grz, String token, String tokenUjin) throws IOException {
        DeviceData deviceData = getDeviceId(token, grz.getUnom());
        if (Objects.nonNull(deviceData)) {
            List<Barrier> barriers = deviceData.getItems();
            List<BarrierDto> deviceData1 = getDeviceIdUJIN(tokenUjin, grz.getUnom());
            if (Objects.nonNull(barriers)) {
                for (Barrier barrier : barriers) {
                    StringBuffer oneLine = new StringBuffer();
                    oneLine.append(generateGrzRequest(barrier.getId(), grz.getGrzNumber(), grz.getCorpId(), grz.getCorpTitle(), grz.getUnom()));
                    bw.write(oneLine.toString());
                    bw.newLine();
                }
            }
            if (Objects.nonNull(deviceData1)) {
                for (BarrierDto barrier : deviceData1) {
                    StringBuffer oneLine = new StringBuffer();
                    oneLine.append(generateGrzRequest(barrier.getDeviceId(), grz.getGrzNumber(), grz.getCorpId(), grz.getCorpTitle(), grz.getUnom()));
                    bw.write(oneLine.toString());
                    bw.newLine();
                }
            }
        }
        return bw;
    }


    private String generateGrzRequest(String barrierId, String grzNumber, String corpId, String corpTitle, Integer unom) {

        return "curl --location -k --request POST 'https://integration-sm-echd.mos.ru/ihome/api/v1/devices/" + barrierId + "/vehicles/" + grzNumber + "' \\\n " +
                " --header 'Master-System: eHome' \\\n " +
                " --header 'Content-Type: application/json' \\\n " +
                " --header 'Content-Length: 254' \\\n " +
                " --header 'Accept: application/json' \\\n " +
                " --header 'User-Agent: eHome' \\\n " +
                " --header 'Authorization: Bearer " + TOKEN + "' \\\n " +
                " --data '{\"residentId\":\"" + corpId + "\",\"options\": {\"creatorType\":\"UO\",\"corpId\":\"" + corpId + "\",\"corpTitle\":\"" + corpTitle + "\",\"unom\":" + unom + ",\"grzTtlType\":null,\"placeId\":null}}'";

    }
}
