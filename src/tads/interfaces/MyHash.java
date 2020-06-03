package tads.interfaces;

import exceptions.InvalidInformationException;

import exceptions.KeyNotFoundException;

public interface MyHash<K,T> {

    void put(K key, T value) throws InvalidInformationException;

    T get(K key) throws KeyNotFoundException, InvalidInformationException;

    int getSize();

}
