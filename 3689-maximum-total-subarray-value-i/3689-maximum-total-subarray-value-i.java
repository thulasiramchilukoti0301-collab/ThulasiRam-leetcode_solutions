class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int globalMax = nums[0];
        int globalMin = nums[0];

        for(int num : nums){
            globalMin = Math.min(globalMin, num);
            globalMax = Math.max(globalMax, num);
        }
        return (long) k*(globalMax - globalMin);
    }
}