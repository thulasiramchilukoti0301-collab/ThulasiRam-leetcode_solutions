class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];
        int maxCost = 0;
        for(int cost : costs){
            freq[cost]++;
            maxCost = Math.max(cost,maxCost);
        }
        int ans = 0;
        for(int price = 1; price <= maxCost; price++){
            if(freq[price] == 0){
                continue;
            }
            int canBuy = Math.min(freq[price],coins/price);
            ans += canBuy;
            coins -= canBuy*price;
            if(coins < price){
                continue;
            }
        }
        return ans;
    }
}