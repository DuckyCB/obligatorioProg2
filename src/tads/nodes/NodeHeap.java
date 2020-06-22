package tads.nodes;

public class NodeHeap<K extends Comparable, T> {

	private K key;
	private T data;

	public NodeHeap(K key, T data) {

		this.key = key;
		this.data = data;

	}

	public K getKey() {
		return key;
	}

	public T getData() {
		return data;
	}


}
