## Given a linked list, swap every two adjacent nodes and return its head 
class ListNode():
  def __init__(self, x):
    self.val = x
    self.next = None 
def swapPairs(head):
  dummyHead = ListNode(0)
  dummyHead.next = head
  current = dummyHead 
  p = head 
  while(p != None and p.next != None):
    q = p.next
    r = p.next.next
    current.next = q
    q.next = p
    p.next = r
    current = p
    p = p.next 
  return dummyHead.next 
  
