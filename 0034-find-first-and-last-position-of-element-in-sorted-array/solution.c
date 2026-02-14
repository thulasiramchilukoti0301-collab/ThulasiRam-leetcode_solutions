/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int findFirst(int* nums,int numsSize,int target){
    int left = 0, right = numsSize-1;
    int first = -1;
    while(left <= right){
        int mid = left +(right-left)/2;
        if (nums[mid] == target){
            first = mid;
            right = mid-1;
        } else if (nums[mid]<target){
            left = mid+1;
        } else {
            right = mid-1;
        }
    }
    return first;
}
int findLast(int* nums,int numsSize,int target){
    int left = 0, right = numsSize-1;
    int last = -1;
    while(left <= right){
        int mid = left +(right-left)/2;
        if (nums[mid] == target){
            last = mid;
            left = mid+1;
        } else if (nums[mid]<target){
            left = mid+1;
        } else {
            right = mid-1;
        }
    }
    return last; 
}


int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
    int first = findFirst(nums,numsSize,target);
    int last = findLast(nums,numsSize,target);

    int* result = (int*)malloc(2*sizeof(int));
    result[0] = first;
    result[1] = last;
    *returnSize = 2;
    return result;
}

