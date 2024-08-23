package leetcode;

import tree.TreeNode;

public class IsMirrorTree {

	public static void main(String[] args) {
	}

	public boolean isSymmetric(TreeNode root) {
		return isSymmetricMy(root.left, root.right);

	}

	public boolean isSymmetricMy(TreeNode l, TreeNode r) {
		if (l == null && r == null)
			return true;
		if (l == null || r == null)
			return false;

		return (l.val == r.val) && isSymmetricMy(l.left, r.right) && isSymmetricMy(l.right, r.left);

	}
}
