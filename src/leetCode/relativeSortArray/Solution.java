package leetCode.relativeSortArray;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (Integer i : arr1) treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        int index = 0;
        for (int num : arr2) {
            int count = treeMap.get(num);
            while (count-- > 0)
                arr1[index++] = num;
            treeMap.remove(num);
        }
        for (int key : treeMap.keySet()) {
            int value = treeMap.get(key);
            while (value-- > 0) {
                arr1[index++] = key;
            }
        }
        return arr1;
    }
}
