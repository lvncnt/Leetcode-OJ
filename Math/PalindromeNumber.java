/*
 * Palindrome Number 
 * Determine whether an integer is a palindrome. 
 * Do this without extra space.
 */
 
class PalindromeNumber{
  
  public boolean isPalindrome(int x){
    if(x < 0) return false; 
    int div = 1; 
    while(x/div >= 10){
      div *= 10; 
    }
    int first, last; 
    while(x != 0){
      first = x/div; 
      last = x%10; 
      if(first != last)return false; 
      x %= div; 
      x /= 10; 
      div /= 100; 
    }
    return true; 
  }
  
  public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]); 
		System.out.println(new Solution().isPalindrome(x));

	}
}
