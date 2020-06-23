package tads.interfaces;

public interface MyHashIterable<K, T> {

	void put(K key, T value);

	T get(K key);

	int getSize();

	void remove (K key);

	boolean contains(K key);

}
