package TADs.interfaces;

import TADs.implementations.LinkedList;
import TADs.nodes.NodeBT;
import exceptions.EmptyTreeException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;

public interface MyTree<K extends Comparable<K>, T> {

	T find(K key) throws EmptyTreeException, KeyNotFoundException;

	void insert(K key, T data, K parentKey) throws KeyNotFoundException,
			EmptyTreeException, InvalidInformationException;

	void delete(K key) throws EmptyTreeException, KeyNotFoundException;

	int size();

	int countLeaf();

	int countCompleteElements();

	LinkedList<NodeBT<K, T>> inOrder() throws EmptyTreeException; // Falta terminar

	LinkedList<NodeBT<K, T>> preOrder() throws EmptyTreeException; // Falta terminar

	LinkedList<NodeBT<K, T>> postOrder() throws EmptyTreeException; // Falta terminar

	LinkedList<NodeBT<K, T>> byLevel() throws EmptyTreeException; // Falta terminar

}
