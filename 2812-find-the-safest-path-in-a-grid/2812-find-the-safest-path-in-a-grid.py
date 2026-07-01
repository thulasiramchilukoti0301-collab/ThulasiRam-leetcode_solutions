import heapq
class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dist = [[-1]*n for _ in range(n)]
        q = deque()

        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    dist[r][c] = 0
                    q.append((r,c))

        dirs = [(-1,0),(1,0),(0,-1),(0,1)]


        while q:
            r,c = q.popleft()
            for dr,dc in dirs:
                nr,nc = dr+r,dc+c
                if 0 <= nr < n and 0 <= nc < n and dist[nr][nc] == -1:
                    dist[nr][nc] = dist[r][c] + 1
                    q.append((nr,nc))

        safety = [[-1]*n for _ in range(n)]
        safety[0][0] = dist[0][0]
        max_heap = [(-dist[0][0],0,0)]

        while max_heap:
            neg_val,r,c = heapq.heappop(max_heap)
            val = -neg_val
            if val < safety[r][c]:
                continue
            if r == n - 1 and c == n - 1:
                return val
            for dr,dc in dirs:
                nr,nc = dr + r,dc+c
                if 0 <= nr < n and 0 <= nc < n:
                    new_val = min(val,dist[nr][nc])
                    if new_val > safety[nr][nc]:
                        safety[nr][nc] = new_val
                        heapq.heappush(max_heap,(-new_val,nr,nc))
        return safety[n-1][n - 1]