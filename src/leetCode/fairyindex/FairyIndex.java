package leetCode.fairyindex;

import java.util.ArrayList;
import java.util.List;

public class FairyIndex {
    public static List<Integer> findIndexCount(int[] first, int[] second) {
        List<Integer> result = new ArrayList<>(first.length);
        int leftSumFrst = 0;
        int leftSumSec = 0;
        int totalSumFrst = 0;
        int totalSumSec = 0;

        for (int i = 0; i < first.length; i++) {
            totalSumFrst += first[i];
            totalSumSec += second[i];
        }

        for (int pivot_index = 0; pivot_index < first.length; pivot_index++) {
            if (leftSumFrst * 2 == totalSumFrst && leftSumSec * 2 == totalSumSec) {

                result.add(pivot_index);
            }

            leftSumFrst += first[pivot_index];
            leftSumSec += second[pivot_index];
        }

        return result;
    }
}