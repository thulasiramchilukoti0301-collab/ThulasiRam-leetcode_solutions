class Solution {
    public long sumAndMultiply(int n) {
        String num = String.valueOf(n);
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()){
            if(c != '0'){
                sb.append(c);
                sum += c - '0';
            }
        }
        int x = sb.length() == 0 ? 0 : Integer.parseInt(sb.toString());
        return (long)x*sum;
    }
}