package leetCode.firstUniqueCharacterInAString;

//ssabb
class Solution1 {
    public int firstUniqChar(String s) {
        int[][] count = new int[26][2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (count[idx][0] == 0) count[idx][1] = i;
            count[idx][0]++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] c : count)
            if (c[0] == 1 && c[1] < min) min = c[1];
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
