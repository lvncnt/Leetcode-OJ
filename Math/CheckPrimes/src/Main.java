
class Main {

	/* Check for primality */ 	
	public boolean isPrime(int n){
		for(int i = 2; i <= (int)Math.sqrt(i); i ++){
			if(n % i == 0) return false; 
		}
		return true; 
	}
	
    /* *
     * Sieve of Eratosthenes  
     * Count the number of prime numbers less than a non-negative number, n 
     */ 
	public int countPrimes(int n){
		int count = 0, i = 0; 
		
		boolean isPrime[] = new boolean[n]; 

		for(i = 2; i < n; i ++) isPrime[i] = true; 
		
		for(i = 2; i < Math.sqrt(n); i ++){
			if(isPrime[i]){
				for(int j = 2 * i ; j < n; j += i) isPrime[j] = false; 
			} 
		}

		for(i = 0; i < n; i ++){
			if(isPrime[i]) count ++; 
		}
		return count; 
	}
	
	public static void main(String[] args) {
	
		Main test = new Main(); 
		
		int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197};
		
		for(int n:nums){
			if(test.isPrime(n))System.out.print("T");
			else System.out.print("F");
		}
		
		System.out.println("\nNumber of primes below 198: " + test.countPrimes(198)); 
	}
}

