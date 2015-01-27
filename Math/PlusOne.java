/*
 * Plus One 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
 
class PlusOne{
  
  public int[] plusOne(int[] digits){
    for(int i = digits.length - 1; i >= 0; i -- ){
      if(digits[i] < 9){
        digits[i] += 1; 
        return digits; 
      }
      else{
        digits[i] = 0 ;
      }
    }
    
    int[] output = new int[digits.length + 1]; 
    output[0] = 1; 
    return output; 
  }
  
  public static void main(String[] args) {
		
		int[][] testCase = { {1, 2, 9, 4}, {1, 2, 4, 9}, {9, 9, 9, 9} }; 
		for(int[] digits: testCase){
			for(int i : new PlusOne().plusOne(digits)) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
  
