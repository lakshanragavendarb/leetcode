class Solution {
    public void gen(int open, int close, int n, String str, List<String> res) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        if (open < n) {
            gen(open + 1, close, n, str + "(", res);
        }
        if (close < open) {
            gen(open, close + 1, n, str + ")", res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(0, 0, n, "", res);
        return res;
    }
}