package entities;

public class Tuple<K extends Comparable, T> {

	private K key;
	private T value;

	public Tuple() {
	}

	public Tuple(K key, T value) {
		this.value = value;
		this.key = key;
	}

	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

}
