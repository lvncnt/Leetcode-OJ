## Reverse the digits of an integer
## Example: -123 => -321
def reverseInteger(num):
  output = 0
  flag = 1 if(num > 0) else 0
  num = abs(num)
  while(num):
    if(abs(output) > (1<<31)//10): return 0
    output = output * 10 + num % 10
    num //= 10
  return output if(flag) else -output 
  
