package Assignment13;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/16/2024		
 * Assignment: Determine what Big-O method fibonacci() and bigFastFib() are using
 *			   Explain the reason that you think it's that Big-O
 */
public class FibDriver {
    // copyright Bellevue College
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci(42); // constructor overload
        //System.out.println(test.fibForLoop()); // Chapter 2 code not used this week 
        long time1 = System.currentTimeMillis();
        System.out.println(test.fibonacci()); // slow version in text
        long time2 = System.currentTimeMillis();
        System.out.println("slow version run time ms: " + (time2-time1));
        System.out.println();
        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that fibonacci() is very slow with Big-O complexity of O(2^n)
        // Reason: This method uses recursion without memoization.
        //		   As 'n' increases, the number of recursive calls and the time taken to compute the Fibonacci number increases.
        //		   Takes a lot of time
 	 
        
        time1 = System.currentTimeMillis();
        //System.out.println(test.bigFib()); // same as above, but use BigInteger
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
        time2 = System.currentTimeMillis();
        System.out.println("bigFastFib version run time ms: " + (time2-time1));
        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that bigFastFib() is very fast with Big-O complexity of O(n)
        // Reason: This method also uses recursion, but with memoization.
        //		   Memoization ensures that each Fibonacci number is computed only once, reducing redundant computations.
        //		   Fast and efficient
    }
}