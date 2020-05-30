package TADs.interfaces;

import TADs.implementations.LinkedList;
import exceptions.EmptyTreeException;
import exceptions.KeyNotFoundException;

public interface MyBinarySearchTree<K extends Comparable<K>, T> {

	T find(K key) throws EmptyTreeException, KeyNotFoundException;

	void insert(K key, T data);

	void delete(K key);

	int size();

	int countLeaf();

	int countCompleteElements();

	LinkedList<K> inOrder();

	LinkedList<K> preOrder();

	LinkedList<K> postOrder();


}
