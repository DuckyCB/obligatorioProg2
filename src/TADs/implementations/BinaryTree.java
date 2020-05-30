package TADs.implementations;

import TADs.interfaces.MyTree;
import TADs.nodes.NodeBT;
import exceptions.EmptyTreeException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;

public class BinaryTree<K extends Comparable<K>, T> implements MyTree<K, T> {

	private NodeBT<K, T> root;


	private NodeBT<K, T> searchByKey(K key, NodeBT<K, T> node) {

		if (node.getKey().equals(key)) {

			return node;

		} else if (node.getLeftChild() != null && node.getRightChild() != null) {

			NodeBT<K, T> leftNode = searchByKey(key, node.getLeftChild());

			if (leftNode != null) {

				return leftNode;

			}

			NodeBT<K, T> rightNode = searchByKey(key, node.getRightChild());

			if (rightNode != null) {

				return rightNode;

			}

		} else if (node.getLeftChild() != null) {

			NodeBT<K, T> leftNode = searchByKey(key, node.getLeftChild());

			if (leftNode != null) {

				return leftNode;

			}

		} else if (node.getRightChild() != null) {

			NodeBT<K, T> rightNode = searchByKey(key, node.getRightChild());

			if (rightNode != null) {

				return rightNode;

			}

		}

		return null;
	}


	@Override
	public T find(K key) throws EmptyTreeException, KeyNotFoundException {

		if (root != null) {

			NodeBT<K, T> node = searchByKey(key, root);

			if (node != null) {

				return node.getData();

			} else {

				throw new KeyNotFoundException();

			}

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override
	public void insert(K key, T data, K parentKey) throws EmptyTreeException,
			KeyNotFoundException, InvalidInformationException {

		if (root != null) {

			NodeBT<K, T> parent = searchByKey(key, root);

			if (parent != null) {

				NodeBT<K, T> newNode = new NodeBT<>(key, data);

				if (parent.getLeftChild() == null) {

					parent.setLeftChild(newNode);

				} else if (parent.getRightChild() == null) {

					parent.setRightChild(newNode);

				} else {

					throw new InvalidInformationException();

				}

			} else {

				throw new KeyNotFoundException();

			}

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override
	public void delete(K key) throws EmptyTreeException, KeyNotFoundException {

		if (root != null) {

			NodeBT<K, T> node = searchByKey(key, root);

			if (node != null) {

				node = null;

			} else {

				throw new KeyNotFoundException();

			}

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override
	public int size() {

		int size = 0;

		if (root != null) {

			return size(root, size);

		} else {

			return size;
		}

	}

	private int size(NodeBT<K, T> node, int size) {

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

	@Override
	public int countLeaf() {

		int leaves = 0;

		if (root != null) {

			return countLeaf(root, leaves);

		} else {

			return leaves;

		}

	}

	private int countLeaf(NodeBT<K, T> node, int leaves) {

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

	@Override
	public int countCompleteElements() {

		int count = 0;

		if (root != null) {

			return countCompleteElements(root, count);

		} else {

			return count;

		}

	}

	private int countCompleteElements(NodeBT<K, T> node, int count) {

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

	@Override // Falta terminar
	public LinkedList<NodeBT<K, T>> inOrder() throws EmptyTreeException {

		if (root != null) {

			LinkedList<NodeBT<K, T>> list = new LinkedList<>();
			return list;

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override // Falta terminar
	public LinkedList<NodeBT<K, T>> preOrder() throws EmptyTreeException {

		if (root != null) {

			LinkedList<NodeBT<K, T>> list = new LinkedList<>();
			return list;

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override // Falta terminar
	public LinkedList<NodeBT<K, T>> postOrder() throws EmptyTreeException {

		if (root != null) {

			LinkedList<NodeBT<K, T>> list = new LinkedList<>();
			return list;

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override // Falta terminar
	public LinkedList<NodeBT<K, T>> byLevel() throws EmptyTreeException {

		if (root != null) {

			LinkedList<NodeBT<K, T>> list = new LinkedList<>();
			return list;

		} else {

			throw new EmptyTreeException();

		}

	}


}
