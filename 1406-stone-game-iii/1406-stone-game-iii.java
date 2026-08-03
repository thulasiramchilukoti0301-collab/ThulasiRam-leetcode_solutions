

class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[i] = maximum score difference starting from index i

        // Fill DP from the end
        for (int i = n - 1; i >= 0; i--) {

            int sum = 0;
            dp[i] = Integer.MIN_VALUE;

            // Try taking 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {
                sum += stoneValue[i + k];
                dp[i] = Math.max(dp[i], sum - dp[i + k + 1]);
            }
        }

        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
}