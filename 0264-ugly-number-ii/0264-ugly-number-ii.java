class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
        {
            return 1;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int twos = 0;
        int threes = 0;
        int fives = 0;
        while(ans.size() <= n)
        {
            long nextTwo = (long)ans.get(twos)*2;
            long nextThree = (long)ans.get(threes)*3;
            long nextFive = (long)ans.get(fives)*5;
            
            long nextMin = Math.min(nextTwo, Math.min(nextThree, nextFive));
            ans.add((int)nextMin);
            if(nextMin == nextTwo)
            {
                twos++;
            }
            if(nextMin == nextThree)
            {
                threes++;
            }
            if(nextMin == nextFive)
            {
                fives++;
            }
        }
    return ans.get(n-1);
    }
}