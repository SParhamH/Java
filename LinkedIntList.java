package Quiz16;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 2/27/2024		
 * Assignment: Write a method removeEvenNumbers(); that removes all even numbers (%2==0) from that list, using the Class provided previously
 */

// Class LinkedIntList can be used to store a list of integers.
// W.P. Iverson version, January 2023
// added clear() method

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: list appears empty
    public void clear() {
        front = null;
    } 

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    //**************************************************************
    //Removes all even numbers
    public void removeEvenNumbers() 
    {
        // Loop to remove any even data
        // Continues until front is not null and front's data is even
        while (front != null && front.data % 2 == 0) 
        {
            front = front.next; // Move front to the next
        }
        
        // If the list is not empty after removing even values
        if (front != null) 
        {
            ListNode current = front; // Initialize current node to front
            
            // loop through the list starting from the second node
            while (current.next != null) 
            {
                // If the next node's data is even
                if (current.next.data % 2 == 0) 
                {
                    current.next = current.next.next; // Remove the next node by skipping it
                } 
                else // If the next node's data is not even
                {
                    current = current.next; // Move to the next node
                }
            }
        }
    }

    
    //**************************************************************

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private static class ListNode {
        public int data;         // data stored in this node
        public ListNode next;  // link to next node in the list

        // post: constructs a node with given data and null link
        public ListNode(int data) {
            this(data, null);
        }

        // post: constructs a node with given data and given link
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
