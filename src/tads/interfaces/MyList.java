package tads.interfaces;

import exceptions.InvalidInformationException;

public interface MyList<T> {

	void add(T value);

	void remove(int position) throws InvalidInformationException;

	T get(int position) throws InvalidInformationException;

}
