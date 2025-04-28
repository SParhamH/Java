package Assignment15b;

/** Name: SeyedParham Hamzei	Course: CS211	Quarter: Winter		Date: 2/20/2024		
 * Assignment: Exercise 15.11: Write a method called removeLast that removes and returns the last value from a list of integers.
 *  		   Exercise 15.12: Write a method removeFront that takes an integer n as a parameter and that removes the first n values from a list of integers.
 *  		   Exercise 15.13: Write a method removeAll that takes an integer value as a parameter and that removes all occurrences of the given value from the list.
 *  		   Exercise 15.15: Write a method mirror that doubles the size of a list of integers by appending the mirror image of the original sequence to the end of the list. 
 *  		   Exercise 15.16: Write a method called stutter that replaces every value with two of that value.
 *  		   *** generic <E> data ***
 */

/* 
 * Generic <E> ArrayList Class from Building Java Programs
 * slightly modified by W.P. Iverson, Bellevue College
 * January 2024, I have changed:
 * 			default capacity to 10 as  Oracle also does
 * 			uses private inner Class with Iterator<E>
 * 			made Class Iterable<E> as already posted on BJP site
 */

// Class ArrayList<E> can be used to store a list of values of type E.
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements Iterable<E> {
    private E[] elementData; // list of values
    private int size;        // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 10;

    // post: constructs an empty list of default capacity
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        size = 0;
    }
    
// EXERCISE CODE GOES HERE, to keep it organized, might be on a Quiz some day???
    
    // Exercise #1
    // modified from https://github.com/Creede15/practice-it/blob/master/chapter-7
    // DO NOT just copy/paste all, as you will learn nothing!
    // This is also identical to form of indexOf below, from BJP text code
    // if you get stuck on an exercise, maybe take a peek, close, then write your own
    public int lastIndexOf(E value) {  // changed to non-static and generic <E>
        for (int i = size() - 1; i >= 0; i--) {
        	//System.out.println(elementData.length); // needed some debug help along the way
            if (elementData[i].equals(value)) { // CHANGE to E, use method, NOT primitive
                return i;
            }
        }
        return -1;
    }
    
  //**************************************************************************************
    // Exercise #11
    public E removeLast() {
        // Check if the list is empty
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        
        // Get the last element before removing it
        E lastValue = elementData[size - 1];
        
        // Decrement the size to remove the last element
        size--;
        
        // Return the removed value
        return lastValue;
    }
    
 // Exercise #12
    public void removeFront(int num) {
        // Iterate through the elements up to the specified number of elements to remove
        for (int i = 0; i < num; i++) {
            // Shift the elements to the left by num positions
            // Replace the current element at index i with the element at index num + i
            elementData[i] = elementData[num + i];
        }
        
        // Update the size of the list by subtracting the number of elements removed
        size -= num;
    }
    
 // Exercise #13
    public void removeAll(E value) {
        // Iterate through the elements of the list
        for (int i = 0; i < size; i++) {
            // Check if the current element equals the specified value
            if (elementData[i].equals(value)) { // Use equals method for comparison
                // If the element matches the value, remove it from the list
                remove(i);
                // Decrement the loop variable to re-check the same index in case of consecutive occurrences of the value
                i--;
            }
        }
    }
    
 // Exercise #15
    public void mirror() {
        // Iterate through the elements of the list in reverse order
        for (int i = size - 1; i >= 0; i--) {
            // Add each element at index i to the end of the list
            add(elementData[i]);
        }
    }

    
 // Exercise #16
    public void stutter() {
        // Double the size of the list
        int newSize = size * 2;
        E[] newArray = (E[]) new Object[newSize]; // Create a new array of type E

        // Copy each element twice
        for (int i = 0; i < size; i++) {
            newArray[2 * i] = elementData[i];
            newArray[2 * i + 1] = elementData[i];
        }

        // Update the list with the new array and size
        elementData = newArray;
        size = newSize;
    }
    
    //**************************************************************************************

// EXERCISE END.  Class structure below from BJP textbook www.buildingjavaprograms.com

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
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
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayList<E> other) {
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private class ArrayListIterator implements Iterator<E> {
        private int position;           // current position within the list
        private boolean removeOK;       // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public ArrayListIterator() {
            position = 0;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < size();
        }

        // pre : hasNext() (throws NoSuchElementException if not)
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (throws
        //       IllegalStateException if not)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }
}
