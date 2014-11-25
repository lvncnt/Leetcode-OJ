## Implement strStr().
## Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        m, n = len(haystack), len(needle)
        if(not m): return -1 if n else 0
        if(not n): return 0
        for i in range(m):
            for j in range(n):
                if(haystack[i + j] != needle[j]): break
                if(j == (n - 1)): return i + 1
                if((i + j) == (m - 1)): return -1 
        return -1
