package TADs.implementations;

import TADs.implementations.utils.BinaryTreeMethods;
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

			return searchByKey(key, node.getRightChild());

		} else if (node.getLeftChild() != null) {

			return searchByKey(key, node.getLeftChild());

		} else if (node.getRightChild() != null) {

			return searchByKey(key, node.getRightChild());

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

		return BinaryTreeMethods.size(root);

	}


	@Override
	public int countLeaf() {

		return BinaryTreeMethods.countLeaf(root);

	}

	@Override
	public int countCompleteElements() {

		return BinaryTreeMethods.countCompleteElements(root);

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
