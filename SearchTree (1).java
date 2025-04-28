package Assignment17;

/** Name: SeyedParham Hamzei Course: CS211 Quarter: Winter Date:3/4/2024
2/12/2024
* Exercise #7: Write a method isFull that returns whether or not a binary tree is full. A full binary tree is one in which every node has 0 or 2 children. 
* Exercise #9: Write a method equals that could be added to the IntTree class. The method accepts another binary tree of integers as a parameter and compares the two trees to see if they are equal to each other.
* Exercise #12: Write a method removeLeaves that removes the leaves from a tree. A leaf node that has empty left and right subtrees. 
* remove(data):Add a method remove to the SearchTree class that removes a given element from the tree, if present.  
* Assume that the elements of the SearchTree constitute a legal binary search tree, and remove the value in such a way as to maintain ordering of this search tree.
*/

// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, Building Java Programs
//
// modified by W.P. Iverson, to not allow duplicates added
// added toString()
// Bellevue College, January 2021

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }
    
    // WRITE ADDITIONAL METHODS HERE:  
    

  //******************************************************************************

 // Exercise #7: isFull
 // Returns true if the binary tree is full (every node has 0 or 2 children),
 // otherwise returns false.
 public boolean isFull() {
     return isFull(overallRoot);
 }

 public boolean isFull(SearchTreeNode<E> root) {
     if (root == null) {
         return true; // An empty tree is considered full
     } else if (root.left == null && root.right != null) {
         return false; // A node with only one child is not full
     } if(root.right == null && root.left != null){
    	 return false;
     }else {
         // Recursively check if both subtrees are full
         return isFull(root.left) && isFull(root.right);
     }
 }

 // Exercise #9: equals2
 // Compares two binary trees to see if they are equal.
 // Returns true if they are equal (have the same structure and values),
 // otherwise returns false.
 public boolean equals2(SearchTree<E> tree) {
     return equals2(overallRoot, tree.overallRoot);
 }

 public boolean equals2(SearchTreeNode<E> t1, SearchTreeNode<E> t2) {
     if (t1 == null && t2 == null) {
         return true; // Both nodes are null, they are equal
     } else if (t1 == null || t2 == null) {
         return false; // One node is null while the other is not, they are not equal
     } else if (!t1.data.equals(t2.data)) {
         return false; // Data values are different, trees are not equal
     } else {
         // Recursively check left and right subtrees for equality
         return equals2(t1.left, t2.left) && equals2(t1.right, t2.right);
     }
 }

 // Exercise #12: removeLeaves
 // Removes the leaves from the binary tree.
 // A leaf node is a node with empty left and right subtrees.
 public void removeLeaves() {
     overallRoot = removeLeaves(overallRoot);
 }

 private SearchTreeNode<E> removeLeaves(SearchTreeNode<E> root) {
     if (root == null) {
         return null; // Base case: null node, do nothing
     } else if (root.left == null && root.right == null) {
         return null; // Leaf node, remove it
     } else {
         // Recursively remove leaves from left and right subtrees
         root.left = removeLeaves(root.left);
         root.right = removeLeaves(root.right);
         return root;
     }
 }

 // remove(data)
 // Removes a given element from the tree, if present.
 // Assumes that the elements of the SearchTree constitute a legal binary search tree.
 // Removes the value in such a way as to maintain ordering of this search tree.
 public void remove(E value) {
     overallRoot = remove(overallRoot, value);
 }

 private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
     if (root == null) {
         return null; // Base case: value not found, do nothing
     } else {
         int compare = value.compareTo(root.data);
         if (compare < 0) {
             // Value is in the left subtree
             root.left = remove(root.left, value);
         } else if (compare > 0) {
             // Value is in the right subtree
             root.right = remove(root.right, value);
         } else { // Found the node to remove
             if (root.left == null) {
                 // Replace with right child
                 return root.right;
             } else if (root.right == null) {
                 // Replace with left child
                 return root.left;
             } else {
                 // Replace with the inorder successor (smallest node in the right subtree)
                 root.data = minValue(root.right);
                 // Remove the inorder successor from the right subtree
                 root.right = remove(root.right, root.data);
             }
         }
         return root;
     }
 }

 // Helper method to find the smallest node in a subtree
 private E minValue(SearchTreeNode<E> node) {
     E minValue = node.data;
     while (node.left != null) {
         minValue = node.left.data;
         node = node.left;
     }
     return minValue;
 }

 //******************************************************************************


    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
    
    // toString() added by W.P. Iverson for simple console testing
    // since String is immutable, I've used StringBuilder
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	toString(overallRoot, 0, s);
    	return s.toString();
    }
    
    // similar reverse in order traversal of tree as print sideways
    private void toString(SearchTreeNode<E> root, int level, StringBuilder s) {
        if (root != null) {
            toString(root.right, level + 1, s);
            String temp = new String(); // different for each node
            for (int i = 0; i < level; i++) {
            	temp += "    ";
            }
            s.append(temp + root.data + "\n"); // uses same String in recursions
            toString(root.left, level + 1, s);
        }
    }

    
    
    // a private inner Class for the search tree nodes
    // there is no use for such nodes outside of the SearchTree Class
    // so a private inner Class is appropriate in this case...
    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
