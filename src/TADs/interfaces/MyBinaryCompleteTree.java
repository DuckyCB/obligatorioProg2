package TADs.interfaces;

public interface MyBinaryCompleteTree<K extends Comparable<K>, T> {

	void insert(T data);

	void delete(K key);

}
