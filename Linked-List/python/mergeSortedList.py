## merge two sorted linked lists and return it as a new list 

class Node():
  def __init__(self, data):
    self.data = data
    self.next = None 

def mergeSortedList(l1, l2):
  dummyHead = Node(0)
  p = dummyHead
  while(l1 != None and l2 != None):
    if(l1.data <= l2.data):
      p.next = l1
      l1 = l1.next
    else:
      p.next = l2
      l2 = l2.next
    p = p.next 
  if(l1 != None): p.next = l1
  if(l2 != NOne): p.next = l2 
  return dummyHead.next 
  
