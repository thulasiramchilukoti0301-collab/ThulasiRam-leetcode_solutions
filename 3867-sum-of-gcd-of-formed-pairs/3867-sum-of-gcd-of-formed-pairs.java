class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] prefixGcd = new int[n];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(prefixGcd);

        int left = 0, right = n - 1;
        long gcdSum = 0;

        while(left < right){
            gcdSum += gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return gcdSum;
    }
    int gcd(int a, int b){
       while(b != 0){
        int t = a%b;
        a = b;
        b = t;
       }
       return a;
    }
}