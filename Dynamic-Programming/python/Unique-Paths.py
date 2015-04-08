""" 
Problem: 
A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Note: m and n will be at most 100.
""" 

# 1. No obstacles 
def uniquePaths(m, n): 
  # Bottom-up DP
  matrix = [[0]*(n + 1) for i in range(m + 1)]
  matrix[m - 1][n] = 1 
  for i in range(m-1,-1,-1):
    for j in range(n-1,-1,-1):
      matrix[i][j] = matrix[i+1][j]+matrix[i][j+1]
  return matrix[0][0]
      
  
# 2. Some obstacles are added to the grids. 
# An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
def uniquePathsWithObstacles(obstacleGrid): 
  # Bottom-up DP
  m = len(obstacleGrid) 
  n = len(obstacleGrid[0]) 
  matrix = [[n+1] for i in range(m+1)]
  matrix[m-1][n] = 1
  for i in range(m-1,-1,-1): 
    for j in range(n-1,-1,-1): 
      matrix[i][j]=0 if obstacleGrid[i][j] == 1 else matrix[i+1][j]+matrix[i][j+1]
  return matrix[0][0]
