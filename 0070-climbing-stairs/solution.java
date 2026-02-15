class Solution {
    public int climbStairs(int n) {
        int prev2 = 1;
        int prev1 = 2;
        int result = 0;
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else 
            for(int i = 3;i<=n;i++){
                result = prev1 + prev2;
                prev2 = prev1;
                prev1 = result;

            }
            return result;
    }

}
