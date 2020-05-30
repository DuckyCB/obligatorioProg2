package utils.nodes;

public class PriorityNode<T> {

	private T value;
	private PriorityNode<T> next;
	private int priority;

	public PriorityNode(T value, PriorityNode<T> next) {
		this.value = value;
		this.next = next;
		this.priority = 0;
	}

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	public PriorityNode<T> getNext() {
		return next;
	}
	public void setNext(PriorityNode<T> next) {
		this.next = next;
	}

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
