class Solution:
    # @param s, a string
    # @return a boolean
    def isNumber(self, s):
        i, n = 0, len(s)
        while(i < n and s[i] == ' '): i += 1
        if(i < n and (s[i] == '-' or s[i] == '+')): i += 1
        isNumber = False
        while(i < n and s[i].isdigit()): 
            i += 1; isNumber = True  
        if(i < n and s[i] == '.'): 
            i += 1
            while(i < n and s[i].isdigit()):
                i += 1; isNumber = True
        if(isNumber and i < n and s[i].lower() == 'e'):
            i += 1
            if(i < n and (s[i] == '-' or s[i] == '+')): i += 1
            isNumber = False 
            while(i < n and s[i].isdigit()):
                i += 1; isNumber = True
        while(i < n and s[i] == ' '): i += 1
        return isNumber and i == n
