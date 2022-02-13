import java.io.IOException;
import java.util.Scanner;

public class main {

	 @SuppressWarnings("unchecked")
		public static void main(String[] args) throws IOException {
	    	
	    	
	    	file_handling fileobj = new file_handling();
	    	BST<Content> dictobj = new BST<Content>();
	    	Scanner sc = new Scanner(System.in);
	    	
	    	fileobj.start(dictobj);
	    	
	    	boolean execute=true;
	    	
	    	System.out.println("\n----------WELCOME----------\n");
	    	
	    	while(execute)
	    	{
	    	
	    	System.out.println("1. Search a word from dictionary");
	    	System.out.println("2. Enter a new word in dictionary");
	    	System.out.println("3. Delete a word from dictionary");
	    	System.out.println("4. Display all words of dictionary");
	    	System.out.println("5. Exit");
	    	 
	    //take input what user wanna do
	    	int input = sc.nextInt();   
	    	
	    	if(input==1)
	    	{
	    		System.out.println("Please enter word you want to search");
	    		String word = sc.next();
	    		dictobj.search(dictobj.root,word);
	    	}
	    	else if(input==2)
	    	{
	    		System.out.println("Enter the name of the new word you want to insert");
	    		String word = sc.next();
	    		@SuppressWarnings("unused")
				String waste = sc.nextLine();
	    		System.out.println("Enter the meaning");
	    		String mean = sc.nextLine();
	    		Content o1 = new Content(word,mean);
	    		dictobj.root=dictobj.insert(dictobj.root, o1);
	    	}
	    	else if(input==3)
	    	{
	    		System.out.println("Please enter word you want to delete");
	    		String w = sc.next();
	    		dictobj.root=dictobj.deleteNode(dictobj.root, w);
	    	}
	    	else if(input==4) {
	    		
	    		System.out.println("==>Select order below");
	    		System.out.println("1- Pre-Order\n"
	    				+ "2- In-Order\n"
	    				+ "3- Post-Order\n");
	    		int i=0;
	    		while(i<1||i>3) {
	    		i=sc.nextInt();
	    		}
	    		
	    		if(i==1) {
	    			dictobj.preOrder(dictobj.root);
	    		}
	    		else if(i==2) {
	    			dictobj.inOrder(dictobj.root);
	    		}
	    		else if(i==3) {
	    			dictobj.postOrder(dictobj.root);
	    		}
	    		System.out.println("\n");
	    	}
	    	else if(input==5) {
	    		execute=false;
	    		
	    	}
	    }
	    	fileobj.end(dictobj.root);
	    	
	    	System.out.println("\n==>Data stored in file SUCCESSFULLY!\n");
	    }  
	
	
}
