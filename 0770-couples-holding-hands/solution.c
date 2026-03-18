int minSwapsCouples(int* row, int rowSize) {
    int pos[60];
    for(int i = 0;i < rowSize;i++)
        pos[row[i]] = i ;
    int swaps = 0;
    for(int i = 0;i < rowSize;i += 2){
        int x = row[i];
        int partner = x^1;
        if(row[i+1] != partner){
            swaps++;
            int partnerIndex = pos[partner];
            int temp = row[i+1];
            row[i+1] = row[partnerIndex];
            row[partnerIndex] = temp;
            
            pos[temp] = partnerIndex;
            pos[partner] = i+1;
        }
    }
    return swaps;
}
