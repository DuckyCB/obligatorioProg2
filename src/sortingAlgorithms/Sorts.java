package sortingAlgorithms;

import entities.AuthorYearCounter;

public class Sorts {

	public static void quicksort(AuthorYearCounter[] toOrder){

		rQuicksort(toOrder, 0, toOrder.length-1);

	}

	private static void rQuicksort(AuthorYearCounter[] toOrder, int low, int high){

		if (low< high){

			int posPiv= posPiv( toOrder, low,high);

			rQuicksort(toOrder, low,posPiv-1);

			rQuicksort(toOrder,posPiv+1, high);

		}

	}

	private static int posPiv(AuthorYearCounter[] toOrder, int low, int high){

		AuthorYearCounter pivot = toOrder[high];

		int i = (low - 1);

		for ( int j = low; j <= high - 1; j++){

			if (pivot != null && toOrder[j] != null) { // Agregue esto a ver si se arregla
				if (pivot.compareTo(toOrder[j]) > 0) {

					i++;
					swap(toOrder, i, j);

				}
			}

		}

		swap(toOrder, i+1, high);

		return i+1;

	}

	private static void swap(AuthorYearCounter[] toOrder, int toChange1, int toChange2){

		AuthorYearCounter oldMin= toOrder[toChange1];

		toOrder[toChange1]= toOrder[toChange2];

		toOrder[toChange2]= oldMin;

	}

}
