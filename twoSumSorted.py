## Assume that the input array is sorted
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        # Two pointers
        i, j = 0, len(num) - 1
        while(i < j):
            sum = num[i] + num[j]
            if(sum < target): i += 1
            elif(sum > target): j -= 1
            else: return i + 1, j + 1
