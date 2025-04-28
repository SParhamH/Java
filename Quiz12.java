package Quiz_Ch12;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/30/2024		
 * Assignment: Write a recursive method that replacing every sequence of repeated adjacent letters with just one of that letter.
 * 			   Ex: The string "bookkkkkeeper" has three repeated adjacent letters ("oo", "kkkkk", and "ee"), so the method returns "bokeper".
 */

public class Quiz12 {
	// copyright 2024 Bellevue College
	   public static void main(String[] x625) {
	      System.out.println(compress("bookkkkkeeper"));
	      System.out.println(compress("String"));
	      System.out.println(compress(""));
	   }
	   
	 // your recursive method follows:
	   public static String compress(String str) {
	        // Base case: if the input string is empty or has only one character, return it as is
	        if (str == null || str.length() <= 1) {
	            return str;
	        }

	        // Check if the first character is the same as the second one
	        if (str.charAt(0) == str.charAt(1)) {
	            // If they are the same, skip the adjacent characters and call compress on the rest of the string repeatedly
	            return compress(str.substring(1));
	        } else {
	            // If they are different, concatenate the first character with the compressed result of the rest of the string
	            return str.charAt(0) + compress(str.substring(1));
	        }
	    }
}
