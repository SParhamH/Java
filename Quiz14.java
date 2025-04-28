package Ouiz_Ch14;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 2/13/2024		
 * Assignment: Write a method removeEvenNumbers that accepts a Stack parameter, and removes all the even numbers (%2==0) from that Stack
 */
//Use Iverson Stack (push, pop, size, empty, toString) 
//copyright 2024 Bellevue College
public class Quiz14 {
	public static void main(String[] arg495) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); stack.push(8);  stack.push(7);  stack.push(2); 
		stack.push(9); stack.push(18); stack.push(2*89); stack.push(0); 

		System.out.println("bottom " + stack.toString() + " top");
		removeEvenNumbers(stack);
		System.out.println("bottom " + stack.toString() + " top");
	} // your solution should follow below
	
	public static void removeEvenNumbers(Stack<Integer> stack) 
	{
        Stack<Integer> tempStack = new Stack<Integer>(); // Temporary stack to hold non-even numbers

        // Remove even numbers from the original stack
        while (!stack.empty()) 
        {
            int num = stack.pop();
            if (num % 2 != 0) 
            { // If number is not even, add it to temporary stack
                tempStack.push(num);
            }
        }

        // Push back the non-even numbers to the original stack
        while (!tempStack.empty()) 
        {
            stack.push(tempStack.pop());
        }
    }
}
