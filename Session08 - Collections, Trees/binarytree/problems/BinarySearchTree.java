// This class fails to compile, can you figure out why, and fix it?
class BinarySearchTree extends BinaryTree {

	@Override
	public boolean insert(int value) {
		return false;
	}

	@Override
	public TreeNode delete(int value) {
		return null;
	}

	@Override
	public boolean exists(int find) {
		return false;
	}

	@Override
	public TreeNode lowestCommonAncestor(int value1, int value2) {
		return null;
	}
}
