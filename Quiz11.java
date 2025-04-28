package Quiz_Ch11;

import java.util.*;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/16/2024		
 * Assignment: Write a public static method yearMode that accepts a list of CalendarDates as a parameter and returns the number of times the most frequent year occurs.
 *
 * BC CS211
 * Selected Chapter 10 Exercises
 * 
 * W.P. Iverson, January 2024
 */
//Iverson's starter code:
//copyright 2024 Bellevue College
public class Quiz11 {
 public static void main(String[] args34) {
     ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>(625);
     System.out.println(yearMode(list1)); //   0 is returned when list is empty
     list1.add(new CalendarDate(5, 5, 2018));
     list1.add(new CalendarDate(1, 2, 2018));
     list1.add(new CalendarDate(5, 5, 2018));
     list1.add(new CalendarDate(10, 7, 1907));
     list1.add(new CalendarDate(5, 5, 2018));
     System.out.println(yearMode(list1)); //   4 times we have the year 2018
 }

 // solutions go below here:
 public static int yearMode(List<CalendarDate> list)
	{
	 	// Create a map to store the count of occurrences for each year
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		
		// Update the map by counting the number of occurrences for each year
		for (CalendarDate date : list)
		{
			int year = date.getYear();
			map1.put(year, map1.getOrDefault(year, 0) + 1);
		}
		
	// Track the mode (maxYear) and its count (Count)
	 int count = 0;
     int maxYear = 0;
     
     // Find the mode by repeating over the map entries
     for (Map.Entry<Integer, Integer> entry : map1.entrySet()) 
     {
    	 // Retrieve the count of occurrences for the current year
         int currentYear = entry.getValue();
         
         // Check if the current count is greater than the current maximum count
         if (currentYear > maxYear) 
         {
        	 // Update the maximum count
        	 maxYear = currentYear;
         	count = entry.getKey();
         }
     }
		
		return maxYear;
	}
}
