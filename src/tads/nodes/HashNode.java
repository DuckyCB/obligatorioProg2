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

    public int compareTo(HashNode<K,T> toCompare){

        if(key instanceof String){

            return ((String) key).compareTo((String) toCompare.key);

        }else if(key instanceof Integer){

            return ((Integer) key).compareTo((Integer) toCompare.key);

        }else{
            return -1;

        }

    }



}
