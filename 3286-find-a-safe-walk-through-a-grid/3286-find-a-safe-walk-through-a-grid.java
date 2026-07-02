class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] cost = new int[m][n];
        for( int[] row : cost) Arrays.fill(row,Integer.MAX_VALUE);

        int startCost = grid.get(0).get(0);
        cost[0][0] = startCost;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!deque.isEmpty()){
            int[] cur = deque.pollFirst();
            int r = cur[0], c = cur[1];
            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nr >=m || nc < 0 || nc >= n) continue;

                int weight = grid.get(nr).get(nc);
                int newCost = cost[r][c] + weight;

                if(newCost < cost[nr][nc]){
                    cost[nr][nc] = newCost;
                    if(weight == 0){
                        deque.offerFirst(new int[]{nr,nc});
                    }
                    else{
                        deque.offerLast(new int[]{nr,nc});
                    }
                }
            }
        }
        return health - cost[m - 1][n - 1] >= 1;
    }
}