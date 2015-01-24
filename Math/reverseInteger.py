class Solution:
    # @return an integer
    def reverse(self, x):
        temp = abs(x)
        reversed = []
        while(temp//10):
            reversed.append(temp%10)
            temp = temp//10
        reversed.append(temp)
        reversed = int(''.join(str(item) for item in reversed))
        if((reversed > 2**31) or (reversed < -(2**31 -1))):
            return 0
        else:
            return reversed if x > 0 else -reversed
