## convert a string to an integer.
class Solution:
	def atoi(self, str):
		i, flag, temp = 0, 1, 0
		min, max = -2**31, 2**31 - 1
		while(str[i] == ' '):
			i += 1
			if(i == len(str)): return 0
		if(str[i] == '-' or str[i] == '+'):
			flag = 0 if str[i] == '-' else 1
			i += 1
		while(i < len(str) and str[i] >= '0' and str[i] <= '9'):
			temp = temp * 10 + ord(str[i]) - ord('0')
			i += 1
			x = temp if flag else -temp
			if(x > max): return max
			if(x < min): return min
		return temp if flag else -temp 
