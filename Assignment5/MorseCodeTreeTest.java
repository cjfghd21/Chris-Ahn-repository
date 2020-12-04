import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest {
	
	MorseCodeTree tree = new MorseCodeTree();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}

	@Test
	public void testInsert() {
		//test 1
		tree.insert("....", "h");
		String letterFetched = tree.fetch("....");
		assertEquals("h", letterFetched);
		
		//test 2
		tree.insert("-", "t");
		String letterFetched1 = tree.fetch("-");
		assertEquals("t", letterFetched1);
		
	}
	
	@Test
	public void testSetRoot() {
		String root;
		TreeNode<String> test1 = new TreeNode<String>("testing");
		tree.setRoot(test1);
		root = tree.getRoot().getData();
		assertEquals("testing", root);		
	}
	
	@Test
	public void testFetch() {
		
		String letterFetched = tree.fetch("-");
		assertEquals("t", letterFetched);
	}
	
}
