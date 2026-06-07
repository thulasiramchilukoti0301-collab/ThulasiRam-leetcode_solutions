/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* newNode(int val){
    struct TreeNode* node = ( struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = node->right = NULL;
    return node;
}


struct TreeNode* createBinaryTree(int** descriptions, int n, int* colSize) {
    #define MAX_VAL 100001

    struct TreeNode* nodes[MAX_VAL];
    int isChild[MAX_VAL];

    for(int i = 0; i < MAX_VAL; i++) nodes[i] = NULL;

    for(int i = 0; i < MAX_VAL; i++) isChild[i] = 0;

    for(int i = 0; i < n; i++){
        int parent = descriptions[i][0];
        int child = descriptions[i][1];
        int left = descriptions[i][2];

        if(!nodes[parent]) nodes[parent] = newNode(parent);
        if(!nodes[child]) nodes[child] = newNode(child);

        if(left) nodes[parent]->left = nodes[child];
        else nodes[parent]->right = nodes[child];
        isChild[child] = 1;
    }

    for(int i =0; i < n; i++){
        int parent = descriptions[i][0];
        if(!isChild[parent])
            return nodes[parent];
    }
    return NULL;
}