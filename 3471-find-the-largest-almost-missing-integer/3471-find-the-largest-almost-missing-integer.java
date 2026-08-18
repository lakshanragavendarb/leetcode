class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        while(left<nums.length-k+1){
             HashSet<Integer> set = new HashSet<>();
            for (int i = left; i < left + k; i++) {
                set.add(nums[i]);
            }
        for(int num:set){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        left++;
        }
        int max=-1;
        for(int num:map.keySet()){
            if(map.get(num)==1){
                if(num>max)
                max=num;
            }
        }
        if(max==-1)
        return -1;
        else
         return max;
    }
}