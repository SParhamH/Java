package Quiz_Ch10;
import java.util.ArrayList;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/16/2024		
 * Assignment: Removes the dates with an odd numbered month from an ArrayList of CalendarDates.
 */

import Assignment10.CalendarDate;

public class Quiz10 
{
	public static void main(String[] a488) 
	{
        ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>(702);
        dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 7, 2017));
        dates.add(new CalendarDate(10, 5, 2020));
        System.out.println("Before: " + dates); // 4 items in list
        removeOddMonths(dates);
        System.out.println(" After: " + dates); // now fewer items
	}
	
	public static void removeOddMonths(ArrayList<CalendarDate> list)
	{
		if (list.isEmpty())	//Checking if the input list (ArrayList<CalendarDate> list) is empty using the isEmpty method.
        {
            return;
        }
		

        for (int i = list.size() - 1; i >= 0; i--) 
        {
        	CalendarDate date = list.get(i);
        	
            if (date.getMonth() % 2 != 0) // Check if the month is odd
            {
            	list.remove(i);  // Remove the date with an odd month
            }
        }
	}
}
