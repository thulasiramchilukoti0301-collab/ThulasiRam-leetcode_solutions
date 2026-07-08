class Solution {
    int mod = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        //preSum,conVal,digitCount,pow10
        int[] preSum = new int[n + 1];
        int[] conVal = new int[n + 1];
        int[] digitCount = new int[n + 1];
        int[] pow10 = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int num = s.charAt(i - 1) - '0';
            preSum[i] = (preSum[i - 1] + num)%mod;
            if(num == 0){
                conVal[i] = conVal[i - 1];
                digitCount[i] = digitCount[i - 1];
            }
            else{
                
                conVal[i] = (int)(((long)conVal[i - 1]*10 + num) % mod);
                digitCount[i] = digitCount[i - 1] + 1;
            }
        }
        pow10[0] = 1;
        for(int i = 1; i <= n;i++){
            pow10[i] = (int)(((long)pow10[i - 1]*10)%mod);
        }
        int[] ans = new int[queries.length];
        for(int i = 0;i < queries.length; i++){
            int left = queries[i][0] , right = queries[i][1];

            long sum = (preSum[right + 1] - preSum[left] + mod)%mod;

            long leftpart = conVal[left] , rightpart = conVal[right + 1];

            int diff = digitCount[right + 1] - digitCount[left];
            long pow = pow10[diff];
            long range = (rightpart - (leftpart * pow)%mod + mod)%mod;
            long x = (sum * range)%mod;
            ans[i] = (int)x;
        }
        return ans;
    }
}