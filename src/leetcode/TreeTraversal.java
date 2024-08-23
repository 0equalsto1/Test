package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class TreeTraversal {

	public static void main(String[] args) {

	}

	// NLR
	public static void recurcivePpreorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		recurcivePpreorder(root.left);
		recurcivePpreorder(root.right);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Stack<TreeNode> stk = new Stack<>();
		stk.push(root);
		while (!stk.isEmpty()) {
			TreeNode node = stk.pop();
			list.add(node.val);
			TreeNode right = node.right;
			if (right != null)
				stk.push(right);
			TreeNode left = node.left;
			if (left != null)
				stk.push(left);

		}
		return list;

	}

	// LRN
	public static void postorderIterative(TreeNode root) {
		// return if the tree is empty
		if (root == null) {
			return;
		}

		// create an empty stack and push the root node
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		// create another stack to store postorder traversal
		Stack<Integer> out = new Stack<>();

		// loop till stack is empty
		while (!stack.empty()) {
			// pop a node from the stack and push the data into the output stack
			TreeNode curr = stack.pop();
			out.push(curr.val);

			// push the left and right child of the popped node into the stack
			if (curr.left != null) {
				stack.push(curr.left);
			}

			if (curr.right != null) {
				stack.push(curr.right);
			}
		}

		while (!out.empty()) {
			System.out.print(out.pop() + " ");
		}
	}
	// LRN
	public static void recurcivePostorder(TreeNode root) {
		if (root == null)
			return;
		recurcivePostorder(root.left);
		recurcivePostorder(root.right);
		System.out.print(root.val + " ");
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				result.addFirst(root.val);
				root = root.right;
			} else {
				TreeNode node = stack.pop();
				root = node.left;
			}
		}
		return result;
	}

	// LNR
	public static void recurciveInorder(TreeNode root) {
		if (root == null)
			return;
		recurciveInorder(root.left);
		System.out.print(root.val + " ");
		recurciveInorder(root.right);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }

	    return list;
	}

}
