// This class fails to compile, can you figure out why, and fix it?
// This is beacuse BinaryTree has a constructor which is not default. Hence, when we extend this class and try to call a no-argument constructor, it'll give a compile-time error. so, we call it by passing the parameters (to instantiate the root node) in super() called inside the constructor of BinarySearchTree

class BinarySearchTree extends BinaryTree {

    private int flag = 0;
    
    public BinarySearchTree()
    {
        super(0);
    }
    
    // insert node
	@Override
	public boolean insert(int value) {
		super.root = insert(super.root, value);
		return true;
	}

    private TreeNode insert(TreeNode root, int data)
    {
        // if current node is null, insert node with data
        if (root == null) root = new TreeNode(data);
        else
        {
            // traverse to left sub-tree if value to be inserted is lesser than value in current node
            if (data <= node.getData()) root.left = insert(root.left, data);
            // traverse to right sub-tree if value to be inserted is greater than value in current node
            else root.right = insert(root.right, data);
        }
        return root;
    }
    
    // delete node
	@Override
	public boolean delete(int value) {
		super.root = deleteRec(super.root, value);
		if(flag==1) {flag=0;return false;}
		else return true;
	}
	
	TreeNode deleteRec(TreeNode root, int key)
    {
        // if tree is empty, set flag to 1 and return root
        if (root == null)  {flag=1;return root;}
 
        // traverse to left sub-tree if value to be inserted is lesser than value in current node
        if (key < root.data) root.left = deleteRec(root.left, key);
        // traverse to right sub-tree if value to be inserted is greater than value in current node
        else if (key > root.data) root.right = deleteRec(root.right, key);
 
        // if value is same as current value, delte it
        else
        {
            // node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
 
            // if node has two children, get the lowest inorder successor from the right subtree 
            root.data = minValue(root.right); 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        } 
        return root;
    }
    
    // find the lowest value in the tree by reaching the leftmost leaf node
    int minValue(TreeNode root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
	
	// check if node exists
	@Override
	public boolean exists(int find) {
		TreeNode tn = search(super.root,find);
		if(flag==1) {flag=0;return false;}
		else return true;
	}
	
	public TreeNode search(TreeNode root, int key)
    {
        // not found
        if(root==null) 
        {
            flag=1;
            return root;
        }
        // if found, return root
        if (root.data==key) return root;
        
        // traverse to left sub-tree if value to be inserted is lesser than value in current node
        if (root.data > key) return search(root.left, key);
        // traverse to right sub-tree if value to be inserted is greater than value in current node
        return search(root.right, key);
    }

    // lowest common ancestor
	@Override
	public TreeNode lowestCommonAncestor(int value1, int value2) {
		
		TreeNode tn = lca(super.root, value1,value2);
		if(flag==1) return null;
		else return tn;
	}
	
	// the node value present in between a and b is the lca. Assuming, a<b
	public TreeNode lca(TreeNode root, int a, int b)
	{
	    if(root == null) {flag=1;return null;}
	    
	    if(root.data>b && root.data>a) lca(root.left,a,b);
	    else if(root.data<b && root.data<a) lca(root.right,a,b);
	    
	    return root;
	}
}
