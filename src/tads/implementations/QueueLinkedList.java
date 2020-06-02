package tads.implementations;

import tads.interfaces.MyQueue;
import tads.nodes.Node;
import exceptions.EmptyQueueException;

public class QueueLinkedList<T> implements MyQueue<T> {

	private Node<T> first;
	private Node<T> last;


	@Override
	public void enqueue(T element) {

		Node<T> newNode = new Node<>(element, null);

		if (isEmpty()) {

			first = newNode;

		} else {

			last.setNext(newNode);

		}

		last = newNode;

	}

	@Override
	public T dequeue() throws EmptyQueueException {

		if (isEmpty()) {

			throw new EmptyQueueException();

		} else {

			T element = first.getValue();
			first.setNext(first.getNext());
			return element;

		}

	}

	@Override
	public boolean isEmpty() {

		return first == null;

	}

}
