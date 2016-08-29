/** Stack.h
 * Header file for Stack class
 *
 * @author Sean Ho
 * For CMPT166
 */
#ifndef STACK_H
#define STACK_H

#define NULL 0		// name for the null pointer

class Node {
  public:
    void* data;
    Node* next;
    Node(void* dat, Node* nxt);
    ~Node();
};

class Stack {
  private:
    Node* head;
  public:
    Stack();		// constructor
    ~Stack();		// destructor
    void push(void* dat);
    void* pop();
    void* peek();
};

#endif // STACK_H
