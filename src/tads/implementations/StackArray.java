package tads.implementations;

import tads.interfaces.MyStack;
import exceptions.EmptyyStackException;
import org.omg.CORBA.Object;

import java.util.EmptyStackException;

public class StackArray<T> implements MyStack<T> {

	private Object[] array;
	private int size;
	private int maxSize;

	public StackArray() {
		this.array = new Object[10];
		this.size = 0;
		this.maxSize = 10;
	}

	public StackArray(int maxSize) {
		this.array = new Object[maxSize];
		this.size = 0;
		this.maxSize = maxSize;
	}

	@Override
	public void pop() throws EmptyyStackException {

		if (isEmpty()) {

			throw new EmptyStackException();

		} else {

			array[size-1] = null;
			size--;

		}

	}

	@Override
	public T top() throws EmptyStackException {

		if (isEmpty()) {

			throw new EmptyStackException();

		} else {

			return (T) array[size-1];

		}
	}

	@Override
	public void push(T element) {

		if (maxSize > size) {

			array[size] = (Object) element;

		} else {

			array = new Object[(int) (maxSize*1.5)];

		}

		size++;

	}

	@Override
	public boolean isEmpty() {

		return size == 0;

	}

	@Override
	public void makeEmpty() {

		for (int i=0; i<=size; i++) {

			array[i] = null;

		}

	}

}
