## return the square root of num 
## using newton's method 
def sqrt(num):
  x0 = 1.0  
  while(True):
    x1 = (x0 + num/x0)/2
    if(abs(x1 - x0) < 1e-6): break
    x0 = x1
  return x1 
