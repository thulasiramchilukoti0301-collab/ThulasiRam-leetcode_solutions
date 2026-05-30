class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int n = 0 ; n < numRows ; n++){
            List<Integer> row = new ArrayList<>();
            long val = 1;
            for(int r = 0 ; r <= n ; r++){
                row.add((int) val);
                val = val * (n - r) / (r + 1);
            }
            ans.add(row);
        }
        return ans;
    }
}