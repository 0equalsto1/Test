package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean printLevel(TreeNode root, int level) {
		// base case
		if (root == null) {
			return false;
		}

		if (level == 1) {
			System.out.print(root.val + " ");
			return true;
		}

		boolean left = printLevel(root.left, level - 1);
		boolean right = printLevel(root.right, level - 1);

		return left || right;
	}

	// Function to print level order traversal of a given binary tree
	public static void levelOrderTraversal(TreeNode root) {
		// start from level 1 — till the height of the tree
		int level = 1;

		// run till printLevel() returns false
		while (printLevel(root, level)) {
			level++;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int siz = q.size();
			List<Integer> list = new ArrayList<>(siz);
			for (int i = 0; i < siz; i++) {
				TreeNode nod = q.remove();
				list.add(nod.val);
				TreeNode left = nod.left;
				TreeNode right = nod.right;
				if (left != null)
					q.add(left);
				if (right != null)
					q.add(right);

			}
			res.add(list);
		}
		return res;
	}
}
