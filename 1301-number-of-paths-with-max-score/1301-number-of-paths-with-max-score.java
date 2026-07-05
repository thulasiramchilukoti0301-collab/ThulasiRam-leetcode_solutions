
import java.util.*;
class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] maxScore = new int[n][n];
        int[][] pathCount = new int[n][n];

        for(int i = 0;i < n;i++){
            Arrays.fill(maxScore[i],-1);
        }

        maxScore[n - 1][n - 1] = 0;
        pathCount[n - 1][n - 1] = 1;

        int[][] directions = {{1,0},{0,1},{1,1}};

        for(int row = n - 1; row >= 0; row--){
            for(int col = n - 1; col >= 0; col--){
                char currentCell = board.get(row).charAt(col);

                if(currentCell == 'X') continue;

                if(row == n - 1 && col == n - 1) continue;

                int bestPrevScore = -1;

                for(int[] direction : directions){
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if(nextRow >= n || nextCol >= n) continue;

                    bestPrevScore = Math.max(bestPrevScore,maxScore[nextRow][nextCol]);
                }

                if(bestPrevScore == -1) continue;
                int ways = 0;

                for(int[] direction : directions){
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if(nextRow >= n || nextCol >= n) continue;
                    if(maxScore[nextRow][nextCol] == bestPrevScore){
                        ways += pathCount[nextRow][nextCol];
                        ways %= MOD;
                    }
                }
                int currentValue = 0;
                if(currentCell >= '1' && currentCell <= '9'){
                    currentValue = currentCell - '0';
                }
                maxScore[row][col] = bestPrevScore + currentValue;
                pathCount[row][col] = ways;
            }
        }
        if(pathCount[0][0] == 0){
            return new int[]{0,0};
        }
        return new int[]{maxScore[0][0],pathCount[0][0]};
    }
}