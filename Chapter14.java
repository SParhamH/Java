package Assignment14;

import java.util.LinkedList;
import java.util.Queue;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 2/12/2024		
 * Assignment: 14.2: Write a method stutter that takes a stack of integers as a parameter and replaces every value in the stack with two occurrences of that value.
 * 			   14.5: Write a method equals that takes as parameters two stacks of CalendarDate and returns true if the two stacks are equal and that returns false otherwise.
 *			   14.15: Write a method isSorted that accepts a stack of CalendarDate as a parameter and returns true if the elements in the stack occur in ascending (non-decreasing) order from top to bottom, and false otherwise.
 *			   14.19: Write a method removeMin that accepts a Stack of integers as a parameter and removes and returns the smallest value from the stack.
 */

public class Chapter14 {
    public static void main(String[] args) {
        // store some dates so they can be reused
        CalendarDate[] store = {new CalendarDate(1, 2, 10), new CalendarDate(1, 1, 10),
                new CalendarDate(12, 30, 10)};
        Stack<CalendarDate> testAll = new Stack<CalendarDate>();
        for (CalendarDate i : store) testAll.push(i); // build a Stack
        System.out.println(stutter(testAll)); // 6 dates
        System.out.println(equals(testAll, testAll)); // true
        System.out.println(isSorted(testAll)); // false
        for (int i = 1; i <= 9; i++) testAll.push(new CalendarDate(1, 1, 10));
        removeMin(testAll); // changes the stack parameter
        while (!testAll.empty())
            System.out.println(testAll.pop().longDate()); // only 2 remain
    }

 // Method to stutter the elements of the Stack
    public static Stack<CalendarDate> stutter(Stack<CalendarDate> s) {
        Queue<CalendarDate> q = new LinkedList<CalendarDate>();

        // Copy elements from Stack to Queue twice to stutter
        while (!s.empty()) {
            q.add(s.peek());
            q.add(s.pop());
        }

        // Copy elements from Queue back to Stack
        while (!q.isEmpty())
            s.push(q.remove());

        // Repeat the process to restore original order
        while (!s.empty())
            q.add(s.pop());
        while (!q.isEmpty())
            s.push(q.remove());

        return s;
    }

    // Method to check if two Stacks are equal
    public static boolean equals(Stack<CalendarDate> s1, Stack<CalendarDate> s2) {
        Stack<CalendarDate> storage = new Stack<CalendarDate>();

        // Check if the sizes of the Stacks are equal
        if (s1.size() != s2.size()) {
            return false;
        } else {
            boolean same = true;

            // Compare elements of the Stacks
            while (same && !s1.empty()) {
                CalendarDate date1 = s1.pop();
                CalendarDate date2 = s2.pop();
                if (!date1.equals(date2)) {
                    same = false;
                }
                storage.push(date1);
                storage.push(date2);
            }

            // Restore original elements to the Stacks
            while (!storage.empty()) {
                s2.push(storage.pop());
                s1.push(storage.pop());
            }

            return same;
        }
    }

    // Method to check if the Stack is sorted
    public static boolean isSorted(Stack<CalendarDate> s) {
        Stack<CalendarDate> storage = new Stack<CalendarDate>();
        boolean sorted = true;

        // Check if elements are in non-decreasing order
        while (sorted && s.size() > 1) {
            storage.push(s.pop());
            if (storage.peek().compareTo(s.peek()) > 0) {
                sorted = false;
            }
        }

        // Restore original elements to the Stack
        while (!storage.empty()) {
            s.push(storage.pop());
        }

        return sorted;
    }

    // Method to remove the minimum element from the Stack
    public static CalendarDate removeMin(Stack<CalendarDate> s) {
        Queue<CalendarDate> q = new LinkedList<CalendarDate>();
        CalendarDate min = s.peek();

        // Find the minimum element in the Stack
        while (!s.empty()) {
            CalendarDate date = s.pop();
            q.add(date);

            if (date.compareTo(min) < 0) {
                min = date;
            }
        }

        // Copy non-minimum elements back to the Stack
        while (!q.isEmpty()) {
            CalendarDate date = q.remove();

            if (!date.equals(min)) {
                s.push(date);
            }
        }

        // Restore original elements to the Stack
        while (!s.empty()) {
            q.add(s.pop());
        }

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        return min;
    }
}