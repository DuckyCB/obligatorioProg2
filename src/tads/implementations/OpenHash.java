package tads.implementations;

import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;

import tads.interfaces.MyHash;
import tads.nodes.HashNode;

public class OpenHash<K, T> implements MyHash<K, T> {

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

        int place = ( ( (Integer) key ) % hashSize );
        if (place >= hashSize) throw new InvalidInformationException();
        LinkedList<HashNode<K, T>> toEvaluate = hash[place];

        if (toEvaluate == null){

            toEvaluate = new LinkedList<>();
            hash[place] = toEvaluate;
            HashNode<K,T> toAdd = new HashNode<>(key, value);
            toEvaluate.add(toAdd);
            size++;

        }else {

            int i = 0;
            boolean found = false;

            while (i < toEvaluate.getSize() && !found) {

                HashNode<K, T> element = toEvaluate.get(i);

                if (element.getKey().equals(key)) found = true;
                else i++;

            }

            if (!found) {

                HashNode<K,T> toAdd = new HashNode<>(key, value);
                toEvaluate.add(toAdd);
                size++;

            } else toEvaluate.get(i).setValue(value);

        }

    }

    @Override
    public T get(K key) throws KeyNotFoundException, InvalidInformationException {

        int place = ( ( (Integer) key ) % hashSize );
        if (place >= hashSize) throw new InvalidInformationException();
        LinkedList<HashNode<K, T>> toEvaluate = hash[place];
        if (toEvaluate == null)  throw new KeyNotFoundException();
        int i=0;
        HashNode<K, T> toReturn = null;
        boolean found=false;

        while (i<toEvaluate.getSize() && !found) {

            HashNode<K, T> element = toEvaluate.get(i);

            if (element.getKey().equals(key)) {

                found = true;
                toReturn= toEvaluate.goToPosition(i).getValue();

            } else i++;

        }

        if (!found) throw new KeyNotFoundException();
        return toReturn.getValue();

    }

    @Override
    public int getSize() {

        return size;

    }
}
