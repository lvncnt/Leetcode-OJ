## Given a string s, return the longest substring 
## that contains at most two distinct characters 

def lengthOfLongestSubstringTwoDistinct(s):
    i = 0
    numDist, maxLen = 0, 0
    map = {}
    
    for j in range(len(s)):
      if(not map.get(s[j])):
        map[s[j]] = 1
        numDist += 1
      map[s[j]] += 1
      
      while(numDist > 2):
        map[s[j]] -= 1
        if(map[s[j]] == 0): 
          numDist -= 1
        i += 1
      maxLen = max(j -i + 1, maxLen)
  return maxLen 
