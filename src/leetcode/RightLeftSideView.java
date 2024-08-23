package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class RightLeftSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	private int maxLevel;

	public List<Integer> leftSideViewR(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		maxLevel = 0;
		leftSideViewR(root, list, 0);
		return list;
	}

	public void leftSideViewR(TreeNode r, List<Integer> list, int level) {

		if (r == null)
			return;
		if (level == maxLevel) {
			list.add(r.val);
			maxLevel++;
		}
		leftSideViewR(r.left, list, level + 1);
		leftSideViewR(r.right, list, level + 1);

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		maxLevel = 0;
		rightSideViewR(root, list, 0);
		return list;
	}

	public void rightSideViewR(TreeNode r, List<Integer> list, int level) {

		if (r == null)
			return;
		if (level == maxLevel) {
			list.add(r.val);
			maxLevel++;
		}
		rightSideViewR(r.right, list, level + 1);
		rightSideViewR(r.left, list, level + 1);

	}

	public List<Integer> rightSideViewQ1(TreeNode root) {
		List<Integer> rightSideView = new ArrayList<>();
		if (root == null)
			return rightSideView;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i == size - 1)
					rightSideView.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return rightSideView;
	}

	public List<Integer> rightSideViewQ2(TreeNode root) {

		List<Integer> rightSideView = new ArrayList<>();
		if (root == null)
			return rightSideView;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i + 1 == 1)
					rightSideView.add(node.val);
				if (node.right != null)
					q.add(node.right);
				if (node.left != null)
					q.add(node.left);

			}
		}
		return rightSideView;

	}

	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> leftSideView = new ArrayList<>();
		if (root == null)
			return leftSideView;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i == size - 1)
					leftSideView.add(node.val);
				if (node.right != null)
					q.add(node.right);
				if (node.left != null)
					q.add(node.left);
			}
		}
		return leftSideView;
	}

	public List<Integer> leftSideView2(TreeNode root) {
		List<Integer> leftSideView = new ArrayList<>();
		if (root == null)
			return leftSideView;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (i + 1 == 1)
					leftSideView.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return leftSideView;
	}
}
