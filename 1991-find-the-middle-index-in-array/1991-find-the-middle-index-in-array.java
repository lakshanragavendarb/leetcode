class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        int total = arr[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int leftsum = 0;
            int rightsum = 0;
            if (i > 0)
                leftsum = arr[i - 1];
            rightsum = total - arr[i];
            if (leftsum == rightsum)
                return i;
        }
        return -1;
    
    }
}