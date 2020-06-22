package entities;

public class Tuple<T,K extends Comparable> {
	private T value;
	private K key;

	public Tuple() {
	}

	public Tuple(T value, K key) {
		this.value = value;
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}
}
