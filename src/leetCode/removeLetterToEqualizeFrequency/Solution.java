package leetCode.removeLetterToEqualizeFrequency;

class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray())
            cnt[c - 'a']++;
        for (int i = 0; i < cnt.length; i++) {
            cnt[i]--;
            if (equalFrequency(cnt)) return true;
            cnt[i]++;
        }
        return false;
    }

    private boolean equalFrequency(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i == 0 || count == i) continue;
            else if (count == 0) count = i;
            else return false;
        }
        return true;
    }
}
