typedef struct Node{
    char* url;
    struct Node* next;
    struct Node* prev;
}Node;


typedef struct {
    Node* current;
} BrowserHistory;

Node* createNode(char* url){
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->url = (char*)malloc(strlen(url)+1);
    strcpy(newNode->url, url);
    newNode->next = NULL;
    newNode->prev = NULL;
    return newNode;
}
void freeForwardHistory(Node* node){
    Node* temp = node;
    node = node->next;
    free(temp->url);
    free(temp);
}
BrowserHistory* browserHistoryCreate(char* homepage) {
    BrowserHistory* obj = (BrowserHistory*)malloc(sizeof(BrowserHistory));
    obj->current = createNode(homepage);
    return obj;
}

void browserHistoryVisit(BrowserHistory* obj, char* url) {
    Node* curr = obj->current;
    if(curr->next){
        freeForwardHistory(curr->next);
        curr->next = NULL;
    }
    Node* newNode = createNode(url);
    curr->next = newNode;
    newNode->prev = curr;
    obj->current = newNode;
   
}

char* browserHistoryBack(BrowserHistory* obj, int steps) {
    while(obj->current->prev && steps--){
        obj->current = obj->current->prev;
    }
    return obj->current->url;
}

char* browserHistoryForward(BrowserHistory* obj, int steps) {
    while(obj->current->next && steps--){
        obj->current = obj->current->next;
    }
    return obj->current->url;
}

void browserHistoryFree(BrowserHistory* obj) {
    Node* temp = obj->current;
    while(temp->prev){
        temp = temp->prev;
    }
    while(temp){
        Node* nextNode = temp->next;
        free(temp->url);
        free(temp);
        temp = nextNode;
    }
    free(obj);
}

/**
 * Your BrowserHistory struct will be instantiated and called as such:
 * BrowserHistory* obj = browserHistoryCreate(homepage);
 * browserHistoryVisit(obj, url);
 
 * char* param_2 = browserHistoryBack(obj, steps);
 
 * char* param_3 = browserHistoryForward(obj, steps);
 
 * browserHistoryFree(obj);
*/