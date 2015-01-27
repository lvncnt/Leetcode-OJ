## Given a non-negative number represented as an array of digits, 
## plus one to the number, return an array of digits. 

def plusOne(digits):
  for i in reversed(range(len(digits))):
    digits[i] = (digits[i] + 1)%10
    if(digits[i]): 
      break
  else: 
    digits.insert(0, 1)
  return digits
