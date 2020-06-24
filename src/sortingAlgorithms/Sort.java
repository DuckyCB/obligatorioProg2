package sortingAlgorithms;

import entities.Tuple;

public class Sort<K extends Comparable<K>, T>{

    public void quicksort(Tuple<K, T>[] toOrder){

        rQuicksort(toOrder, 0, toOrder.length-1);

    }

    private void rQuicksort(Tuple<K, T>[] toOrder, int low, int high){

        if (low< high){

            int posPiv= posPiv( toOrder, low,high);

            rQuicksort(toOrder, low,posPiv-1);

            rQuicksort(toOrder,posPiv+1, high);

        }

    }

    private int posPiv(Tuple<K, T>[] toOrder, int low, int high){

        Tuple<K, T> pivot= toOrder[high];

        int i = (low -1);

        for( int j= low; j<= high-1; j++){

            if (pivot.getKey().compareTo(toOrder[j].getKey())>0 ){

                i++;

                swap(toOrder, i , j);

            }

        }

        swap(toOrder, i+1, high);

        return i+1;

    }

    private void swap(Tuple<K, T>[] toOrder, int toChange1, int toChange2){

        Tuple<K, T> oldMin= toOrder[toChange1];

        toOrder[toChange1]= toOrder[toChange2];

        toOrder[toChange2]= oldMin;

    }

}
