## Assume the input string does not contain leading or trailing spaces and 
## the words are always separated by a single space
## In-place reverse method:  
class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        self.s, begin = s, 0
        self.reverse(0, len(self.s) - 1)
        for i in range(len(self.s)):
            if(self.s[i] == ' '):
                self.reverse(begin, i - 1); begin = i + 1
            if(i == len(self.s) - 1): 
                self.reverse(begin, i)
                return self.s

    def reverse(self, start, end):
        reversed = self.s[:start]
        for i in range(end, start - 1, -1): reversed += self.s[i] 
        self.s = reversed + self.s[end + 1:]
