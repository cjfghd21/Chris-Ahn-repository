import java.util.ArrayList;


/**
 * 
 * @author Cheolhong Ahn
 *
 * @param <T> data type
 */
public class NotationStack<T> implements StackInterface<T> {
	private Node<T> top;
	private int size= 0;
	private int sizeLimit=-1;
	
	
	/**
	 *  Constructor
	 * @param n define size limit of stack 
	 */
	public NotationStack(int n) { 
		top = null;
		sizeLimit = n;
	}
	
	/**
	 * Default constructor
	 */
	public NotationStack() {
		top = null;
	}
	/**
	 * takes an ArrayList as a parameter, and fills the Stack with the elements of the ArrayList,
	 * @param lists
	 */
	public NotationStack(ArrayList<T> lists) {
		fill(lists);

	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
		if (size < 1)
			return true;
		else
			return false;
	}
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if ( sizeLimit == size)
			return true;
		else
			return false;
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		T pop = top.getData();
		top.setData(null);
		top = top.getNext();
		size--;
		
		return pop;
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty())
			throw new StackUnderflowException();
		return top.getData();
	}
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
			if(isFull())
				throw new StackOverflowException();
			else if(isEmpty())
			{
				Node<T> node = new Node<T>(e);
				top = node;
				size++;
				return true;
			}
			else
			{	
				Node<T> oldTop = top;
				top= new Node<T>(e);
				top.next = oldTop;
				size++;
				return true;
			}
		
	
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString()
	{	
		int i =0;
		String[] reverse = new String[size()];
		String result="";
		Node<T> current = top;
		if(isEmpty())
			return("");
		while(current != null) {
			reverse[i] =String.valueOf(current.getData());
			current = current.getNext();
			i++;
		}
		for (int k = reverse.length -1 ; k >= 0;k--)
			result = result + reverse[k];
		return result;
		
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		int i =0;
		int k =0;
		String[] reverse = new String[size()];
		String result="";
		Node<T> current = top;
		if(isEmpty())
			return("");
		while(current != null) {
			reverse[i] =String.valueOf(current.getData());
			current = current.getNext();
			i++;
		}
		for (k = reverse.length -1 ; k >= 0;k--)
		{	
			result = result + reverse[k];
			if(k != 0)
				result = result + delimiter;
		}
		return result;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element in the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE Stack, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the stack
	  */
	public void fill(ArrayList<T> list)  {
		ArrayList<T> copy = new ArrayList<T>();
		for(int i=0; i < list.size();i++)
			copy.add(list.get(i));
		
		for(int i=0; i < copy.size();i++) {
	
		
			Node<T> oldTop = top;
			top= new Node<T>(copy.get(i));
			top.next = oldTop;
			size++;
		}
	}
	
	/**
	 * 
	 * Node class for linked list.
	 * @param <T> data type
	 */
	private class Node<T>
	{
		private T data;
		private Node<T> next;
		public Node(T data) 
		{
			this.data = data;
			this.next = null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getNext() {
			return next;
		}
	
	}

}