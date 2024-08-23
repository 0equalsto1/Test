package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import tree.TreeNode;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		verticalTraversal(root, 0, map);
		List<List<Integer>> list = new ArrayList<>(map.size());
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	public void verticalTraversal(TreeNode node, int level, Map<Integer, List<Integer>> map) {
		if (node == null)
			return;
		map.putIfAbsent(level, new ArrayList<>());
		map.get(level).add(node.val);
		verticalTraversal(node.left, level - 1, map);
		verticalTraversal(node.right, level + 1, map);

	}
}
