class Solution {
    public int smallestNumber(int n, int t) {
        while(!check(n,t)){
            n++;
        }
        return n;
    }
    public Boolean check(int n,int t){
        int product = 1;
        while(n > 0){
            product *= n%10;
            n /= 10;
            if(product == 0){
                break;
            }
        }
        return product%t == 0;
    }
}