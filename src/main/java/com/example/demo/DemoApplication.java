package com.example.demo;

import com.example.demo.lib.Generator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Generator<Integer> generator = new Generator<>();
		Integer[] originalArray = new Integer[]{1,2,3};
		//generator.allCombinazioni(originalArray);
		generator.kCombinazioni(2,originalArray,new Integer[0]);
	}

	public static void combinazioni(int k, Integer[] ar, Integer[] ar2, int last) {
		if (k == 0)
			print(ar2);
		else {
			for (int i = last; i < ar.length; i++ ) {
				combinazioni(k-1,ar,add(ar2,ar[i]), ++last);
			}
		}
	}

	public static void disposizioni(int k, Integer[] ar, Integer[] ar2) {
		if (k == 0)
			print(ar2);
		else {
			for (int i = 0; i < ar.length; i++ ) {
				disposizioni(k-1,reduce(ar,i),add(ar2,ar[i]));
			}
		}
	}

	public static void print(Integer[] a) {
		System.out.print("(");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length-1)
				System.out.print(",");
		}
		System.out.print(")");
		System.out.println("");
	}

	public static Integer[] reduce(Integer[] arr, int elementToRemove ) {
		Integer[] copyArray = new Integer[arr.length - 1];
		System.arraycopy(arr, 0, copyArray, 0, elementToRemove);
		System.arraycopy(arr, elementToRemove + 1, copyArray, elementToRemove, arr.length - elementToRemove - 1);
		return copyArray;
	}

	public static Integer[] add(Integer[] arr, int elementToAdd) {
		Integer[] copyArray = Arrays.copyOf(arr, arr.length + 1);
		copyArray[copyArray.length-1] = elementToAdd;
		return copyArray;
	}
}
