package TADs.implementations;

import TADs.interfaces.MyBinarySearchTree;
import TADs.nodes.NodeBT;
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
	public void insert(K key, T data) {

		NodeBT<K, T> newNode = new NodeBT<>(key, data);
		NodeBT<K, T> node = root;

		NodeBT<K, T> actual = root;

		while (actual != null) {

			if (actual.getKey().compareTo(key) == 0) {

				throw new DuplicatedKeyException();

			} else if (actual.getKey().compareTo(key) < 0) {

				if (actual.getLeftChild() != null) {

					actual = actual.getLeftChild();

				} else {

					NodeBT<K, T> newNode = new NodeBT<>(key, data);
					actual.setLeftChild(newNode);
				}

			} else {

				if (actual.getRightChild() != null) {

					actual = actual.getRightChild();

				} else {

					NodeBT<K, T> newNode = new NodeBT<>(key, data);
					actual.setRightChild(newNode);

				}

			}

		}

	}

	private NodeBT<K, T> searchParentToInsert(K key) {

		if ()

	}

	@Override
	public void delete(K key) {

	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public int countLeaf() {
		return 0;
	}

	@Override
	public int countCompleteElements() {
		return 0;
	}

	@Override
	public LinkedList<K> inOrder() {
		return null;
	}

	@Override
	public LinkedList<K> preOrder() {
		return null;
	}

	@Override
	public LinkedList<K> postOrder() {
		return null;
	}
}
