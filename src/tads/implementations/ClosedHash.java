package tads.implementations;

import exceptions.FullHashException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;
import tads.interfaces.MyHash;
import tads.nodes.HashNode;

public class ClosedHash<K, T> implements MyHash<K, T> {

	private HashNode[] hash;
	private int hashSize;
	private int size;

	public ClosedHash(int hashSize) {

		this.hash = new HashNode[hashSize];
		this.size = hashSize;

	}


	@Override
	public void put(K key, T value) throws InvalidInformationException, FullHashException {

		int place = ( (Integer) key ) % hashSize;

		while (hash[place] != null) {

			place++;

			if (place >= hashSize) {

				place = 0;

			} else if (place == ( (Integer) key ) % hashSize) {
				// Solo llega a esto si recorre todos los espacios y no hay libre

				throw new FullHashException();
				// O bien se podria crear un nuevo hash de mayor size

			}

			if (hash[place].getKey().equals(key)) {

				throw new InvalidInformationException();

			}

		}

		hash[place] = new HashNode<>(key, value);

	}


	@Override
	public T get(K key) throws KeyNotFoundException, InvalidInformationException {

		int place = ( (Integer) key ) % hashSize;

		if (hash[place] != null) {

			while (!hash[place].getKey().equals(key)) {

				place++;

				if (place >= hashSize) {

					place = 0;

				} else if (place == ((Integer) key) % hashSize) {
					// Solo llega a esto si recorre todos los espacios y no hay libre

					throw new KeyNotFoundException();

				}

			}

			return (T) hash[place].getValue();



		} else {

			throw new InvalidInformationException();

		}

	}

	@Override
	public int getSize() {

		return size;

	}
}
