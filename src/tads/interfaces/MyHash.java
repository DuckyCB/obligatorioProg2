package tads.interfaces;

import exceptions.FullHashException;
import exceptions.InvalidInformationException;

import exceptions.KeyNotFoundException;

public interface MyHash<K,T> {

    void put(K key, T value) throws InvalidInformationException, FullHashException;

    T get(K key) throws KeyNotFoundException, InvalidInformationException;

    int getSize();

}
