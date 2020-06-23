package tads.implementations;

import tads.interfaces.MyQueue;
import tads.nodes.Node;
import exceptions.EmptyQueueException;

public class QueueLinkedList<T> implements MyQueue<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	public QueueLinkedList(){

		this.size=0;

	}


	@Override
	public void enqueue(T element) {

		Node<T> newNode = new Node<>(element, null);

		if (isEmpty()) {

			first = newNode;

		} else {

			last.setNext(newNode);

		}

		last = newNode;

		size=size+1;

	}

	@Override
	public T dequeue() throws EmptyQueueException {

		if (isEmpty()) throw new EmptyQueueException();
		T element = first.getValue();
		first.setNext(first.getNext());
		size=size-1;
		return element;

	}

	@Override
	public boolean isEmpty() {

		return first == null;

	}

	@Override
	public int size() {
		return size;
	}

}
