package com.algorithm.demo;

/*
 * Lowest Common Ancestor of a Binary Tree
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class LowestCommonAncestorBT {

	/*
	 * 采用深度优先搜索，从叶子结点向上，标记子树中出现目标节点的情况。如果子树中有目标节点，标记为那个节点，如果没有，标记为 null。
	 * 显然，如果左子树，右子树都有标记，说明已经找到最小公共祖先了。
	 * 
	 * 换个角度，如果一个节点左子树有两个目标节点中的一个，右子树没有，那这个节点肯定不是最小公共祖先。
	 * 如果一个节点右子树有两个目标节点中的一个，左子树没有，那这个节点肯定不是最小公共祖先。只有一个节点正好左子树有，右子树也有的时侯，
	 * 才是最小公共祖先。
	 * 
	 * 后序遍历：如果这个两个节点不在一条线上，则它们必定分别在所求节点A的左子树和右子树上，后序遍历到第一个满足这个条件的节点就是所要求的节点A。
	 * 否则，当这两个节点在一条线上，所求节点A就是这两个节点中深度最低的父节点。
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		// 发现目标节点，通过返回值标记该子树发现了某个目标结点
		if (root == null || root == p || root == q) {
			return root;
		}
		
		// 查看左子树中是否有目标结点，没有为 null
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		
		// 查看右子树中是否有目标结点，没有为 null
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		// 都不为空，说明左右子树都有目标结点，则公共祖先就是本身
		if (left != null && right != null) {
			return root;
		}
		
		// 如果发现了目标结点，则继续向上标记为该目标结点
		return left == null ? right : left;
	}
	
	public static void main(String[] args) {
		
		
	}
}
