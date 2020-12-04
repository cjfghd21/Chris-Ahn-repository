import java.util.ArrayList;

/**
 * This is a MorseCode tree used to convert morse code into English. 
 * @author Cheolhong Ahn
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	private String fetchLetter;
	
	/**
	 * Constructor - calls the buildTree method
	 * 
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	
	
	/**
	 * Returns the reference to the root
	 *@return reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	/**
	 *This method sets the root of the MorseCodeTree
	 *
	 *@param - copy of newNode will be new root
	 *
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}

	/**
	 * Adds the element to the tree based on the code. Calls recursive method addNode
	 * @param code - morse code for the new node to be added
	 * @param letter - letter corresponding to the morse code
	 * @return MorseCodeTree with the node added
	 */
	public MorseCodeTree insert(String code, String result) {
		
		addNode(root,code,result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position on the tree
	 * based on the code.
	 *@param root - root of the tree for the recursive instance of addNode
	 *@param code - code for particular recursive instance
	 *@param letter - data of new TreeNode to be added
	 *
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1)
		{	
			
			if(code.equals("."))
			{	
				
				root.leftChild = new TreeNode<String>(letter);
			}
			else if(code.equals("-")) 
			{	
				
				root.rightChild= new TreeNode<String>(letter);
			}
			return;
		}
		else {
			if(code.charAt(0) == '.') 
			{
				root = root.leftChild;
			}
			else if(code.charAt(0) == '-')
			{
				root = root.rightChild;
			}
			code = 	code.substring(1);
			addNode(root, code, letter);
		}
		
	}

	/**
	 * Fetch the data in the tree based on code. Calls recursive method fetchNode
	 *@param - morse code to retrieve the letter
	 *@return String that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		
		String letter = fetchNode(root,code);
		return letter;
	}

	/**
	 *Recursive method to fetch data from TreeNode that corresponds with the code.
	 *@param root - the root of the tree for this particular instance.
	 *@param code - the code for this particular instance.
	 *@return the string letter corresponding to the morse code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		if(code.length() == 1)
		{
			if(code.equals(".")) {
				fetchLetter = root.leftChild.getData();
			}
			else if(code.equals("-")) {
				fetchLetter = root.rightChild.getData();
			}
			
		}
		else {
			if(code.charAt(0) == '.') 
			{
				fetchNode(root.leftChild, code.substring(1));
			}
			else if(code.charAt(0) == '-') 
			{
				fetchNode(root.rightChild, code.substring(1));
			}
		}
		return fetchLetter;
	}

	/**
	 *unsupported feature in this tree class
	 *@param data - node to be deleted
	 *@return reference to the current tree
	 *@throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		
		return this;
	}

	/**
	 *unsupported feature in this tree class
	 *@return reference to the current tree
	 *@throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		
		return this;
	}

	/**
	 *This method builds the MorseCodeTree that is four level high.
	 *Root has value of empty string
	 */
	@Override
	public void buildTree() {
		root = new TreeNode<String>("");
		//first level
		insert(".", "e");
		insert("-", "t");
		
		//second level
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//third level
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
	    insert("-.-", "k");
	    insert("--.", "g");
	    insert("---", "o");
	    
	    //fourth level
	    insert("....", "h");
	    insert("...-", "v");
	    insert("..-.", "f");
	    insert(".-..", "l");
	    insert(".--.", "p");
	    insert(".---", "j");
	    insert("-...", "b");
	    insert("-..-", "x");
	    insert("-.-.", "c");
	    insert("-.--", "y");
	    insert("--..", "z");
	    insert("--.-", "q");

	}

	/**
	 * Returns Arraylist of the items of tree in inorder traversal order.
	 *@return Arraylist of items in the tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> tree = new ArrayList<String>();
		LNRoutputTraversal(root, tree);
		return tree;
	}

	/**
	 * Recursive method that puts the content of the tree in an Arraylist in inorder.
	 *@param root - root of the tree for this particular instance of recursive method
	 *@param list - arraylist that will hold the contents of the tree
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null)
		{
			LNRoutputTraversal(root.leftChild,list);
			list.add(root.getData());
			LNRoutputTraversal(root.rightChild,list);
		}
		
	}

}
