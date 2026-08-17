class Solution {
    public int findSpecialInteger(int[] arr) {
        int cal = arr.length / 4;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int num : arr)
        map.put(num, map.getOrDefault(num, 0) + 1);
        for(int num : map.keySet()){
            if(map.get(num) > cal)
            return num;
        }
        return -1;
    }
}