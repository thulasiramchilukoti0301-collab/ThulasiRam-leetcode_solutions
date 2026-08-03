class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];

        return currPlayerAdv(nums, 0, n - 1, dp) >= 0;
    }

    private int currPlayerAdv(int[] nums, int left, int right, Integer[][] dp) {
        if (left == right)
            return nums[left];

        if (dp[left][right] != null)
            return dp[left][right];

        int chooseLeft = nums[left] - currPlayerAdv(nums, left + 1, right, dp);
        int chooseRight = nums[right] - currPlayerAdv(nums, left, right - 1, dp);

        dp[left][right] = Math.max(chooseLeft, chooseRight);

        return dp[left][right];
    }
}