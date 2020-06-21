package tads.implementations;

import tads.interfaces.MyStack;
import tads.nodes.Node;
import exceptions.EmptyyStackException;

public class StackLinkedList<T> implements MyStack<T> {

	private Node<T> top;


	@Override
	public void pop() throws EmptyyStackException {

		if (isEmpty()) throw new EmptyyStackException();
		top = top.getNext();

	}

	@Override
	public T top() throws EmptyyStackException {

		if (isEmpty()) throw new EmptyyStackException();
		return top.getValue();

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
