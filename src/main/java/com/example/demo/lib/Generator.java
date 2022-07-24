package com.example.demo.lib;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Generator <T>{

    public void allCombinazioni(T[] ar) {
        Class<T> clazz = null;
        T[] ar2 = newInstance(0);
        for (int i = 0; i < ar.length; i++)
            this.kCombinazioni(i+1,ar,ar2);
    }

    public void kCombinazioni(int k, T[] ar, T[] ar2) {
        this.combinazioni(k,ar,ar2,0);
    }

    private void combinazioni(int k, T[] ar, T[] ar2, int last) {
        if (k == 0)
            print(ar2);
        else {
            for (int i = last; i < ar.length; i++ ) {
                combinazioni(k-1,ar,add(ar2,ar[i]), ++last);
            }
        }
    }
    public void disposizioni(int k, T[] ar, T[] ar2) {
        if (k == 0)
            print(ar2);
        else {
            for (int i = 0; i < ar.length; i++ ) {
                disposizioni(k-1,reduce(ar,i),add(ar2,ar[i]));
            }
        }
    }

    private T[] newInstance(int size) {
        Class<T> clazz = null;
        return (T[]) Array.newInstance(clazz, size);
    }
    private T[] reduce(T[] arr, int elementToRemove ) {
        //Class<T> clazz = null;
        //T[] copyArray = (T[]) Array.newInstance(clazz, arr.length-1);
        T[] copyArray = newInstance(arr.length-1);
        System.arraycopy(arr, 0, copyArray, 0, elementToRemove);
        System.arraycopy(arr, elementToRemove + 1, copyArray, elementToRemove, arr.length - elementToRemove - 1);
        return copyArray;
    }

    public T[] add(T[] arr, T elementToAdd) {
        T[] copyArray = Arrays.copyOf(arr, arr.length + 1);
        copyArray[copyArray.length-1] = elementToAdd;
        return copyArray;
    }

    private void print(T[] a) {
        System.out.print("(");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length-1)
                System.out.print(",");
        }
        System.out.print(")");
    }
}
