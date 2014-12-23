""" 
Spiral Matrix II 
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order 
""" 

def generateMatrix(n): 
      matrix = [[0]*n for i in range(n)]
      left, right = 0, n - 1
      top, bottom = 0, n - 1
      dir = 0
      num = 1
      
      while(num <= n*n): 
            if(dir == 0): 
                  for i in range(left, right + 1):
                        matrix[top][i] = num 
                        num += 1
                  top += 1
            elif(dir == 1):
                  for i in range(top, bottom + 1): 
                        matrix[i][right] = num 
                        num += 1 
                  right -= 1
            elif(dir == 2): 
                  for i in reversed(range(left, right + 1)): 
                        matrix[bottom][i] = num 
                        num += 1
                  bottom -= 1
            elif(dir == 3): 
                  for i in reversed(range(top, bottom + 1)): 
                        matrix[i][left] = num 
                        num += 1
                  left += 1
            dir = (dir + 1)%4
      return matrix 
      
