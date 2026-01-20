/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize) {
    int* freq=(int*)calloc(numsSize + 1,sizeof(int));
    for(int i=0;i<numsSize;i++){
        freq[nums[i]]++;
    }
    int* ans=(int*)malloc(numsSize*sizeof(int));
    int k=0;
    for(int i =1;i<=numsSize;i++){
        if(freq[i] == 0){
            ans[k++] = i;
        }
    }
    *returnSize = k;
    return ans;
}
