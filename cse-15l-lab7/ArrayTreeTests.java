import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTreeTests {

	@Test(timeout = 500)
	public void testArrayToBST() {
		int[] treeNodes = { 2, 3, 1 };
		ArrayTree newTree = new ArrayTree(treeNodes);
		assertArrayEquals(new int[] { 2, 1, 3 }, newTree.printTree());
	}

	@Test(timeout = 500)
	public void testArrayToBST2() {
		int[] treeNodes = {};
		ArrayTree newTree = new ArrayTree(treeNodes);
		assertArrayEquals(new int[] {}, newTree.printTree());
	}

	@Test(timeout = 500)
	public void testArrayToBST3() {
		int[] treeNodes = { 4, 5, 6, 2, 3, 1 };
		ArrayTree newTree = new ArrayTree(treeNodes);
		assertArrayEquals(new int[] { 4, 2, 5, 1, 3, 0, 6 }, newTree.printTree());
	}

	@Test(timeout = 500)
	public void testArrayToBST34() {
		int[] treeNodes = { 1, 2, 3, 4 };
		ArrayTree newTree = new ArrayTree(treeNodes);
		assertArrayEquals(new int[] { 1, 0, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4 }, newTree.printTree());
	}
}
