package tads.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

	@Test
	public void insert() {

		Comparable<Integer>[] size= new Comparable[15];
		Heap<Integer> heap= new Heap(size,true);
		heap.insert(10);
		//heap.getLast() devuelve la cantidad de elementos
		assertEquals((int) heap.getLast(), 1);
	}

	@Test
	public void deleteAndReturn_maxHeap() {

		Comparable<Integer>[] size= new Comparable[15];
		Heap<Integer> heap= new Heap(size,true);
		heap.insert(10);
		heap.insert(5);
		heap.insert(8);

		assertEquals((int)heap.deleteAndReturn(), 10);
	}
	@Test
	public void deleteAndReturn_minHeap() {

		Comparable<Integer>[] size= new Comparable[15];
		Heap<Integer> heap= new Heap(size,false);
		heap.insert(10);
		heap.insert(5);
		heap.insert(8);

		assertEquals((int)heap.deleteAndReturn(), 5);
	}

	@Test
	public void size() {

		Comparable<Integer>[] size= new Comparable[4];
		Heap<Integer> heap= new Heap(size,true);
		heap.insert(11);
		heap.insert(2);

		assertEquals(heap.size(), 2);
	}
}