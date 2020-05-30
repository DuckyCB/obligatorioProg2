package TADs.interfaces;

import exceptions.EmptyyStackException;

import java.util.EmptyStackException;

public interface MyStack<T> {

	void pop() throws EmptyyStackException;

	T top() throws EmptyyStackException;

	void push(T element);

	boolean isEmpty();

	void makeEmpty();

}
