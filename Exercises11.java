package Assignment11;

import java.util.*;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 1/22/2024		
 * Assignment: Exercise 11.11:  a method symmetricSetDifference that accepts two sets as parameters and returns a new set containing their symmetric set difference.
 * 			   Exercise 11.12: a method contains3 that accepts a List of strings as a parameter and returns true if any single string occurs at least 3 times in the list.
 * 			   Exercise 11.13: a method isUnique that accepts a Map from strings to strings as a parameter and returns true if no two keys map to the same value.
 * 			   Exercise 11.14: a method intersect that takes two Maps of strings to integers as parameters and that returns a new map whose contents are the intersection of the two.
 * 			   Exercise 11.15: Write a method maxOccurrences that accepts a List of integers as a parameter and returns the number of times the most frequently occurring integer (the "mode") occurs in the list.
 *
 * BC CS211
 * Selected Chapter 10 Exercises
 * 
 * W.P. Iverson, January 2024
 */


/**
 * BC CS211
 * Selected Chapter 11 Exercises
 * 
 * W.P. Iverson, January 2024
 */
public class Exercises11
{
    public static void main(String[] a) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        ArrayList<Integer> testListI = new ArrayList<Integer>();
        
        // Build an array of Strings
        String[] arrayS = {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia"};
        ArrayList<String> testListS = new ArrayList<String>();
        
        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);
        Set<String> testSetS = new TreeSet<String>(testListS);
        
        // Build the Set of Integers:
         Set<Integer> testSetI = new TreeSet<Integer>();       
        for (int i: arrayI) testSetI.add(i);
        
        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<String, String>();
        Map<String, Integer> testMapSI = new HashMap<String, Integer>();
        String[] array2 = {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        for (int i=0; i<arrayS.length; i++) testMapSI.put(arrayS[i], i);
         
        // Exercise 11.8
        System.out.println(testSetS);
        System.out.println("maxLength="+maxLength(testSetS));       
        
        // Exercise 11.11 (text pg 759)
        System.out.println(testSetI);
        System.out.println("symmetricSetDifference="+symmetricSetDifference(testSetI,testSetI));
        
        
        // Exercise 11.12
        System.out.println(testListS);
        System.out.println("contains3="+contains3(testListS));
        
        // Exercise 11.13
        System.out.println(testMapSS);
        System.out.println("isUnique="+isUnique(testMapSS));
        
        // Exercise 11.14
        System.out.println(testMapSI);
        System.out.println("intersect="+intersect(testMapSI,testMapSI));
        
        // Exercise 11.15
        System.out.println(testListI);
        System.out.println("maxOccurrences="+maxOccurrences(testListI));
    }
    
    // Exercise 11.8
    public static int maxLength(Set<String> s)
    {
    	int max = 0;
    	
    	Iterator<String> it = s.iterator();
    	
    	while(it.hasNext())
    	{
    		String temp = it.next();
    		if(max < temp.length()) max = temp.length();
    	}
    	
    	return max;
    }
    
    // Exercise 11.11
    public static <T> Set<T> symmetricSetDifference(Set<T> setA, Set<T> setB) 
    {
    	//Creates a new HashSet difference and initializes it with the elements from setA.
        Set<T> difference = new HashSet<>(setA);
        // Iterates through the elements of difference using an Iterator.
        Iterator<T> iterator = difference.iterator();
        while (iterator.hasNext()) 
        {
            T elem = iterator.next();
            //removing common elements between setA and setB
            if (setB.contains(elem)) 
            {
                iterator.remove();
            }
        }

        // Iterates through the elements of setB using a new Iterator.
        iterator = setB.iterator();
        while (iterator.hasNext()) 
        {
            T elem = iterator.next();
            //Adds elements from setB to difference if they are not present in setA.
            if (!setA.contains(elem)) 
            {
                difference.add(elem);
            }
        }

        return difference;
    }
    
    // Exercise 11.12
    public static boolean contains3(List<String> input)
    {
    	//map1 is used to store the count
    	Map<String, Integer> map1 = new HashMap<String, Integer>();
    	
    	//The method repeats through each string in the input list.
    	for(String a : input)
    	{
    		//If the string a is already in the map (map1), its count is increase.
    		if(map1.containsKey(a))
    		{
    			map1.put(a, map1.get(a) + 1);
    			
    			if(map1.get(a) == 3) return true;
    		}
    		
    		//If the string is not in the map, it is added with a count of 1.
    		else map1.put(a, 1);
    	}
    	//If the method hasn't returned true during the iteration, it returns false at the end
    	return false;
    }
    
    // Exercise 11.13
    public static boolean isUnique(Map<String, String> map1)
    {
    	//set1 is used to keep track of unique values
    	Set<String> set1 = new HashSet<String>();
    	
    	//The method repeats through each value in the input map (map1).
    	for(String a : map1.values())
    	{
    		//If the value a is already in the set (set1), the method returns false
    		if(set1.contains(a)) return false;
    		else set1.add(a);
    	}
    	return true;
    }
    
    // Exercise 11.14
    public static Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer>map2)
    {
    	//Creating map3 to store the value we need
    	Map<String, Integer> map3 = new HashMap<String, Integer>();
    	//The method iterates through each key in the key set of the first map
    	for(String a : map1.keySet())
    	{
    		//If the value associated with the key a is the same in both maps, it adds the key-value pair to the result map3
    		if(map2.get(a) == map1.get(a)) map3.put(a, map2.get(a));
    	}
    	
    	return map3;
    }
    
    // Exercise 11.15
    public static int maxOccurrences(List<Integer> list1)
    {
    	//map1 is used to store the count
    	Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    	//max is used to keep track of the maximum number 
    	int max = 0;
    	
    	//The method repeats through each integer in the list
    	for(int a : list1)
    	{
    		//If a is already in the map, it increases the count and updates max if needed
    		if(map1.containsKey(a))
    		{
    			map1.put(a, map1.get(a) + 1);
    			if(max < map1.get(a)) max = map1.get(a);
    		}
    		
    		//If the integer a is not in the map, it adds it with a count of 1
    		else map1.put(a, 1);
    	}
    	return max;
    }
}