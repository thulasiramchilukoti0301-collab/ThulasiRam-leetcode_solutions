class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int total = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1){
                total += nums[i];
            }
            else {
                break;
            }
        }
        while(set.contains(total)){
            total += 1;
        }
        return total;
    }
}