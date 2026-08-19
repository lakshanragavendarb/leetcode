class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int l_Max = height[l];
        int r_Max = height[r];
        int water = 0;
        while (l < r) {
            if (l_Max < r_Max) {
                l++;
                l_Max = Math.max(l_Max, height[l]);
                water += l_Max - height[l];
            } else {
                r--;
                r_Max = Math.max(r_Max, height[r]);
                water += r_Max - height[r];
            }
        }
        return water;        
    }
}