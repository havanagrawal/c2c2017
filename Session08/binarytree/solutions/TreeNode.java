class TreeNode {
	TreeNode left;
	TreeNode right;

	int data;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
    // get data from node 
    public int getData() {
        return data;
    }    
}
