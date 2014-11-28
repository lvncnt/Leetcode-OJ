## Longest Substring Without Repeating Characters  
## Given a string, find the length of the longest substring without repeating characters. 
def lengthOfLongestSubstring(s):
    i, maxLen, map = 0, 0, {}
    for j in range(len(s)):
      while(map.get(s[j])):
        map[s[i]] = False
        i += 1
      map[s[j]] = True
      maxLen = max(j - i + 1, maxLen)
    return maxLen 
    
