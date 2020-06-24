package tads.implementations;

import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;

import tads.interfaces.MyHash;
import tads.nodes.HashEntry;
import tads.nodes.HashNode;

import java.util.Iterator;

public class OpenHash<K, T> implements MyHash<K, T> { // Iterable<T>

    private LinkedList<HashNode<K,T>>[] hash;
    private int size;
    private int hashSize;

    public OpenHash(int hashSize){

        this.hash = new LinkedList[hashSize];
        this.size = 0;
        this.hashSize = hashSize;

    }


    @Override
    public void put(K key, T value) throws InvalidInformationException {

        int place = key.hashCode() % hashSize;
        LinkedList<HashNode<K, T>> toEvaluate = hash[place];

        if (toEvaluate == null){

            hash[place] = new LinkedList<>();
            hash[place].add(new HashNode<>(key, value));
            size++;

        }else {

            int i = 0;
            boolean found = false;

            while (i < toEvaluate.size() && !found) {

                if (toEvaluate.get(i).getKey().equals(key)) found = true;
                else i++;

            }

            if (!found) {

                toEvaluate.add(new HashNode<>(key, value));
                size++;

            } else toEvaluate.get(i).setValue(value);

        }

    }

    @Override
    public T get(K key) throws KeyNotFoundException, InvalidInformationException {

        int place = key.hashCode() % hashSize ;
        LinkedList<HashNode<K, T>> toEvaluate = hash[place];
        if (toEvaluate == null) throw new KeyNotFoundException();
        int i=0;

        while (i < toEvaluate.size()) {

            HashNode<K, T> element = toEvaluate.get(i);

            if (element.getKey().equals(key)) {

                return element.getValue();

            } else i++;

        }

        throw new KeyNotFoundException();

    }

    @Override
    public int getSize() {

        return size;

    }

    /*@Override
    public Iterator<T> iterator() {

        return new HashIteratorOpen(hash);

    }

    private class HashIteratorOpen implements Iterator<T> {

        private LinkedList<HashNode<K,T>>[] hashTable;
        private int indexTable;
        private int indexList;

        public HashIteratorOpen(LinkedList<HashNode<K,T>>[] hashTable) {

            this.hashTable = hashTable;
            this.indexTable = 0;
            this.indexList = 0;

        }

        @Override
        public boolean hasNext() {

            while (indexTable != hashTable.length && hashTable[indexTable] == null) indexTable++;
            return indexTable != hashTable.length;

        }

        @Override
        public T next() {

            //if
            return hashTable[indexTable++].get(0);

        }

    }*/

}
