abstract class BinaryTree {
	protected TreeNode root;

	/* While this constructor cannot be called directly,
	   it is useful because the child classes can use it,
	   by using super(), to instantiate the root node
	 */
	public BinaryTree(int rootValue) {
		this.root = new TreeNode(rootValue);
	}

	public void inOrderTraversal() {
		//TODO
	}

	public void preOrderTraversal() {
		//TODO
	}

	public void postOrderTraversal() {
		//TODO
	}

	/*NOTE: Think about why these methods are abstract.
		Why can't we just implement them like we did for the traversals?
	*/

	/* Insert a node with the given value into the tree
	   Return true if the insert succeeds, else return false.

	   This is a signature similar to the one we saw in the CFW.
	*/
	public abstract boolean insert(int value);

	/* Delete the node with the given value from this tree, and
		return the deleted node. Return null if the value doesn't exist.
	 */
	public abstract TreeNode delete(int value);

	/* Return true if the given value exists in the tree
	 */
	public abstract boolean exists(int find);

	/* Return the node that is the LCA of the two given values.

	   Return null if either or both of the values doesn't exist in the tree.
	 */
	public abstract TreeNode lowestCommonAncestor(int value1, int value2);

}
