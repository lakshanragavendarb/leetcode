class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] right = new int[m];
        Arrays.fill(right, -1);
        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                right[j] = i;
                j--;
            }
        }
        int[] ans = new int[m];
        int p = 0;
        boolean usedMismatch = false;
        for (int i = 0; i < m; i++) {
            while (p < n) {
                if (word1.charAt(p) == word2.charAt(i)) {
                    ans[i] = p;
                    p++;
                    break;
                }
                if (!usedMismatch &&
                    (i == m - 1 || p < right[i + 1])) {
                    ans[i] = p;
                    p++;
                    usedMismatch = true;
                    break;
                }
                p++;
            }
            if (p >= n && i < m - 1) {
                return new int[0];
            }
        }
        return ans;
    }
}