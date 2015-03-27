## Given two words word1 and word2, find the minimum number of 
## operations required to convert word1 to word2

def minDistance(word1, word2):
  m, n = len(word1), len(word2)
  matrix= [[0] * (n + 1) for i in range(m + 1)]
  for i in range(1, m + 1): matrix[i][0] = i 
  for j in range(1, n + 1): matrix[0][j] = j
  for i in range(1, m + 1):
    for j in range(1, n + 1):
      matrix[i][j] = matrix[i - 1][j - 1] if word1[i - 1] == word2[j - 1] else min(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1]) + 1
  return matrix[m][n]
