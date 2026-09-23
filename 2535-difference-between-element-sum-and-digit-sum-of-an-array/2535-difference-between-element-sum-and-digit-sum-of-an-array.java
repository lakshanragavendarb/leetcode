class Solution {
    public int differenceOfSum(int[] nums) {
        int elsum = 0, digisum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            elsum = elsum + nums[i];
             int n = nums[i];
            while(n != 0){
                digisum = digisum + n % 10;
                n /= 10;
            }
        }
        return Math.abs(elsum - digisum);
    }
}