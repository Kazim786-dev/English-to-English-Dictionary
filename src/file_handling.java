import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.*;
public class file_handling {

	// calls whenever program will execute
	public void start(BST tree) throws FileNotFoundException
    {
    	
		File fileobj = new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-3rd semester\\DS\\English Dictionary\\src\\Dictionary.txt");
    	Scanner reader = new Scanner(fileobj);
        while (reader.hasNextLine()) {
        	// pick word fro line and its meaning right after the word
          String word = reader.next();   
          String meaning = reader.nextLine();
         
            // make object and pass to the tree
          Content obj = new Content(word,meaning);
          tree.root=tree.insert(tree.root,obj);
        }
        reader.close();
    }
    
    public Node writeInOrder(Node root, FileWriter writer) throws IOException
    {
    	 
    	if (root == null) {
    		return null;
    	}
          
    	// store data in file through recursion in in-order	
    		
    		writeInOrder(root.left,writer);
    		
    		writer.write(root.value.getWord()+" "+root.value.getMeaning()+"\n");
          
    		writeInOrder(root.right,writer);
        
       
		return root;
    }
    
    public Node writePreOrder(Node root, FileWriter writer) throws IOException
    {
    	 
    	if (root == null) {
    		return null;
        }
          
    	// store data in file through recursion in pre-order	
    		
    		writer.write(root.value.getWord()+" "+root.value.getMeaning()+"\n");
          
    		writePreOrder(root.left,writer);
    		writePreOrder(root.right,writer);
        
       
		return root;
    }
    
    public Node writePostOrder(Node root, FileWriter writer) throws IOException
    {
    	 
    	if (root == null) {
          return null;
    	}
    	// store data in file through recursion in post-order	
    		
    		writePostOrder(root.left,writer);
    		writePostOrder(root.right,writer);
    		
    		writer.write(root.value.getWord()+" "+root.value.getMeaning()+"\n");
        
       
		return root;
    }
    
    // calls at the end to write whole data in file
    public void end(Node root) throws IOException
    {Scanner sc=new Scanner(System.in);
    	FileWriter Writer = new FileWriter("C:\\Users\\Taha Asif\\Documents\\_Assignments-3rd semester\\DS\\English Dictionary\\src\\Dictionary.txt");
    	
    	System.out.println("==>Select order below to save data!");
		System.out.println("1- Pre-Order\n"
				+ "2- In-Order\n"
				+ "3- Post-Order\n");
		int i=0;
		while(i<1||i>3) {
		i=sc.nextInt();
		}
		
		if(i==1) {
			root=writePreOrder(root, Writer);
		}
		else if(i==2) {
			root=writeInOrder(root, Writer);
		}
		else if(i==3) {
			root=writePostOrder(root, Writer);
		}
    	
    	
    	
    	Writer.close();
    }
    
    
}
