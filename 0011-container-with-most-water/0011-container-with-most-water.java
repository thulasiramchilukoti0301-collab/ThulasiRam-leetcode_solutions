class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(right > left){
            int currArea = Math.min(height[left],height[right])*(right - left);
            maxArea = Math.max(maxArea,currArea);
            if(height[left] > height[right]){
                right--;
            }
            else if(height[left] <= height[right]){
                left++;
            }
        }
        return maxArea;
    }
}