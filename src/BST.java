
import java.util.Scanner;
import java.io.IOException;

public class BST<T extends Comparable> {

	Node<Content> root=null;  
	  
    
	
	Node rightRotate(Node node) {
        Node x = node.left;
        Node T2 = x.right;
 
        x.right = node;
        node.left = T2;
 
         
        node.Height = Math.max(height(node.left), height(node.right)) + 1;
        x.Height = Math.max(height(x.left), height(x.right)) + 1;
 
        
        return x;
    } // right rotate method ended
 
    Node leftRotate(Node node) {
        Node y = node.right;
        Node T2 = y.left;
 
        y.left = node;
        node.right = T2;
 
        node.Height = Math.max(height(node.left), height(node.right)) + 1;
        y.Height = Math.max(height(y.left), height(y.right)) + 1;
 
        
        return y;
    } // left rotate method ended
    
    public int height(Node node) {
        
		if (node == null)
            return -1;
 
        return node.Height;
    }
    
    int getBalance(Node node) {
        if (node == null)
            return 0;
 
        return height(node.left) - height(node.right);
    }
    
    // method to find node contains minimum value
    Node minValueNode(Node node)
    {
        Node current = node;
 
        // loop down to find the leftmost leaf as leftmost value is minimum
        while (current.left != null)
        current = current.left;
 
        return current;
    }
    
    
 // method to insert value in tree
    Node insert(Node node, Content key) {

    	if (node == null) {
    		return (new Node(key));
    	}
    	if(key.getWord().equalsIgnoreCase(node.value.getWord())){ 
    		//     System.out.println(" Sorry! Duplicate words Can't be inserted in dictionary.Try some different");
    		return node;  // stop duplicate values
    	}
    	if (key.getWord().compareTo(node.value.getWord())<0)
    		node.left = insert(node.left, key);
    	else if (key.getWord().compareTo(node.value.getWord())>0)
    		node.right = insert(node.right, key);
    	node.Height = 1 + Math.max(height(node.left),height(node.right));
    	int balance = getBalance(node);  

    	if (balance > 1 && key.getWord().compareTo(node.left.value.getWord())<0)
    		return rightRotate(node);

    	if (balance < -1 && key.getWord().compareTo(node.right.value.getWord())>0)
    		return leftRotate(node);

    	if (balance > 1 && key.getWord().compareTo(node.left.value.getWord())>0) {
    		node.left = leftRotate(node.left);
    		return rightRotate(node);
    	}

    	if (balance < -1 && key.getWord().compareTo(node.right.value.getWord())<0) {
    		node.right = rightRotate(node.right);
    		return leftRotate(node);
    	} 
    	return node;
    } // insert method ended
  
    
   // method for deletion from tree
    	
    	Node deleteNode(Node root, String key)
        {
            
            if (root == null)
                return root;
     
            if (key.compareTo(root.value.getWord())<0) {
            	root.left = deleteNode(root.left, key);
                }
     
            else if (key.compareTo(root.value.getWord())>0) {
                root.right = deleteNode(root.right, key);
            }
     
            else
            {
     
                // node with only one child or no child
                if ((root.left == null) || (root.right == null))
                {
                    Node temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;
     
                    // if for No child 
                    if (temp == null)
                    {
                        temp = root;
                        root = null;
                    }
                    else // else for one child
                        root = temp; // Copy the contents of non-empty child
                            
                }
                else
                {
                    Node temp = minValueNode(root.right);
     
                    root.value = temp.value;
     
                    root.right = deleteNode(root.right, temp.value.getWord());
                    
                }
            }
     
            // return if node is null
            if (root == null)
                return root;
     
            // to update the height
            root.Height = Math.max(height(root.left), height(root.right)) + 1;
     
            int balance = getBalance(root);  // to get balance of node
     
       // cases for imbalanced root
            
            if (balance > 1 && getBalance(root.left) >= 0)
                return rightRotate(root);
     
            if (balance > 1 && getBalance(root.left) < 0)
            {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
     
            if (balance < -1 && getBalance(root.right) <= 0)
                return leftRotate(root);
     
            if (balance < -1 && getBalance(root.right) > 0)
            {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
     
            return root;
        } // deletion method endeds
    	
    
   // print in in-order 
     
    void inOrder(Node node) {
        if (node == null) {
        	return;
        }
        	inOrder(node.left);
        	System.out.print(node.value);
        	inOrder(node.right);		    	
    }
   
 // print in pre-order 
    
    void preOrder(Node node) {
        if (node == null) {
        	return;
        }
            System.out.print(node.value);
        	inOrder(node.left);
        	inOrder(node.right);		    	
    }
 // print in post-order 
    
    void postOrder(Node node) {
        if (node == null) {
        	return;
        }
        	inOrder(node.left);
        	inOrder(node.right);
        	System.out.print(node.value);
    }
    
    // method to find entered word in dictionary in pre-Order and print meaning of word
    void search(Node node, String input) {
    	
    	 if (node != null) {
             
    		 // compare if word of node matches with input word
         	if(node.value.getWord().equalsIgnoreCase(input)) {
         		
         		System.out.println(" Given word: "+input);
         		System.out.println(" Meaning:  "+node.value.getMeaning());
         		System.out.println("\n------------------\n");
         		return;
         	}
         	search(node.left,input);
         	search(node.right,input);
         }
    }

    
   
}
