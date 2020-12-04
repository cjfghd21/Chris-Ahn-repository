
/**
 * @author Cheolhong Ahn
 *
 * @param <T> - data type of TreeNode
 */
public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	


	/**
	 * Create a new tree with left and right child as null and data set to dataNode
	 * @param dataNode - data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 * Used for making deep copies
	 * @param node - node to make copy
	 */
	public TreeNode (TreeNode<T>node)
	{
		new TreeNode<T>(node);
	}
	
	
	/**
	 * Returrn the data of this TreeNode
	 * @return - the data within the TreeNode
	 */
	public T getData() {
		return data;
	}


}
