package tads.implementations;

import exceptions.InvalidInformationException;

import exceptions.KeyNotFoundException;

import tads.interfaces.MyHash;
import tads.nodes.HashNode;

public class OpenHash<K,T> implements MyHash<K,T> {

    private LinkedList<HashNode<K,T>>[] hash;

    int size;

    int hushSize;

    public OpenHash(int hushSize){

        this.hash= new LinkedList[hushSize];

        this.size=0;

        this.hushSize=hushSize;
    }


    @Override
    public void put(K key, T value) throws InvalidInformationException {

        int place=(((Integer)key) % hushSize);

        if(place>=hushSize){

            throw new InvalidInformationException();
        }

        LinkedList<HashNode<K,T>> toEvaluate= hash[place];

        if(toEvaluate==null){

            toEvaluate= new LinkedList<HashNode<K, T>>();

            hash[place]= toEvaluate;

            HashNode<K,T> toAdd= new HashNode<>(key, value);

            toEvaluate.add(toAdd);

            size = size + 1;
        }else {

            int i = 0;

            boolean found = false;

            while (i<toEvaluate.getSize() && found == false) {

                HashNode<K, T> element = toEvaluate.get(i);

                if (element.getKey().equals(key)) {

                    found = true;

                }else {
                    i = i + 1;
                }
            }
            if (found == false) {
                HashNode<K,T> toAdd= new HashNode<>(key, value);
                toEvaluate.add(toAdd);
                size=size+1;
            } else {
                toEvaluate.get(i).setValue(value);
            }
        }
    }

    @Override
    public T get(K key) throws KeyNotFoundException, InvalidInformationException {

        int place=(((Integer) key) % hushSize);

        if (place>= hushSize){

            throw new InvalidInformationException();

        }

        LinkedList<HashNode<K,T>> toEvaluate= hash[place];

        if(toEvaluate==null){

            throw new KeyNotFoundException();

        }else{
            int i=0;

            HashNode<K,T> toReturn=null;

            boolean found=false;

            while (i<toEvaluate.getSize() && found == false) {

                HashNode<K, T> element = toEvaluate.get(i);

                if (element.getKey().equals(key)) {

                    found = true;
                    toReturn= toEvaluate.goToPosition(i).getValue();
                }else {
                    i = i + 1;
                }
            }
            if (found==false){
                throw new KeyNotFoundException();
            }

            return toReturn.getValue();
        }

    }

    @Override
    public int getSize() {

        return size;

    }
}
