class TreeNode {
	TreeNode left;
	TreeNode right;

	int data;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	// set left node 
	public void setLeft(TreeNode n)
    {
        this.left = n;
    }
    // set right node  
    public void setRight(TreeNode n)
    {
        this.right = n;
    }
    // get left node 
    public TreeNode getLeft()
    {
        return this.left;
    }
    // get right node
    public TreeNode getRight()
    {
        return this.right;
    }
    // set data to node
    public void setData(int d)
    {
        this.data = d;
    }
    // get data from node 
    public int getData()
    {
        return data;
    }    
}
