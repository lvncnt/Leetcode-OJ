class Solution:
    # @return a boolean
    def isPalindrome(self, x):    
        if(x < 0): return False 
        div = 1
        while(x//div >= 10): div *= 10
        while(x > 0):
            last, first = x%10, x//div
            if(first != last): return False
            x = (x%div)//10
            print(x,div)
            div //= 100
        return True
