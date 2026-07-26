class Solution {
    public int maximumProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE , min2 = Integer.MAX_VALUE; 
        for(int i = 0; i < nums.length;i++){
            int n = nums[i];
            if(n >= first){
                third = second;
                second = first;
                first = n;
            }
            else if(n > second){
                third = second;
                second = n;
            }
            else if(n > third){
                third = n;
            }
            if(n <= min1){
                min2 = min1;
                min1 = n;
            }
            else if(n < min2){
                min2 = n;
            }
        }
        int option1 = first * second * third;
        int option2 = first * min1 * min2;

        return Math.max(option1, option2);
    }
}