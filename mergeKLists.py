## Merge k sorted linked lists and return it as 
## one sorted list 
class ListNode():
  def __init__(self, x):
    self.val = x
    self.next = None

def mergeKLists(lists):
  if(not len(lists)): return None
  end = len(lists) - 1
  while(end > 0):
    start = 0
    while(start < end):
      lists[start] = merge2Lists(lists[start], lists[end])
      start += 1
      end -= 1
  return lists[0]
  
def merge2Lists(l1, l2):
  dummyHead = ListNode(0)
  p = dummyHead
  while(l1 != None and l2 != None):
    if(l1.val <= l2.val): p.next = l1; l1 = l1.next 
    else: p.next = l2; l2 = l2.next
    p = p.next 
  if(l1 != None): p.next = l1
  if(l2 != None): p.next = l2
  return dummyHead.next 
