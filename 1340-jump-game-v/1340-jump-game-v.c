#define MAX(a,b) ((a) > (b) ? (a) : (b))

int dfs(int* arr, int arrSize, int d, int idx, int* dp){
    
    if(dp[idx] != -1){
        return dp[idx];
    }

    int ans = 1;

    for(int i = idx - 1; i >= 0 && i >= idx - d; i--){
        if(arr[i] >= arr[idx]){
            break;
        }
        ans = MAX(ans , 1 + dfs(arr,arrSize,d,i,dp));
    }

    for(int i = idx + 1; i < arrSize && i <= idx + d; i++){
        if(arr[i] >= arr[idx]){
            break;
        }
        ans = MAX(ans ,1 + dfs(arr,arrSize,d,i,dp));
    }
    dp[idx] = ans;
    return ans;
}

int maxJumps(int* arr, int arrSize, int d) {
    
    int dp[arrSize];

    for(int i = 0; i < arrSize ; i++){
        dp[i] = -1;
    }

    int ans = 1;
    
    for(int i = 0; i < arrSize ; i++){
        ans = MAX(ans,dfs(arr,arrSize,d,i,dp));
    }
    return ans;
}