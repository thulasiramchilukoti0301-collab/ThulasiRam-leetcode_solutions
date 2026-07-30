class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int i = 0;
        int push = 0;
        while(i < n){
            if(i < 8){
                push +=1;
            }
            else if(i >= 8 && i < 16){
                push += 2;
            }
            else if(i >= 16 && i < 24){
                push += 3;
            }
            else{
                push += 4;
            }
            i++;
        }
        return push;
    }
}