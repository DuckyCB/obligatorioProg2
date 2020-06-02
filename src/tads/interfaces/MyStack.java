package tads.interfaces;

import exceptions.EmptyyStackException;

public interface MyStack<T> {

	void pop() throws EmptyyStackException;

	T top() throws EmptyyStackException;

	void push(T element);

	boolean isEmpty();

	void makeEmpty();

}
