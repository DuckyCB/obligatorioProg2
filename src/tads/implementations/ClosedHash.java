package tads.implementations;

import exceptions.FullHashException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;
import tads.interfaces.MyHash;
import tads.nodes.HashNode;

public class ClosedHash<K, T> implements MyHash<K, T> {

	private HashNode<K, T>[] hash;
	private int hashSize;
	private int size;

	public ClosedHash(int hashSize) {

		this.hash = new HashNode[hashSize];
		this.hashSize = hashSize;
		int size=0;

	}

	public HashNode<K, T>[] getHash() {
		return hash;
	}


	@Override
	public void put(K key, T value) throws InvalidInformationException, FullHashException {

		int place = key.hashCode() % hashSize;

		while (hash[place] != null) {

			if (hash[place]!= null) if (hash[place].getKey().equals(key)) throw new InvalidInformationException();
			place++;
			if (place >= hashSize) place = 0;
			if (place == key.hashCode() % hashSize) throw new FullHashException();
				// Solo llega a esto si recorre todos los espacios y no hay libre
				// O bien se podria crear un nuevo hash de mayor size

		}

		hash[place] = new HashNode<>(key, value);
		size++;

	}


	@Override
	public T get(K key) throws KeyNotFoundException, InvalidInformationException {

		int place = key.hashCode() % hashSize;
		if (hash[place] == null) {
			System.out.println(place);
			throw new InvalidInformationException();
		}
		// System.out.println(hash[place].getKey());
		// System.out.println(key);
		while (!hash[place].getKey().equals(key)) {

			place++;
			if (place >= hashSize) place = 0;
			if (place == key.hashCode() % hashSize) throw new KeyNotFoundException();
				// Solo llega a esto si recorre todos los espacios y no hay libre

		}

		return (T) hash[place].getValue();

	}

	@Override
	public int getSize() {

		return size;

	}
}
