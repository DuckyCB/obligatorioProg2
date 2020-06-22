package tads.interfaces;

import tads.nodes.NodeHeap;

public interface MyHeapImp<K extends Comparable, T> {

	void insert(K key,T data);

	NodeHeap<K,T> deleteAndReturn();

	long size();
}
