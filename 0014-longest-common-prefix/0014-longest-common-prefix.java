class Solution {
    public String longestCommonPrefix(String[] s) {
        int n = s[0].length();
        for (int i = 1; i < s.length; i++) {
            int t = s[i].length();
            if (n > t) {
                n = t;
            }
        }
        int k = 0;
        String a = "";
        int o = 0;
        while (k < n) {
            char h = s[0].charAt(k);
            o = 0;
            for (int i = 1; i < s.length; i++) {
                if (h != s[i].charAt(k)) {
                    o = 1;
                    break;
                }
            }
            if (o == 0)
                a += h;
            else
                return a;
            k++;
        }
        return a;
    }
}