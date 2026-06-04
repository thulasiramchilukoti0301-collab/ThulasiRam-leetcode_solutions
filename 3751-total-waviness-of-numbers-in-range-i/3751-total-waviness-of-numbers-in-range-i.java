class Solution {
    private int waviness(int num){
        String s = String.valueOf(num);
        int count = 0;
        for(int i = 1; i <= s.length() - 2; i++){
            int left = s.charAt(i - 1);
            int mid = s.charAt(i);
            int right = s.charAt(i + 1);
            
            boolean valley = mid < left && mid < right;
            boolean peak = mid > left && mid > right;
            
            if(peak || valley)
                count++;
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int num = num1; num <= num2; num++){
            ans += waviness(num);
        }
        return ans;
    }
}