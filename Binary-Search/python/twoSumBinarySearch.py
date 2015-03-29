## Assume input array is sorted
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        for i in range(len(num)):
            first, last = i + 1, len(num) - 1
            key = target - num[i]
            while(first <= last):
                # binary search 
                mid = (first + last)//2
                if(key < num[mid]): last = mid - 1
                elif(key > num[mid]): first = mid + 1
                else:
                    return i + 1, mid + 1
