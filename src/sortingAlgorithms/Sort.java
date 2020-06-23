package sortingAlgorithms;

public class Sort<T extends Comparable<T>>{

    public void quicksort(T[] toOrder){

        rQuicksort(toOrder, 0, toOrder.length-1);

    }

    private void rQuicksort(T[] toOrder, int low, int high){

        if (low< high){

            int posPiv= posPiv( toOrder, low,high);

            rQuicksort(toOrder, low,posPiv-1);

            rQuicksort(toOrder,posPiv+1, high);

        }

    }

    private int posPiv(T[] toOrder, int low, int high){

        T pivot= toOrder[high];

        int i = (low -1);

        for( int j= low; j<= high-1; j++){

            if (pivot.compareTo(toOrder[j])>0){

                i++;

                swap(toOrder, i , j);

            }

        }

        swap(toOrder, i+1, high);

        return i+1;

    }

    private void swap(T[] toOrder, int toChange1, int toChange2){

        T oldMin= toOrder[toChange1];

        toOrder[toChange1]= toOrder[toChange2];

        toOrder[toChange2]= oldMin;

    }

}
