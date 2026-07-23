class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            HashMap<Character, Character> map = new HashMap<>();
            int len = word.length();
            int flag=1;
            for (int i = 0; i < len; i++) {
                char ch1 = word.charAt(i);
                char ch2 = pattern.charAt(i);
                if (map.containsKey(ch1)) {
                    if (map.get(ch1) != ch2) {
                        flag=0;
                        break;
                    }
                } else if (map.containsValue(ch2)) {
                    flag=0;
                    break;
                } else {
                    map.put(ch1, ch2);
                }
            }
            if(flag==1){
                list.add(word);
            }
        }
        return list;
    }
}