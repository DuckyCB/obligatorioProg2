package TADs.interfaces;

import exceptions.EmptyQueueException;

public interface MyQueue<T> {

	void enqueue(T element);

	T dequeue() throws EmptyQueueException;

	boolean isEmpty();

	// int size();

}
