package tads.implementations;

import tads.interfaces.MyHashIterable;
import tads.nodes.HashEntry;

import java.util.Iterator;

public class ClosedHash<K, T> implements MyHashIterable<K, T>, Iterable<T> {

	private static int LINEAL_COLLISION_FUNCTION = 1;
	private HashEntry<K, T>[] hashTable;
	private int size;
	private int defaultCollisionFunction = ClosedHash.LINEAL_COLLISION_FUNCTION;

	public ClosedHash(int size) {

		this.hashTable = new HashEntry[size];

	}

	@Override
	public void put(K key, T value) {
		int attempt = 0;
		int position = internalHashcodeWithCollision(key, attempt);

		HashEntry<K, T> valueToInsert = new HashEntry<>(key, value);

		while (hashTable[position] != null &&
				!hashTable[position].isRemoved() &&
				!hashTable[position].getKey().equals(key) &&
				!(attempt > hashTable.length)) {

			attempt++;
			position = internalHashcodeWithCollision(key, attempt);

		}

		if (attempt > hashTable.length) {

			throw new RuntimeException("No se encontro lugar disponible");
		}

		if (hashTable[position] == null || hashTable[position].isRemoved()) {

			hashTable[position] = valueToInsert;

		} else { // Si sale por aca es porque ya existe un elemento en la clave con lo que hay que sustituir el valor

			hashTable[position].setValue(value);
		}

		size++;
	}
	public int filledBuckets (){

		int res = 0;

		for (HashEntry<K, T> elements: hashTable) {

			if (elements != null) res++;

		}

		return res;

	}

	@Override
	public T get(K key) {
		int attempt = 0;
		int position = internalHashcodeWithCollision(key, attempt);
		T valueToReturn = null;

		while (hashTable[position] != null &&
				!hashTable[position].getKey().equals(key) &&
				!(attempt > hashTable.length)) {

			attempt++;
			position = internalHashcodeWithCollision(key, attempt);

		}

		if (hashTable[position] != null &&
				!(attempt > hashTable.length) &&
				hashTable[position].getKey().equals(key) &&
				!hashTable[position].isRemoved()) {

			valueToReturn = hashTable[position].getValue();

		}

		return valueToReturn;
	}


	public int getSize() {
		return this.size;
	}

	@Override
	public void remove(K key) {

	}

	@Override
	public boolean contains(K key) {
		return this.get(key) != null;
	}

	private int internalHashcodeWithCollision(K key, int attempt) {
		return (key.hashCode() + collisionFunction(attempt)) % hashTable.length;
	}

	private int collisionFunction(int i) {
		int value = 0;

		if (defaultCollisionFunction == LINEAL_COLLISION_FUNCTION) {

			value = i;

		}

		return value;
	}

	@Override
	public Iterator<T> iterator() {

		return new HashIterator(hashTable);

	}

	private class HashIterator implements Iterator<T> {

		private HashEntry<K, T>[] hashTable;
		private int count;
		private int maxIndex;
		private HashEntry<K, T> current;

		public HashIterator(HashEntry<K, T>[] hashTable) {

			this.hashTable = hashTable;
			this.count = 0;
			this.maxIndex = hashTable.length;
			moveToNext();

		}

		@Override
		public boolean hasNext() {

			return count<maxIndex;

		}

		@Override
		public T next() {

			T data = hashTable[count].getValue();
			count++;
			moveToNext();
			return data;

		}

		public void moveToNext(){

			while(count<maxIndex && (hashTable[count] == null || hashTable[count].isRemoved())){

				count++;

			}

		}

	}

}