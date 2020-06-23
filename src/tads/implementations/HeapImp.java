package tads.implementations;

import tads.interfaces.MyHeapImp;
import tads.nodes.NodeHeap;

import java.util.Iterator;

public class HeapImp<K extends Comparable<K>, T> implements MyHeapImp<K, T>, Iterator<NodeHeap<K,T>> {

	private NodeHeap[] heap;
	private int last;
	private int heapType;
	private int it;

	public HeapImp(int sizeHeap, int heapType) {

		this.heap = new NodeHeap[sizeHeap];
		this.heapType = heapType;
		this.last = 0;
		this.it = -1;
	}

	@Override
	public void insert(K key, T data) {

		heap[last] = new NodeHeap<>(key, data);

		if (last != 0) {

			boolean run = true;
			int child = last;
			int father = (child - 1) / 2;

			while (run) {

				if (heap[child].getKey().compareTo(heap[father].getKey())
						== -1 * heapType) run = false;

				if ((heap[child].getKey().compareTo(heap[father].getKey())
						== heapType)) {

					NodeHeap<K, T> parent = heap[father];
					heap[father] = heap[child];
					heap[child] = parent;
					child = father;

					if (child != 0) father = (child - 1) / 2;
					else run = false;

				}

				if ((heap[child].getKey().compareTo(heap[father].getKey())) == 0) {

					run = false;

				}

			}

			last++;
		}

	}

	@Override
	public NodeHeap<K, T> deleteAndReturn() {
		if(heap==null) {
			NodeHeap<K, T> toReturn = null;
			return null;
		}else {
			NodeHeap<K, T> toReturn= heap[0];
			if(last ==0){
				heap= null;
			}else {
				heap[0] = heap[last - 1];
				heap[last - 1] = null;
				last--;

				boolean run = true;
				int parentPos = 0;
				int count = 0;
				int leftChildPos = 2 * parentPos + 1;
				int rightChildPos = 2 * parentPos + 2;

				while (run) {

					if (leftChildPos > last - 1 || rightChildPos > last - 1) {

						if (leftChildPos > last - 1 && rightChildPos > last - 1) {

							run = false;
							break;

						} else {

							if (leftChildPos > last - 1) leftChildPos = rightChildPos;
							else if (rightChildPos > last - 1) rightChildPos = leftChildPos;

						}

					}

					if (heap[parentPos].getKey().compareTo(heap[leftChildPos].getKey()) == heapType
							|| heap[parentPos].getKey().compareTo(heap[leftChildPos].getKey()) == 0) {

						if (heap[parentPos].getKey().compareTo(heap[rightChildPos].getKey()) == heapType
								|| heap[parentPos].getKey().compareTo(heap[rightChildPos].getKey()) == 0) {

							run = false;

						}

					}

					if (heap[parentPos].getKey().compareTo(heap[leftChildPos].getKey()) == -1 * heapType
							&& heap[parentPos].getKey().compareTo(heap[rightChildPos].getKey()) == -1 * heapType) {

						NodeHeap<K, T> padre = heap[parentPos];

						if (heap[leftChildPos].getKey().compareTo(heap[rightChildPos].getKey()) == -1 * heapType) {

							heap[parentPos] = heap[rightChildPos];
							heap[rightChildPos] = padre;
							parentPos = rightChildPos;

						} else {

							heap[parentPos] = heap[leftChildPos];
							heap[leftChildPos] = padre;
							parentPos = leftChildPos;

						}

						leftChildPos = 2 * parentPos + 1;
						rightChildPos = 2 * parentPos + 2;

					} else if (heap[parentPos].getKey().compareTo(heap[leftChildPos].getKey()) == -1 * heapType) {

						NodeHeap<K, T> padre = heap[parentPos];
						heap[parentPos] = heap[leftChildPos];
						heap[leftChildPos] = padre;
						parentPos = leftChildPos;
						leftChildPos = 2 * parentPos + 1;
						rightChildPos = 2 * parentPos + 2;

					} else if (heap[parentPos].getKey().compareTo(heap[rightChildPos].getKey()) == -1 * heapType) {

						NodeHeap<K, T> padre = heap[parentPos];
						heap[parentPos] = heap[rightChildPos];
						heap[rightChildPos] = padre;
						parentPos = rightChildPos;
						rightChildPos = 2 * parentPos + 2;
						leftChildPos = 2 * parentPos + 1;

					}

				}
			}
			return toReturn;
		}

	}

	@Override
	public long size() {
		return last;
	}

	public void showItems() {

		for (int i = 0; i < last; i++) {

			System.out.println(heap[i].getKey());

		}
	}

	@Override
	public boolean hasNext() {

		if (heap[it+1]!=null){

			it=it+1;

			return true;

		}else{

			it=-1;

			return false;

		}

	}

	@Override
	public NodeHeap<K, T> next() {

		NodeHeap<K,T> next= heap[it+1];

		it=it+1;

		return next;
	}
}
