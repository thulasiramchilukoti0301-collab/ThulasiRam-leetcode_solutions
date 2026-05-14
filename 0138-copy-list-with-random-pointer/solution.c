/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *next;
 *     struct Node *random;
 * };
 */
struct Node* createNode(int val){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->val = val;
    newNode->next = NULL;
    newNode->random = NULL;
    return newNode;
}
struct Node* copyRandomList(struct Node* head) {
    if(head == NULL)
        return NULL;
    
    struct Node* temp = head;
    while (temp != NULL){
        struct Node* copyNode = createNode(temp->val);
        copyNode->next = temp->next;
        temp->next = copyNode;

        temp = copyNode->next;
    }
    temp = head;
    while (temp != NULL){
        if(temp->random != NULL){
            temp->next->random = temp->random->next;
        }
        temp = temp->next->next;
    }
    temp = head;
    struct Node* copyHead = temp->next;
    struct Node* copyTemp = copyHead;
    while (temp != NULL){
        temp->next = temp->next->next;
        if(copyTemp->next != NULL){
            copyTemp->next = copyTemp->next->next;
        }
        temp = temp->next;
        copyTemp = copyTemp->next;
    }
    return copyHead;
	
}
