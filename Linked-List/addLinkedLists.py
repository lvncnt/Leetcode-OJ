## Add two numbers 
## You are given two linked lists representing two non-negative numbers. 
## The digits are stored in reverse order and each of their nodes contain a single digit. 
## Add the two numbers and return it as a linked list.
class Node():
  def __init__(self, x):
    self.data = x
    self.next = None 
  
def addLinkedLists(l1, l2):
  dummyHead = Node(0)
  current = dummyHead
  carry = 0
  while(l1 != None or l2 != None):
    x = l1.data if l1 != None else 0
    y = l2.data if l2 != None else 0
    sum = x + y + carry
    current.next = Node(sum%10)
    
    carry = sum//10
    if(l1 != None): l1 = l1.next
    if(l2 != None): l2 = l2.next
    current = current.next 
  if(carry): p.next = Node(carry)
  return dummyHead.next 
  
