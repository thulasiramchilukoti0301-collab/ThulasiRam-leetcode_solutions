/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeElements(struct ListNode* head, int val) {
    struct ListNode dummy;
    dummy.next = head;
    struct ListNode* temp = &dummy;
    while(temp->next){
        if(temp->next->val == val){
            struct ListNode* del = temp->next;
            temp->next = del->next;
            free(del);
        }
        else{
            temp = temp->next;
        }
    }
    return dummy.next;
}