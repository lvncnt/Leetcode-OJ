class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        map = {}
        for i in range(len(num)):
            if(map.get(target - num[i]) == None): map[num[i]] = i + 1  
            else: return map[target - num[i]], i + 1
