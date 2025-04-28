import java.util.*;
// Chapter 10 of Building Java Programs
// intersect example from PowerPoint slides
//
// adapted by W.P. Iverson
// Bellevue College CS211, January 2020
//
public class Intersect {
	public static void main(String[] a) {
		// Initialize two arrays of integers, same numbers as in lecture
		Integer[] temp1 = {1, 4, 8, 9, 11, 15, 17, 28, 41, 59};
		int[] temp2 = new int[] {4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81};
		//Integer[] temp2 = {4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81};
		// These can be either int or Integer, try both, Java does not care.
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		// TWO DIFFERENT ways to load array in list with loops:
		//for (int i=0; i<temp1.length; i++)
		//	list1.add(temp1[i]);
		// For each integer in the array:
		for (Integer i: temp1) list1.add(i);
		
		// load the second array
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i=0; i<temp2.length; i++)
			list2.add(temp2[i]);
	
		// brute force CS210 way to display intersect
		for (int i=0; i<temp1.length; i++)
			for (int j=0; j<temp2.length; j++)
				if (temp1[i]==temp2[j])
					System.out.print(temp1[i] + " ");
		System.out.println();
		
		// A more elegant way:
		// (internally, this still uses nested loops)
		System.out.println(intersect(list1,list2));
		
		// The answer we should be seeing is:
		//	[4, 11, 17, 28, 59]
	}
	
	// The solution to the problem posed in PowerPoint:
		public static ArrayList<Integer> intersect (ArrayList<Integer> local1, ArrayList<Integer> local2) {
			ArrayList<Integer> local3 = new ArrayList<Integer>();
			for (Integer i: local1)
				if (local2.indexOf(i)>=0) local3.add(i);
			return local3;
		}
}
