package leetCode.cinema;

import java.util.*;

class Solution {

    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public int choice(int[] row) {
        int start = 0;
        int lenght = 0;
        //Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                map.put(start, lenght);
                start = i + 1;
                lenght = 0;
            } else lenght++;
            map.put(start, lenght);
        }
        Map.Entry<Integer, Integer> first = entriesSortedByValues(map).first();
        start = first.getKey();
        lenght = first.getValue();
        return start != 0 && start + lenght != row.length ? start + lenght / 2 : start == 0 ? 0 : row.length - 1;

//        lenght = 0;
//        start = 0;
//        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//            if (e.getValue() > lenght) {
//                start = e.getKey();
//                lenght = e.getValue();
//            }
//        }
//        return start != 0 && start + lenght != row.length ? start + lenght / 2 : start == 0 ? 0 : row.length - 1;
    }
}

