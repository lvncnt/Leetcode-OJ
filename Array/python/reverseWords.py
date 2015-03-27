## Given an input string s, reverse the string word by word.
# Assume input string may contain multiple leading, trailing spaces or spaces between two words
# one pass method: 
class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        output, count = '', 0
        for i in range(len(s) - 1, -1, -1):
            if(s[i] == ' '): count = 0
            else:
                count += 1
                if(i == 0 or s[i - 1] == ' '):
                    output += s[i:i + count]; output += ' '
        return output[:-1]
