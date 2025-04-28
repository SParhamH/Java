package Assignment10;

import java.util.*;
/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/16/2024		
 * Assignment: Exercise 10.2: Write a method swapPairs that switches the order of values in an ArrayList of Strings in a pairwise fashion.
 * 			   Exercise 10.6: Write a method minToFront that takes an ArrayList of CalendarDate as a parameter and that moves the minimum value in the list to the front, 
 * 							  otherwise preserving the order of the elements.
 * 			   Exercise 10.7: Write a method removeDuplicates that takes as a parameter a sorted ArrayList of CalendarDate and that eliminates any duplicates from the list.
 * 			   Exercise 10.12: Write a method markLength4 that takes an ArrayList of Strings as a parameter and that places a string of four asterisks "****" in front of 
 * 							   every string of length 4.
 * 			   Exercise 10.18: Write a method mirror that accepts an ArrayList of Strings as a parameter and produces a mirrored copy of the list as output, 
 * 							   with the original values followed by those same values in the opposite order.
 *
 * BC CS211
 * Selected Chapter 10 Exercises
 * 
 * W.P. Iverson, January 2024
 */
public class Exercises10
{
    public static void main(String[] alot587) {
	    
        // Initialize an array of Strings, then load into a String List:
        String[] arrayS = {"four", "score", "and", "seven", "years", "ago"};
        ArrayList<String> testListS = new ArrayList<String>(); 
        ArrayList<String> testListSempty = new ArrayList<String>();
        for (String s: arrayS) testListS.add(s);
        
        // Use Iverson's CalendarDate, so we MUST use compareTo concept
        ArrayList<CalendarDate> testListC = new ArrayList<CalendarDate>();
        ArrayList<CalendarDate> testListCempty = new ArrayList<CalendarDate>();
        testListC.add(new CalendarDate(10,12,1314));  testListC.add(new CalendarDate(10,12,1314));
        testListC.add(new CalendarDate(2,14,2022));  testListC.add(new CalendarDate(3,21,2022));
         
        // Exercise 10.2
        System.out.println(testListS);
        swapPairs(testListS);
        swapPairs(testListSempty);
        System.out.println("10.2 swapPairs: "+ testListS); 
        System.out.println();
        
        // Exercise 10.6
        System.out.println(testListC);
        minToFront(testListC);
        minToFront(testListCempty);
        System.out.println("10.6 minToFront: " + testListC);
        System.out.println();
        
        // Exercise 10.7
        System.out.println(testListC);
        removeDuplicates(testListC);
        removeDuplicates(testListCempty);
        System.out.println("10.7 removeDuplicates: " + testListC);
        System.out.println();
        
        // Exercise 10.12
        System.out.println(testListS);
        markLength4(testListS);
        markLength4(testListSempty);
        System.out.println("10.12 markLength4: " + testListS);
        System.out.println();
    
        // Exercise 10.18
        System.out.println(testListS);
        mirror(testListS);
        mirror(testListSempty);
        System.out.println("10.18 mirror: " + testListS);
        System.out.println();
    }
    
    public static void swapPairs(ArrayList<String> list) //swapPairs
    {
    	for(int i = 1; i < list.size(); i += 2)	//Start from second number
    	{
    		String temp = list.get(i - 1);	//Get the first element
    		list.set(i - 1, list.get(i));	//Set the second element in the first element
    		list.set(i, temp);	//Set the first element in the second element
    	}
    }
    
    public static void minToFront(ArrayList<CalendarDate> list) //minToFront
    {
        if (list.isEmpty())	//Checking if the input list (ArrayList<CalendarDate> list) is empty using the isEmpty method.
        {
            System.out.println("The list is empty.");
            return;
        }
        
        //The initial assumption is that the first element is the minimum
        CalendarDate min = list.get(0);
        int pos = 0;

        for (int i = 1; i < list.size(); i++) //Loop over the remaining elements in the list
        {
            if (list.get(i).compareTo(min) < 0) //Updating the min and pos if a smaller element is found.
            {
                min = list.get(i);
                pos = i;
            }
        }

        list.remove(pos);
        list.add(0, min);
    }
    
    public static void removeDuplicates(ArrayList<CalendarDate> list) //removeDuplicates
    {
    	int size = list.size();
    
    	for (int i = 0; i < size - 1; i++)  //Using two nested loops to compare each element
    	{
        	CalendarDate firstStr = list.get(i);

        	for (int j = i + 1; j < size; j++) 
        	{
            	CalendarDate secondStr = list.get(j);

            	if (firstStr.equals(secondStr)) //Check if they are equal using
            	{
                	list.remove(j);
                	size--; // Adjust size after removal
                	j--; // Recheck the current index as it now holds a new element
            	}
        	}
    	}
	}
    
    public static void markLength4(ArrayList<String> list) //markLength4
    {
    	for(int i = 0; i < list.size(); i++)	//Use a for loop to check each element
    	{
    		if(list.get(i).length() == 4)	//Check if the length of the string is equal to 4 
    		{
    			list.add(i, "****");
    			i++;	//The loop increases i by 1 to avoid processing the newly added "****" 
    		}
    	}
    }
    
    public static void mirror(ArrayList<String> list) //mirror
    {
        ArrayList<String> newList = new ArrayList<>(list);	// Create a new ArrayList

        for (int i = newList.size() - 1; i >= 0; i--) 
        {
            list.add(newList.get(i)); //Add to the original ArrayList
        }
    }
}