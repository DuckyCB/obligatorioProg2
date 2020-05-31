package TADs.implementations.utils;

import TADs.nodes.NodeBT;

public class BinaryTreeMethods {

	public static <K extends Comparable<K>, T> int size(NodeBT<K, T> root) {

		int size = 0;

		if (root != null) {

			return size(root, size);

		} else {

			return size;
		}

	}

	private static <K extends Comparable<K>, T> int size(NodeBT<K, T> node, int size) {

		if (node.getLeftChild() != null && node.getRightChild() != null) {

			return size + 2 + size(node.getLeftChild(), size) + size(node.getRightChild(), size);

		} else if (node.getLeftChild() != null) {

			return size + 1 + size(node.getLeftChild(), size);

		} else if (node.getRightChild() != null) {

			return size + 1 + size(node.getRightChild(), size);

		} else {

			return size;

		}

	}


	public static <K extends Comparable<K>, T> int countLeaf(NodeBT<K, T> root) {

		int leaves = 0;

		if (root != null) {

			return countLeaf(root, leaves);

		} else {

			return leaves;

		}

	}

	private static <K extends Comparable<K>, T> int countLeaf(NodeBT<K, T> node, int leaves) {

		if (node.getLeftChild() == null && node.getRightChild() == null) {

			return leaves + 1;

		} else if (node.getLeftChild() != null && node.getRightChild() != null) {

			return leaves + countLeaf(node.getLeftChild(), leaves)
					+ countLeaf(node.getRightChild(), leaves);

		} else if (node.getLeftChild() != null) {

			return leaves + countLeaf(node.getLeftChild(), leaves);

		} else { // if (node.getRightChild() != null) {

			return leaves + countLeaf(node.getRightChild(), leaves);

		}

	}


	public static <K extends Comparable<K>, T> int countCompleteElements(NodeBT<K, T> root) {

		int count = 0;

		if (root != null) {

			return countCompleteElements(root, count);

		} else {

			return count;

		}

	}

	private static <K extends Comparable<K>, T> int countCompleteElements(NodeBT<K, T> node, int count) {

		count++;

		if (node.getLeftChild() != null && node.getRightChild() != null) {

			return count + countCompleteElements(node.getLeftChild(), count)
					+ countCompleteElements(node.getRightChild(), count);

		} else if (node.getLeftChild() != null) {

			return count + countCompleteElements(node.getLeftChild(), count);

		} else if (node.getRightChild() != null) {

			return count + countCompleteElements(node.getRightChild(), count);

		} else { // if (node.getLeftChild() == null && node.getRightChild() == null) {

			return count;

		}

	}

}
