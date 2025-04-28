package Assignment16;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 2/26/2024		
 * Assignment: 16.7: Write a method deleteBack that deletes the last value and returns the deleted value.
 * 			   16.8: Write a method switchPairs that switches the order of elements in a linked list of integers in a pairwise fashion. 
 * 					 Method should switch the order of the first two values, then switch the order of the next two, switch the order of the next two, and so on.
 *			   16.9: Write a method stutter that doubles the size of a list by replacing every integer in the list with two of that integer.
 *			   16.14: Write a method removeAll that removes all occurrences of a particular value.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

// Class LinkedList<E> can be used to store a list of values of type E.
// from https://www.buildingjavaprograms.com/code-files/5ed/ch16/LinkedList.java
// modified by W.P. Iverson, Bellevue College, January 2017-2024 
// added backwards() method to check list in backwards order
// removed implements List<E> due to version differences of List
// so the addAll method now limited to addAll(LinkedList<E>)
// limited imports so working with mostly our code rather than Oracle versions

public class LinkedList<E extends Comparable<E>> implements Iterable<E> {  

    private ListNode<E> front;  // first value in the list
    private ListNode<E> back;   // last value in the list
    private int size;           // current number of elements

    // NOTE: an empty list has TWO Nodes to mark front and back
    // post: constructs an empty list
    public LinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }
    
// ADD MORE METHODS HERE (like for assigned CS211 work):
 //************************************************************************************************
 // Deletes Back
    public E deleteBack() 
    {
        // Check if the list is empty
        if (front == null) {
            // Throw a NoSuchElementException
            throw new NoSuchElementException("List is empty");
        }

        // Get the node before the last node
        ListNode<E> current = back.prev;
        // Get the value of the last node
        E value = current.data;
        // Adjust the links to remove the last node from the list
        current.prev.next = back;
        back.prev = current.prev;
        // Decrease the size of the list
        size--;
        // Return the value
        return value;
    }

    // Switches Pairs
    public void switchPairs() 
    {
        // Start from the first node after the front
        ListNode<E> current = front.next;
        // Iterate through the list until reaching the node before the back
        
        while (current != back && current.next != back) {
            // Swap the data of the current node with its next node
            E temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            // Move to the next pair of elements
            current = current.next.next;
        }
    }

    // Stutter
    public void stutter() 
    {
        // Start from the first node after the front
        ListNode<E> current = front.next;
        // Iterate through the list until reaching the back dummy node
        
        while (current != back) {
            // Create a new node with the same data as the current node
            ListNode<E> newNode = new ListNode<E>(current.data, current.next, current);
            // Insert the new node after the current node
            current.next = newNode;
            // Move to the next original node
            current = newNode.next;
            // Increase the size of the list
            size++;
        }
    }

    // Removes All 
    public void removeAll(E value) {
        // Start from the first node after the front dummy node
        ListNode<E> current = front.next;
        
        // Iterate through the list until reaching the back dummy node
        while (current != back) {
            // Check if the data of the current node is equal to the given value
            if (current.data.equals(value)) {
                // Adjust the links to remove the current node from the list
            	
            	//Just for better understanding
                current.prev.next = current.next;  
                //means that the next reference of the node before current should be updated to skip current and point directly to current.next
                current.next.prev = current.prev;
                //means that the prev reference of the node after current should be updated to skip current and point directly to current.prev 
                
                // Decrease the size of the list
                size--;
            }
            // Move to the next node
            current = current.next;
        }
    }
    
  //************************************************************************************************
    
    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Iverson creation
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.prev.data;
            ListNode<E> current = back.prev.prev;
            while (current != front) {
                result += ", " + current.data;
                current = current.prev;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    public void add(E value) {
        add(size, value);
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> newNode = new ListNode<E>(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(LinkedList<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }

    // post: list is empty
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private static class ListNode<E> {
        public E data;         // data stored in this node
        public ListNode<E> next;  // link to next node in the list
        public ListNode<E> prev;  // link to previous node in the list

        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedIterator implements Iterator<E> {
        private ListNode<E> current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}