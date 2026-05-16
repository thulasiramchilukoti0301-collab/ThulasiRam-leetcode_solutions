typedef struct Node{
    char ch;
    struct Node* next;
    struct Node* prev;
}Node;

typedef struct {
    Node* head;
    Node* tail;
    Node* cursor;
} TextEditor;


TextEditor* textEditorCreate() {
    TextEditor* obj = malloc(sizeof(TextEditor));
    obj->head = NULL;
    obj->tail = NULL;
    obj->cursor = NULL;
    return obj;
}

void insertChar(TextEditor* obj,char c){
    Node* newNode = malloc(sizeof(Node));
    newNode->ch = c;
    newNode->next = NULL;
    newNode->prev = NULL;
    //empty list
    if(obj->head == NULL){
        obj->head = obj->tail =newNode;
        obj->cursor = newNode;
        return;
    }
    //insert at beginning
    if(obj->cursor == NULL){
        newNode->next = obj->head;
        obj->head->prev = newNode;
        obj->head = newNode;
        obj->cursor = newNode;
        return;
    }
    //general case
    newNode->next = obj->cursor->next;
    newNode->prev = obj->cursor;
    if(obj->cursor->next)
        obj->cursor->next->prev = newNode;
    else
        obj->tail = newNode;
    obj->cursor->next = newNode;
    obj->cursor = newNode;
}
void textEditorAddText(TextEditor* obj, char* text) {
    int i = 0;
    while(text[i]){
        insertChar(obj,text[i]);
        i++;
    }
}

int textEditorDeleteText(TextEditor* obj, int k) {
    int delete = 0;
    while(obj->cursor && k--){
        Node* temp = obj->cursor;
        obj->cursor = temp->prev;

        if(temp->prev)
            temp->prev->next = temp->next;
        else
            obj->head = temp->next;

        if(temp->next)
            temp->next->prev = temp->prev;
        else
            obj->tail = temp->prev;
        free(temp);
        delete++;
    }
    return delete;
}

char* getLeftString(TextEditor* obj){
    static char ans[11];
    ans[10] = '\0';
    int idx = 9;

    Node* temp = obj->cursor;

    while(temp && idx >= 0){
        ans[idx--] = temp->ch;
        temp = temp->prev;
    }

    int start = idx+1;
    int j = 0;

    while(start <= 9)
        ans[j++] = ans[start++];

    ans[j] = '\0';

    return ans;
}
char* textEditorCursorLeft(TextEditor* obj, int k) {
    while(obj->cursor && k--){
        obj->cursor = obj->cursor->prev;
    }
    return getLeftString(obj);
}

char* textEditorCursorRight(TextEditor* obj, int k) {
    while(k--){
        if(obj->cursor == NULL){
            if(obj->head)
                obj->cursor = obj->head;
            else
                break;
        }
        else if(obj->cursor->next)
            obj->cursor = obj->cursor->next;
        else 
            break;
    }
    return getLeftString(obj);  
}

void textEditorFree(TextEditor* obj) {
    Node* temp = obj->head;
    while(temp){
        Node* nextNode = temp->next;
        free(temp);
        temp = nextNode;
    }
    free(obj);
}

/**
 * Your TextEditor struct will be instantiated and called as such:
 * TextEditor* obj = textEditorCreate();
 * textEditorAddText(obj, text);
 
 * int param_2 = textEditorDeleteText(obj, k);
 
 * char* param_3 = textEditorCursorLeft(obj, k);
 
 * char* param_4 = textEditorCursorRight(obj, k);
 
 * textEditorFree(obj);
*/