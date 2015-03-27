## Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
## Two Pointers 
class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        first, last = 0, len(s) - 1
        while(first < last):
            while((not s[first].isalnum()) and first < last): first += 1
            while((not s[last].isalnum()) and first < last): last -= 1
            if(s[first].lower() != s[last].lower()): return False
            first += 1; last -= 1
        return True
