package tads.nodes;

public class HashNode<K,T> {

    private K key;

    private T value;

    public HashNode(K key, T value){

        this.key=key;

        this.value=value;

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
