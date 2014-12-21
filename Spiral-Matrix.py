""" 
Spiral matrix 
print a 2D array in spiral order 
""" 
def spiralMatrix(matrix): 
  if( len(matrix) == 0): return matrix 
  m, n = len(matrix), len(matrix[0]) 
  top, bottom = 0, m - 1
  left, right = 0, n - 1
  dir = 0 
  output = [] 
  
  while(top <= bottom and left <= right): 
    
    if(dir == 0): 
      for i in range(left, right + 1): output.append(matrix[top][i]) 
      top += 1
      
    elif(dir == 1): 
      for i in range(top, bottom + 1): output.append(matrix[i][right]) 
      right -= 1
      
    elif(dir == 2): 
      for i in reversed(range(left, right + 1)): output.append(matrix[bottom][i]) 
      bottom -= 1
      
    elif(dir == 3): 
      for i in reversed(range(top, bottom + 1)): output.append(matrix[i][left]) 
      left += 1
      
    dir = (dir + 1)%4
    
  return output 
