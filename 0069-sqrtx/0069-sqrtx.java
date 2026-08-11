class Solution {
    public int mySqrt(int x) {
        if(x<2) 
        return x;
        
        int left=1;
        int right=x;
        int ans=0;
        while(left<=right){
            int m=left+(right-left)/2;
            if((long)m*m==x)
                return m;
            if((long)m*m<x){
                ans=m;
                left=m+1;
            }
            else{
                right=m-1;
            }
        }
        return ans;
    }
}
