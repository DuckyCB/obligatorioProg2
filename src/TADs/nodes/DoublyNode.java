package utils.nodes;

public class DoublyNode<T> {

	private T value;
	private DoublyNode<T> next;
	private DoublyNode<T> previous;

	public DoublyNode(T value, DoublyNode<T> next, DoublyNode<T> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public T getValue() {
		return value;
	}

	public DoublyNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyNode<T> next) {
		this.next = next;
	}

	public DoublyNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyNode<T> previous) {
		this.previous = previous;
	}
}
