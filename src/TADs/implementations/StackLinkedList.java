package TADs.implementations;

import TADs.interfaces.MyStack;
import TADs.nodes.Node;
import exceptions.EmptyyStackException;

public class StackLinkedList<T> implements MyStack<T> {

	private Node<T> top;


	@Override
	public void pop() throws EmptyyStackException {

		if (isEmpty()) {

			throw new EmptyyStackException();

		} else {

			top = top.getNext();

		}

	}

	@Override
	public T top() throws EmptyyStackException {

		if (isEmpty()) {

			throw new EmptyyStackException();

		} else {

			return top.getValue();

		}


	}

	@Override
	public void push(T element) {

		top = new Node<>(element, top);

	}

	@Override
	public boolean isEmpty() {

		return top == null;

	}

	@Override
	public void makeEmpty() {

		top = null;

	}
}
