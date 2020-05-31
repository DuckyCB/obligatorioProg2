package TADs.implementations;

import TADs.implementations.utils.BinaryTreeMethods;
import TADs.interfaces.MyBinarySearchTree;
import TADs.nodes.NodeBT;
import exceptions.DuplicatedKeyException;
import exceptions.EmptyTreeException;
import exceptions.KeyNotFoundException;

public class BinarySearchTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {

	private NodeBT<K, T> root;


	private NodeBT<K, T> searchParentOfKey(K key) throws KeyNotFoundException, EmptyTreeException {

		if (root != null) {

			NodeBT<K, T> parent = root;

			while (parent.getLeftChild() != null || parent.getRightChild() != null) {

				if (parent.getLeftChild().getKey().compareTo(key) == 0 ||
						parent.getRightChild().getKey().compareTo(key) == 0) {

					return parent;

				}

				if (parent.getKey().compareTo(key) < 0) {

					parent = parent.getLeftChild();

				} else {

					parent = parent.getRightChild();

				}

			}

			throw new KeyNotFoundException();

		} else {

			throw new EmptyTreeException();

		}

	}

	@Override
	public T find(K key) throws EmptyTreeException, KeyNotFoundException {

		NodeBT<K, T> parent = searchParentOfKey(key);

		if (parent.getLeftChild() != null) {

			if (parent.getLeftChild().getKey().equals(key)) {

				return parent.getLeftChild().getData();

			}

		} else if (parent.getRightChild().getKey().equals(key)) {

			return parent.getRightChild().getData();

		}
		return parent.getRightChild().getData();

	}

	@Override
	public void insert(K key, T data) throws DuplicatedKeyException {

		NodeBT<K, T> newNode = new NodeBT<>(key, data);
		NodeBT<K, T> node = root;

		if (root != null) {

			NodeBT<K, T> parent = searchParentToInsert(key, root);

			if (parent.getKey().compareTo(key) < 0) {

				parent.setLeftChild(newNode);

			} else {

				parent.setRightChild(newNode);

			}

		} else {

			root = newNode;

		}

	}

	// No se puede mandar un nodo null
	private NodeBT<K, T> searchParentToInsert(K key, NodeBT<K, T> parent) throws DuplicatedKeyException {

		if (parent.getKey().compareTo(key) < 0) {

			if (parent.getLeftChild() != null) {

				if (parent.getLeftChild().getKey().compareTo(key) == 0) {

					throw new DuplicatedKeyException();

				} else {

					return searchParentToInsert(key, parent.getLeftChild());

				}

			}

		} else { // if (parent.getKey().compareTo(key) > 0) {

			if (parent.getRightChild() != null) {

				if (parent.getRightChild().getKey().compareTo(key) == 0) {

					throw new DuplicatedKeyException();

				} else {

					return searchParentToInsert(key, parent.getRightChild());

				}

			}

		}

		return parent;

	}

	@Override
	public void delete(K key) throws EmptyTreeException, KeyNotFoundException {

		NodeBT<K, T> parent = searchParentOfKey(key);

		if (parent.getLeftChild() != null) {

			if (parent.getLeftChild().getKey().equals(key)) {

				NodeBT<K, T> toDelete = parent.getLeftChild();

				if (toDelete.getLeftChild() != null) {

					NodeBT<K, T> parentOfMaxLeftChild = toDelete.getLeftChild();

					if (parentOfMaxLeftChild.getRightChild() != null) {

						while (parentOfMaxLeftChild.getRightChild().getRightChild() != null) {

							parentOfMaxLeftChild = parentOfMaxLeftChild.getRightChild();

						}

						parent.setLeftChild(parentOfMaxLeftChild.getRightChild());
						parentOfMaxLeftChild.setRightChild(null);

					} else {

						parent.setLeftChild(parentOfMaxLeftChild);

					}

					parent.getLeftChild().setLeftChild(toDelete.getLeftChild());
					parent.getLeftChild().setRightChild(toDelete.getRightChild());

				}

			}

		}

		if (parent.getRightChild() != null) {

			if (parent.getRightChild().getKey().equals(key)) {

				NodeBT<K, T> toDelete = parent.getRightChild();

				if (toDelete.getRightChild() != null) {

					NodeBT<K, T> parentOfMaxLeftChild = toDelete.getLeftChild();

					if (parentOfMaxLeftChild.getRightChild() != null) {

						while (parentOfMaxLeftChild.getRightChild().getRightChild() != null) {

							parentOfMaxLeftChild = parentOfMaxLeftChild.getRightChild();

						}

						parent.setRightChild(parentOfMaxLeftChild.getRightChild());
						parentOfMaxLeftChild.setRightChild(null);

					} else {

						parent.setRightChild(parentOfMaxLeftChild);

					}

					parent.getRightChild().setLeftChild(toDelete.getLeftChild());
					parent.getRightChild().setRightChild(toDelete.getRightChild());

				}

			}

		}

	}

	@Override
	public int size() {
		int size=0;
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

	@Override
	public LinkedList<NodeBT<K, T>> preOrder() {

		LinkedList<NodeBT<K, T>> toReturn = new LinkedList<>();
		toReturn = rPreOrder(root, toReturn);

		return toReturn;
	}

	private LinkedList<NodeBT<K, T>> rPreOrder(NodeBT<K, T> tRoot, LinkedList<NodeBT<K, T>> toReturn) {

		toReturn.add(tRoot);

		if (tRoot.getLeftChild() != null) {
			rPreOrder(tRoot.getLeftChild(), toReturn);
		}

		if (tRoot.getRightChild() != null) {
			rPreOrder(tRoot.getRightChild(), toReturn);
		}
		return toReturn;
	}

	@Override
	public LinkedList<NodeBT<K, T>> inOrder() {

		LinkedList<NodeBT<K, T>> toReturn = new LinkedList<>();
		rInOrder(root, toReturn);

		return toReturn;
	}

	private LinkedList<NodeBT<K, T>> rInOrder(NodeBT<K, T> tRoot, LinkedList<NodeBT<K, T>> toReturn) {

		if (tRoot.getLeftChild() != null) {
			rInOrder(tRoot.getLeftChild(), toReturn);
		}

		toReturn.add(tRoot);

		if (tRoot.getRightChild() != null) {
			rInOrder(tRoot.getRightChild(), toReturn);
		}

		return toReturn;
	}


	@Override
	public LinkedList<NodeBT<K, T>> postOrder() {

		LinkedList<NodeBT<K, T>> toReturn = new LinkedList<>();
		toReturn = rPostOrder(root, toReturn);

		return toReturn;
	}

	private LinkedList<NodeBT<K, T>> rPostOrder(NodeBT<K, T> tRoot, LinkedList<NodeBT<K, T>> toReturn) {

		if (tRoot.getLeftChild() != null) {
			rPostOrder(tRoot.getLeftChild(), toReturn);
		}

		if (tRoot.getRightChild() != null) {
			rPostOrder(tRoot.getRightChild(), toReturn);
		}

		toReturn.add(tRoot);
		return toReturn;
	}
}
