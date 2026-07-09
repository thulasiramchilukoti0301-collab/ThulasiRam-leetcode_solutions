class Solution {
    private int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
    public boolean isGoodArray(int[] nums) {
        int temp = nums[0];
        for(int i = 0; i < nums.length ; i++){
            temp = gcd(temp,nums[i]);
        }
        if(temp == 1) return true;
        return false;
    }
}