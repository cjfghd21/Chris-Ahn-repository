import java.util.ArrayList;


/**
 * @author Cheolhong Ahn
 *
 * @param <T> datatype
 */
public class NotationQueue<T> implements QueueInterface<T> {
	
	private Node<T> front;
	private Node<T> back;
	private int size=0;
	private int sizeLimit =-1;
	
	/**
	 * Constructor with size limit
	 * @param n takes in the size limit of the queue
	 */
	public NotationQueue(int n) {
		front = null;
		back = null;
		sizeLimit = n;
	}
	
	/**
	 * Default Constructor
	 */
	public NotationQueue() {
		front = null;
		back = null;
	}
	
	/**
	 * @param list takes an ArrayList as a parameter, and fills the Queue with the
	 * 	elements of the ArrayList, First element in the ArrayList is the first element in the Queue
	 */
	public NotationQueue(ArrayList<T> lists) {
		fill(lists);

	}
	
	/**
	 *Determines if Queue is empty
	 *@return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
		if (size <= 0)
			return true;
		else
			return false;
	}

	/**
	 * Determines of the Queue is empty
	 * @return true if full false if not.
	 */
	@Override
	public boolean isFull() {
		if ( sizeLimit == size)
			return true;
		else
			return false;

	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		T deq = front.getData();
		front.setData(null);
		front = front.getNext();
		size--;
		
		if(front == null)
			back = null;
		return deq;
	}
	

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return size;
	}
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		Node<T> node = new Node<T>(e);
		if(isFull()) 
		{
			throw new QueueOverflowException();
		}
		
		else if(isEmpty())
		{	
			front = node;
			back = node;
			size++;
			return true;
		}	
		
		else
		{
			back.setNext(node);
			back = node;
			size++;
			return true;
		}
		
	}
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String result="";
		Node<T> current = front;
		if(isEmpty())
			return("");
		while(current != null) {
			result =result + String.valueOf(current.getData());
			current = current.getNext();
		}
		return result;
		
		
	}
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String result="";
		Node<T> current = front;
		if(isEmpty())
			return("");
		while(current != null) {
			result =result + String.valueOf(current.getData());
			if(current.getNext()!=null)
				result = result + delimiter;
			current = current.getNext();
		}
		return result;
	}

	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	@Override
	public void fill(ArrayList<T> list)  {
		ArrayList<T> copy = new ArrayList<T>();
		for(int i=0; i < list.size();i++)
			copy.add(list.get(i));
		
		for(int i=0; i < copy.size();i++) {
			Node<T> node = new Node<T>(copy.get(i));
		
			if(isEmpty())
			{	
				front = node;
				back = node;
				size++;
			}	
			
			else
			{
				back.setNext(node);
				back = node;
				size++;
			}
		}
	}
	
	/**
	 * Node class for linked List.
	 *	
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
		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}
