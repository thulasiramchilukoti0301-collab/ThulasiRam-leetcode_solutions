class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] reverse = new int[n];
        for(int i = 0; i < n; i++){
            reverse[i] = nums[n - i -1];
        }
        
        int[] ans = new int[2*n];
        for(int i = 0; i < 2*n;i++){
            if(i < n){
                ans[i] = nums[i];
            }
            else {
                ans[i] = reverse[i - n];
            }
        }
        return ans;
    }
}