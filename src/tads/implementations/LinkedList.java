package tads.implementations;

import tads.interfaces.MyList;
import tads.nodes.Node;
import exceptions.InvalidInformationException;

public class LinkedList<T> implements MyList<T> {

	private Node<T> first;


	public Node<T> goToPosition(int position) throws InvalidInformationException {

		if (first != null) {

			Node<T> node = first;

			for (int i = 0; i < position; i++) {

				if (node.getNext() != null) {

					node = node.getNext();

				} else {

					throw new InvalidInformationException();

				}

			}

			return node;

		} else {

			throw new InvalidInformationException();

		}

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

		} else {

			first = newNode;

		}

	}

	@Override
	public void remove(int position) throws InvalidInformationException {

		if (position == 0) {

			if (first != null) {

				first = null;

			} else {

				throw new InvalidInformationException();

			}

		} else if (position >= 1) {

			if (first != null) {

				Node<T> node = first;

				// Voy a la posicion(>=1) anterior para decidir que hacer a partir de ese nodo
				node = goToPosition(position - 1);

				if (node.getNext() != null) {

					if (node.getNext().getNext() != null) {

						node.setNext(node.getNext().getNext());

					} else {

						node.setNext(null);

					}

				} else {

					node.setNext(null);

				}

			} else {

				throw new InvalidInformationException();

			}

		} else {

			throw new InvalidInformationException();

		}

	}

	@Override
	public T get(int position) throws InvalidInformationException {

		Node<T> node = goToPosition(position);

		if (node != null) {

			return node.getValue();

		} else {

			throw new InvalidInformationException();

		}


	}

}
