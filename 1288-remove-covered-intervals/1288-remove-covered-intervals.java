class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });
        int remaining = 0;
        int maxRight = 0;
        for(int[] interval : intervals){
            int currRight = interval[1];
            if(currRight > maxRight){
                maxRight = currRight;
                remaining++;
            }
        }
        return remaining;
    }
}