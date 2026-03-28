/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** buildArray(int* target, int targetSize, int n, int* returnSize) {
    char** result = (char**)malloc(2*n*sizeof(char*));
    int i = 0;
    int k = 0;
    for(int num = 1;i < targetSize && num <= n;num++){
        result[k++] = "Push";
        if(num == target[i]){
            i++;
        }
        else{
            result[k++] = "Pop";

        }
    }
     *returnSize = k;
     return result;  
}
