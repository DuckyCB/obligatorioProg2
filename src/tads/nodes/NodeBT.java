package tads.nodes;

public class NodeBT<K extends Comparable<K>, T> {

	private K key;
	private T data;
	private NodeBT<K, T> leftChild;
	private NodeBT<K, T> rightChild;

	public NodeBT(K key, T data){

		this.key=key;
		this.data=data;
		this.leftChild=null;
		this.rightChild=null;

	}

	public NodeBT<K, T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(NodeBT<K, T> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBT<K, T> getRightChild() {

		return rightChild;
	}
	public void setRightChild(NodeBT<K, T> rightChild) {
		this.rightChild = rightChild;
	}

	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public int compareTo(Comparable<K>  cKey){

		int toReturn=0;

		if(key instanceof String){

			toReturn= ((String)key).compareTo((String) cKey);

		}else if(key instanceof Integer){

			toReturn= ((Integer)key).compareTo((Integer)cKey);

		}

		return toReturn;

	}

}
