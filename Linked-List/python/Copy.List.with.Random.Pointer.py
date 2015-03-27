## Copy list with random pointer
## A linked list is given such that each node contains an additional random pointer 
## which could point to any node in the list or null.
## Return a deep copy of the list. 

class RandomListNode():
  def __init__(self, x): 
    self.label = x
    self.next = None 
    self.random = None 
    
def copyRandomList(head): 
  ## O(n) runtime 
  p = head 
  while(p != None): 
    copy = RandomListNode(p.label)
    next = p.next 
    p.next = copy
    copy.next = next 
    p = next 
    
  p = head
  while(p != None): 
    p.next.random = p.random.next if p.random else None 
    p = p.next.next 
    
  p1 = head
  dummyHead = p.next if p else None  
  while(p1 != None): 
    p2 = p1.next 
    p1.next = p2.next 
    p1 = p1.next 
    p2.next = p1.next if p1 else None 
    
  return dummyHead 
    
  
