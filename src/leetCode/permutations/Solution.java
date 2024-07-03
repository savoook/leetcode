package leetCode.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) { // {1, 2, 3}
        LinkedList<List<Integer>> result = new LinkedList<>();
        int rSize;
        result.add(new ArrayList<>());

        for (int num : nums) {
            rSize = result.size();

            while (rSize > 0) {
                List<Integer> permutation = result.pollFirst();
                for (int i = 0; i <= permutation.size(); i++) {
                    List<Integer> newPermutation = new ArrayList<>(permutation);
                    newPermutation.add(i, num);
                    result.add(newPermutation);
                }
                rSize--;
            }
        }
        return result;
    }
}