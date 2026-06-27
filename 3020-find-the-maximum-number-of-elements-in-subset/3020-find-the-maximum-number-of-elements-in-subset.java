import java.util.*;
class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put((long) num,map.getOrDefault((long) num,0) + 1);
        }
        int ans = 1;
        if(map.containsKey(1L)){
            int cnt = map.get(1L);
            if(cnt % 2 == 0){
                ans = Math.max(ans, cnt - 1);
            }
            else {
                ans = Math.max(ans, cnt);
            }
        }

        for(long start : map.keySet()){
            if(start == 1)
                continue;
            long curr = start;
            int len = 0;
            while(true){
                if(!map.containsKey(curr)){
                    break;
                }
                int freq = map.get(curr);
                if(freq == 1){
                    len++;
                    break;
                }
                len += 2;
                
                if( curr > 1000000000L / curr)
                    break;

                curr = curr*curr;

               
            }
             if(len % 2 == 0)
                len--;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}