package leetCode.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            List<Integer> preLayer = triangle.get(i - 1);
            layer.add(1);
            for (int j = 1; j < i; j++) {
                layer.add(preLayer.get(j - 1) + preLayer.get(j));
            }
            layer.add(1);
            triangle.add(layer);
        }
        return triangle;
    }
}
