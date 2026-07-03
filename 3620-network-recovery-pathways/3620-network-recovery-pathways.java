import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int m = edges.length;

        List<int[]>[] adj = new List[n]; // adj[u] = list of {v, cost}
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] indeg = new int[n];
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            indeg[e[1]]++;
        }

        // Topological order via Kahn's algorithm
        int[] topo = new int[n];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int[] deg = indeg.clone();
        for (int i = 0; i < n; i++) if (deg[i] == 0) q.add(i);
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : adj[u]) {
                if (--deg[e[0]] == 0) q.add(e[0]);
            }
        }

        if (m == 0) return -1;

        // Distinct sorted edge costs — candidates for the answer
        int[] costs = new int[m];
        for (int i = 0; i < m; i++) costs[i] = edges[i][2];
        Arrays.sort(costs);
        int uc = 0;
        for (int i = 0; i < m; i++) {
            if (i == 0 || costs[i] != costs[i - 1]) costs[uc++] = costs[i];
        }

        int lo = 0, hi = uc - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(n, adj, topo, online, costs[mid], k)) {
                ans = costs[mid];
                lo = mid + 1;   // try to push the threshold higher
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean feasible(int n, List<int[]>[] adj, int[] topo,
                              boolean[] online, int X, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == Long.MAX_VALUE) continue;
            for (int[] e : adj[u]) {
                int v = e[0], cost = e[1];
                if (cost < X) continue;
                if (!online[v]) continue;
                long nd = dist[u] + cost;
                if (nd < dist[v]) dist[v] = nd;
            }
        }
        return dist[n - 1] <= k;
    }
}