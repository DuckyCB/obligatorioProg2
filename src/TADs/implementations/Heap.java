package TADs.implementations;

import TADs.interfaces.MyHeap;

public class Heap<T extends Comparable<T>> implements MyHeap<T> {

	private T[] heap;
	boolean maxHeap;
	boolean minHeap;
	int last;

	public Heap(T[] heap, boolean maxHeap, boolean minHeap) {

		this.heap = heap;
		this.maxHeap = maxHeap;
		this.minHeap = minHeap;
		this.last = 0;

	}

	public int getLast(){

		return last;

	}

	@Override
	public void insert(T value) {

		if (last != heap.length) {

			if (maxHeap) {

				heap[last] = value;
				compareMax(value, last);
				last = last + 1;

			} else if (minHeap) {

				heap[last] = value;
				compareMin(value, last);
				last = last + 1;

			}

		} else {

			System.out.println("Heap completo");

		}

	}

	private void compareMax(T value, int pos) {

		int fatherPos = fatherPos(pos);
		T father = heap[fatherPos];

		if (pos != 0 && value.compareTo(father) > 0) {

			heap[fatherPos] = value;
			heap[pos] = father;
			compareMax(value, fatherPos);

		}

	}

	private void compareMin(T value, int pos) {

		int fatherPos = fatherPos(pos);
		T father = heap[fatherPos];

		if (pos != 0 && value.compareTo(father) < 0) {

			heap[fatherPos] = value;
			heap[pos] = father;
			compareMin(value, fatherPos);

		}
	}

	private int fatherPos(int posChild) {

		return ((posChild - 1) / 2);

	}

	@Override
	public T deleteAndReturn() {

		T toDelete = heap[0];

		if (maxHeap) {

			heap[0] = heap[last - 1];
			T newFirst = heap[0];
			heap[last - 1] = null;
			last = last - 1;
			delCompareMax(0, newFirst);

		} else if (minHeap) {

			heap[0] = heap[last - 1];
			T newFirst = heap[0];
			heap[last - 1] = null;
			last = last - 1;
			delCompareMin(0, newFirst);

		}

		return toDelete;

	}

	private void delCompareMax(int pos, T value) {

		if ((2 * pos + 2) <= heap.length) {

			if (pos != last && heap[2 * pos + 1] != null && heap[2 * pos + 2] != null) {
				//tiene dos hijos

				int posLChild = 2 * pos + 1;
				int posRChild = 2 * pos + 2;

				if (value.compareTo(heap[posLChild]) < 0 && value.compareTo(heap[posRChild]) < 0) {

					if ((heap[posRChild]).compareTo(heap[posLChild]) < 0) {

						heap[pos] = heap[posLChild];
						heap[posLChild] = value;
						delCompareMax(posLChild, value);

					} else {

						heap[pos] = heap[posRChild];
						heap[posRChild] = value;
						delCompareMax(posRChild, value);

					}

				} else if (value.compareTo(heap[posLChild]) > 0 && value.compareTo(heap[posRChild]) < 0) {

					heap[pos] = heap[posRChild];
					heap[posRChild] = value;
					delCompareMax(posRChild, value);

				} else if (value.compareTo(heap[posRChild]) > 0 && value.compareTo(heap[posLChild]) < 0) {

					heap[pos] = heap[posLChild];
					heap[posLChild] = value;
					delCompareMax(posLChild, value);

				}

			}

		} else if ((2 * pos + 1) <= heap.length) {

			if (pos != last && 2 * pos + 1 == last - 1) {

				int posLChild = 2 * pos + 1;

				if (value.compareTo(heap[posLChild]) < 0) {

					heap[pos] = heap[posLChild];
					heap[posLChild] = value;

				}

			}

		}

	}

	private void delCompareMin(int pos, T value) {

		if ((2 * pos + 2) <= heap.length) {

			if (pos != last && heap[2 * pos + 1] != null && heap[2 * pos + 2] != null) { //tiene dos hijos

				int posLChild = 2 * pos + 1;
				int posRChild = 2 * pos + 2;

				if (value.compareTo(heap[posLChild]) > 0 && value.compareTo(heap[posRChild]) > 0) {

					if ((heap[posRChild]).compareTo(heap[posLChild]) > 0) {

						heap[pos] = heap[posLChild];
						heap[posLChild] = value;
						delCompareMin(posLChild, value);

					} else {

						heap[pos] = heap[posRChild];
						heap[posRChild] = value;
						delCompareMin(posRChild, value);

					}

				} else if (value.compareTo(heap[posLChild]) < 0 && value.compareTo(heap[posRChild]) > 0) {

					heap[pos] = heap[posRChild];
					heap[posRChild] = value;
					delCompareMin(posRChild, value);

				} else if (value.compareTo(heap[posRChild]) < 0 && value.compareTo(heap[posLChild]) > 0) {

					heap[pos] = heap[posLChild];
					heap[posLChild] = value;
					delCompareMin(posLChild, value);

				}

			}

		} else if ((2 * pos + 1) <= heap.length) {

			if (pos != last && 2 * pos + 1 == last - 1) {

				int posLChild = 2 * pos + 1;

				if (value.compareTo(heap[posLChild]) > 0) {

					heap[pos] = heap[posLChild];
					heap[posLChild] = value;

				}

			}

		}

	}

	@Override
	public int size() {

		return (last);

	}

	public void visualize() {

		int level = 0;
		int start = 0;
		boolean ready = false;

		while (!ready && start < heap.length) {

			for (int i = 1; i <= Math.pow(2, level); i++) {

				if (heap[start] != null) {

					System.out.print(heap[start] + " ");
					start = start + 1;

				} else {

					ready = true;

				}

			}

			System.out.print("\n");
			level = level + 1;

		}

	}

}
