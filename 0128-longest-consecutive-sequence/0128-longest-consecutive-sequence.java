class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            numSet.add(nums[i]);
        }

        int longest = 1;
        for(int num : numSet){
            if(numSet.contains(num - 1)){
                continue;
            }
            else{
                int currlen = 1;
                int currNum = num;
                while(numSet.contains(currNum+1)){
                    currlen++;
                    currNum++;
                }
                longest = Math.max(longest , currlen);
            }
        }
        return longest;
    }
}