class Solution {
    class Edge{
        int to;
        int distance;
        Edge(int to,int distance){
            this.to = to;
            this.distance = distance;
        }
    }
    private List<Edge>[] graph;
    private boolean[] visited;
    private int minimumScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        graph = new ArrayList[n + 1];
        for(int city = 1; city <= n; city++){
            graph[city] = new ArrayList<>();
        }
        for(int[] road : roads){
            int city1 = road[0];
            int city2 = road[1];
            int distance = road[2];
            graph[city1].add(new Edge(city2,distance));
            graph[city2].add(new Edge(city1,distance));
        }
        visited = new boolean[n + 1];
        dfs(1);
        return minimumScore;
    }
    private void dfs(int currentCity){
        visited[currentCity] = true;
        for(Edge edge : graph[currentCity]){
            minimumScore = Math.min(minimumScore,edge.distance);
            if(!visited[edge.to]){
                dfs(edge.to);
            }
        }
    }
}