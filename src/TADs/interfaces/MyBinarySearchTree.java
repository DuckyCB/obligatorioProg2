package TADs.interfaces;

import TADs.implementations.LinkedList;

public interface MyBinarySearchTree<K extends Comparable<K>, T> {

	T find(K key);

	void insert(K key, T data);

	void delete(K key);

	int size();

	int countLeaf();

	int countCompleteElements();

	LinkedList<K> inOrder();

	LinkedList<K> preOrder();

	LinkedList<K> postOrder();


}
