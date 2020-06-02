package tads.interfaces;

import tads.implementations.LinkedList;
import tads.nodes.NodeBT;
import exceptions.DuplicatedKeyException;
import exceptions.EmptyTreeException;
import exceptions.KeyNotFoundException;

public interface MyBinarySearchTree<K extends Comparable<K>, T> {

	T find(K key) throws EmptyTreeException, KeyNotFoundException;

	void insert(K key, T data) throws DuplicatedKeyException;

	void delete(K key) throws EmptyTreeException, KeyNotFoundException;

	int size();

	int countLeaf();

	int countCompleteElements();

	LinkedList<NodeBT<K, T>> inOrder(); // Falta probar

	LinkedList<NodeBT<K, T>> preOrder(); // Falta probar

	LinkedList<NodeBT<K, T>> postOrder(); // Falta probar

}
