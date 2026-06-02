class Solution {
    private int calc(int[] firstStart, int[] firstDur, int[] secondStart, int[] secondDur){
        int minFirstEnd = Integer.MAX_VALUE;
        for(int i = 0; i < firstStart.length; i++){
            minFirstEnd = Math.min(minFirstEnd,firstStart[i] + firstDur[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < secondStart.length; i++){
            ans = Math.min(ans,Math.max(minFirstEnd,secondStart[i]) + secondDur[i]);
        }
        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int firstLand = calc(landStartTime,landDuration, waterStartTime, waterDuration);
        int firstWater = calc( waterStartTime, waterDuration, landStartTime,landDuration);
        return Math.min(firstLand,firstWater);
    }
}