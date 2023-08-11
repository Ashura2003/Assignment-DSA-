package Assignment;

//Question Number 4(b)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Soln {
    public boolean areBrothers(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        TreeNode parentX = findParent(root, x, null);
        TreeNode parentY = findParent(root, y, null);
        
        if (parentX == null || parentY == null) {
            return false;
        }
        
        return parentX != parentY;
    }
    
    private TreeNode findParent(TreeNode node, int val, TreeNode parent) {
        if (node == null) {
            return null;
        }
        
        if (node.val == val) {
            return parent;
        }
        
        TreeNode leftParent = findParent(node.left, val, node);
        TreeNode rightParent = findParent(node.right, val, node);
        
        return leftParent != null ? leftParent : rightParent;
    }
}
