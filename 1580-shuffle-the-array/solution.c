

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* shuffle(int* nums, int numsSize, int n, int* returnSize){
    int* ans = (int*)malloc(sizeof(int)*numsSize);
    int k = 0;
    for(int i = 0; i<n; i++) {
        ans[k++] = nums[i];
        ans[k++] = nums[i+n];
    }
    *returnSize = numsSize;
    return ans;
}


