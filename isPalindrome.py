## Determine whether an integer is a palindrome
## without using extra space.
def isPalindrome(num):
    if(num < 0): return False
    div = 1
    while(num//div >= 10): 
        div *= 10
    while(num != 0):
        l = num//div
        r = num%10
        if(l != r): return False
        num = (num%div)//10
        div //= 100
    return True 
