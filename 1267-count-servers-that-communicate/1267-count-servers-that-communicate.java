class Solution {
    public int countServers(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int[] rowCount = new int[grid[0].length];
        int[] colCount = new int[grid.length];

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length ; col++){
                if(grid[row][col] == 1) {
                    rowCount[col]++;
                    colCount[row]++;
                }
            }
        }
        int communicableServersCount = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    if(rowCount[col] > 1 || colCount[row] > 1 ){
                        communicableServersCount++;
                    }
                }
            }
        }
        return communicableServersCount;
    }
}