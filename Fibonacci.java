package Assignment12;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/29/2024		
 * Assignment: Write a method that use the saved data to give the answer to the nth Fibonacci. I used map.
 * 			   If it does find the value, it returns the precomputed value. If not, it recursively calculates Fibonacci(n-1) and Fibonacci(n-2), 
 * 			   adds them together, stores the result in the memoization map, and returns the Fibonacci value.
 *
 * BC CS211
 * Selected Chapter 10 Exercises
 * 
 * W.P. Iverson, January 2024
 */

import java.math.BigInteger;
import java.util.*;
/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2022
 */
public class Fibonacci {
	
	private int n; // the boring old 32-bit limited int
	
	// only one constructor needed
	public Fibonacci(int number) {
		n = number;
	}
	
	// make this private as right now I cannot think of why we need to allow
	@SuppressWarnings("unused")
	private Fibonacci() {
		this(1);
	}
	
	// Chapter 12, Exercise 2, code from page 128-9.
	public int fibForLoop() {
		int n1 = 1;
		int n2 = 1;
		for (int i = 3; i <= n; i++) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n2;
	}	
	
	// Chapter 12, same exercise
	// public accessor into recursive helper
	public int fibonacci() {
		return fibonacci(n);
	}
	
	// private recursive helper given in text
	// Chapter 12, page 830 (5th ed.)
    private int fibonacci(int n) {
        if (n<=2) {
            return 1;
        } else {
        	return fibonacciHelper(n, new HashMap<>());
        }
    }
    
    private int fibonacciHelper(int n, Map<Integer, Integer> memo) {
        if (n <= 2) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int fib = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);
        memo.put(n, fib);
        return fib;
    }


    // Exactly the same concept as above, but using BigInteger
    // This allows us to go up to any size integer
	public BigInteger bigFib() {
		return bigFib(new BigInteger(Integer.toString(n)));
	}
	
	// recursive helper
    private BigInteger bigFib(BigInteger n) {
        if (n.compareTo(BigInteger.valueOf(2)) <= 0) {
            return BigInteger.ONE;
        } else {
            return bigFib(n.subtract(BigInteger.ONE)).add(bigFib(n.subtract(BigInteger.TWO)));
        }
    }
   
   //_____________________________________________________________________________________________ 
  //bigFastFib
 // Public method to calculate the nth Fibonacci number using memoization for faster computation
 public BigInteger bigFastFib() {
     return bigFastFib(n);
 }

 // Private recursive helper method to calculate the nth Fibonacci number with memoization
 private BigInteger bigFastFib(int n) {
     // Base cases for Fibonacci(1) and Fibonacci(2)
     if (n <= 2) {
         return BigInteger.ONE;
     } else {
         // Create a HashMap to store previously calculated Fibonacci values
         Map<Integer, BigInteger> memo = new HashMap<>();
         memo.put(1, BigInteger.ONE);
         memo.put(2, BigInteger.ONE);
         // Call the recursive helper function to calculate Fibonacci(n) with memoization
         return bigFastFibHelper(n, memo);
     }
 }


 // Private recursive helper function to calculate Fibonacci(n) with memoization
 private BigInteger bigFastFibHelper(int n, Map<Integer, BigInteger> memo) {
     // Check if the Fibonacci value for 'n' is already computed and stored in the memoization map
     if (memo.containsKey(n)) {
         return memo.get(n);
     }
     // Calculate Fibonacci(n-1) and Fibonacci(n-2) recursively and store the result in the memoization map
     BigInteger fib = bigFastFibHelper(n - 1, memo).add(bigFastFibHelper(n - 2, memo));
     memo.put(n, fib);
     return fib;
 }

}
