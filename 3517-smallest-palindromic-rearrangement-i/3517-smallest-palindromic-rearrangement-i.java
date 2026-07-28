
class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        int mid = len/2;
        char[] arr = s.toCharArray();
        Arrays.sort(arr,0,mid);
        for(int i = 0; i < mid; i++){
            arr[len - i - 1] = arr[i];
        }
        return new String(arr);
    }
}