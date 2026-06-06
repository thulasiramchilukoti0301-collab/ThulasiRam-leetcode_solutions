class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalsum = 0;
        for(int n : nums) totalsum += n;
        int[] answer = new int[nums.length];
        int leftsum = 0;
        int rightsum = totalsum;
        for(int i = 0; i < nums.length; i++){
            rightsum -= nums[i];
            answer[i] = Math.abs(leftsum - rightsum);
            leftsum += nums[i];
        }
        return answer;
    }
}