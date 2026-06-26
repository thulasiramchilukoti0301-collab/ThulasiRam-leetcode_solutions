class Solution {
    class Fenwick{
        int[] bit;
        int n;
        Fenwick(int n){
            this.n = n;
            bit = new int[n + 1];
        }
        void update(int idx, int val){
            while(idx <= n){
                bit[idx] += val;
                idx += idx & -idx;
            }
        }
        int query(int idx){
            int sum = 0;
            while(idx > 0){
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for(int i = 1; i <= n; i++){
            if(nums[i - 1] == target)
                prefix[i] = prefix[i - 1] + 1;
            else 
                prefix[i] = prefix[i - 1] - 1;
        }
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);
        Map<Long, Integer> map = new HashMap<>();
        int idx = 1;
        for(long x: sorted){
            if(!map.containsKey(x)){
                map.put(x,idx++);
            }
        }
        Fenwick bit = new Fenwick(map.size());
        long ans = 0;
        for(long p : prefix){
            int rank = map.get(p);
            ans += bit.query(rank - 1);
            bit.update(rank,1);
        }
        return ans;
    }
}