/** Stack.cpp
 * Stack is a simple class implementing a stack using a linked-list
 *
 * @author Sean Ho
 * For CMPT166
 */

#include "Stack.h"

////////////////// First the Node helper class

Node::Node(void* dat, Node* nxt) {		// Constructor
  data = dat;
  next = nxt;
}

Node::~Node() { }				// Destructor

////////////////// Now the main Stack class

Stack::Stack() {				// Constructor
  head = NULL;
}

// User must pop off all nodes of stack before deleting
Stack::~Stack() { }

// Add a new element on top of the stack
void Stack::push(void* dat) {
  head = new Node(dat, head);
}

// Remove the top element from the stack and return a pointer to its data
void* Stack::pop() {
  if (head == NULL) return NULL;
  void* result = head->data;
  Node* oldHead = head;
  head = head->next;
  delete oldHead;
  return result;
}

// Peek returns top element but doesn't modify the stack
void* Stack::peek() {
  if (!head) return 0;
  return head->data;
}


