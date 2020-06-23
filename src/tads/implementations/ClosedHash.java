package tads.implementations;

import exceptions.FullHashException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;
import tads.interfaces.MyHash;
import tads.nodes.HashNode;
import tads.nodes.NodeHeap;

import java.util.Iterator;

public class ClosedHash<K, T> implements MyHash<K, T>, Iterator<HashNode<K,T>> {

	private HashNode<K, T>[] hash;
	private int hashSize;
	private int size;
	private int it;

	public ClosedHash(int hashSize) {

		this.hash = new HashNode[hashSize];
		this.hashSize = hashSize;
		this.size=0;
		this.it=-1;

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

	@Override
	public boolean hasNext() {

		if (hash[it+1]!=null){

			it=it+1;

			return true;

		}else{

			it=-1;

			return false;

		}

	}

	@Override
	public HashNode<K, T> next() {

		HashNode<K,T> next= hash[it+1];

		it=it+1;

		return next;
	}
}
