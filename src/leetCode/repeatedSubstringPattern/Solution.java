package leetCode.repeatedSubstringPattern;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i > 1; i--) {
            if (len % i != 0) continue;
            int rep_num = len / i;
            String subStr = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < rep_num; j++) sb.append(subStr);
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }
}

//    public boolean leetCode.repeatedSubstringPattern(String s) {
//        int n = s.length();
//        for (int i = 1; i <= n / 2; i++) {
//            if (n % i != 0) continue;
//            int m = n / i;
//            String sub = s.substring(0, i);
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < m; j++) sb.append(sub);
//            if (s.equals(sb.toString())) return true;
//        }
//        return false;
//    }
//}
