package tads.implementations;

import tads.interfaces.MyList;
import tads.nodes.Node;
import exceptions.InvalidInformationException;

public class LinkedList<T> implements MyList<T> {

	private Node<T> first;
	private int size=0;

	public Node<T> goToPosition(int position) throws InvalidInformationException {

		if (first == null) throw new InvalidInformationException();
		Node<T> node = first;

		for (int i = 0; i < position; i++) {

			if (node.getNext() == null) throw new InvalidInformationException();
			node = node.getNext();

		}

		return node;

	}


	@Override
	public void add(T value) {

		Node<T> newNode = new Node<>(value, null);

		if (first != null) {

			Node<T> node = first;

			while (node.getNext() != null) {

				node = node.getNext();

			}

			node.setNext(newNode);

		} else first = newNode;

		size++;

	}

	@Override
	public void remove(int position) throws InvalidInformationException {

		if (first == null) throw new InvalidInformationException();

		if (position == 0) first = null;
		else if (position >= 1) {

			Node<T> node = first;

			// Voy a la posicion(>=1) anterior para decidir que hacer a partir de ese nodo
			node = goToPosition(position - 1);

			if (node.getNext() == null) {

				if (node.getNext().getNext() != null) node.setNext(node.getNext().getNext());
				else node.setNext(null);

			} else {

				node.setNext(null);

			}

		} else throw new InvalidInformationException();

		size--;

	}

	@Override
	public T get(int position) throws InvalidInformationException {

		Node<T> node = goToPosition(position);
		if (node == null) throw new InvalidInformationException();
		return node.getValue();

	}

	public int getSize(){

		return size;

	}

}
