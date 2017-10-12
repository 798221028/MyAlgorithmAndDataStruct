package com.algorithm.demo;

/*
 * Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between tow nodes
 * w and v as the lowest node in  T that has both v and w as descendants (where we allow a node to be a descendant
 * of itself)" 
 */
public class LowestCommonAncestorBST {

	/*
	 * 对于二叉搜索树，公共祖先的值一定大于等于较小的节点，小于等于较大的结点。
	 * 换言之，在遍历树时，如果当前结点大于两个节点，则结果在当前节点的左子树里，如果当前结点小于两个节点，则结果在当前结点的右子树里。
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		int pcmp = root.v.compareTo(p.v);
		int qcmp = root.v.compareTo(q.v);
		if (pcmp < 0 && qcmp < 0) {
			
			return lowestCommonAncestor(root.right, p, q);
		} else if (pcmp > 0 && qcmp > 0) {
			
			return lowestCommonAncestor(root.left, p, q);
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
	}
}
