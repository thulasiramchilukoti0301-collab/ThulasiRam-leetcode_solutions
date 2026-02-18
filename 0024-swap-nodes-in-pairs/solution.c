/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head == NULL || head->next == NULL)
        return head;
    struct ListNode dummy;
    dummy.next = head;
    struct ListNode* prev = &dummy;
    struct ListNode* first = head;
    struct ListNode* second= head->next;

    while(first && first->next){
        second = first->next;
        
        prev->next = second;
        first->next = second->next;
        second->next = first;

        prev = first;
        first = first->next;

    }
    return dummy.next;
}
