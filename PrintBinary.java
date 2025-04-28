import java.util.*;
//
// from W.P. Iverson CS211 lectures
//

public class PrintBinary {
	public static void main(String[] args) {
		printBinary(31);
		String test = "mica";
		//combinations(test,3);
		//System.out.println(permut(test.length(),3));
            //moveDisks(3, 'A', 'B', 'C');
	}
	
	// Prints the given integer's binary representation.
	// Precondition: n >= 0
	public static void printBinary(int n) {
	    if (n < 2) {
	        // base case; same as base 10
	        System.out.println(n);
	    } else {
	        // recursive case; break number apart
	        printBinary(n / 2);
	        printBinary(n % 2);
	    }
	}
	
	// From PowerPoint slides, handles output
	public static void combinations(String s, int length) {
	    Set<String> all = new TreeSet<String>();
	    combinations(s, "", all, length);
	    for (String comb : all) {
	        System.out.println(comb);
	    }
	    System.out.println(all.size());
	}

	// Recurse through combinations
	private static void combinations(String s, String chosen,
	                                 Set<String> all, int length) {
	    if (length == 0) {
	        all.add(chosen);         // base case: no choices left
	    } else {
	        for (int i = 0; i < s.length(); i++) {
	            String ch = s.substring(i, i + 1);
	            if (!chosen.contains(ch)) {
	                String rest = s.substring(0, i) + s.substring(i + 1);
	                combinations(rest, chosen + ch, all, length - 1);
	            }
	        }
	    }
	}
}
