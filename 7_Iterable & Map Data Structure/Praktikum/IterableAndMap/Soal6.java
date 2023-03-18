package IterableAndMap;

import java.util.*;

public class Soal6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array1= {2, 1, 5, 1, 3, 2};
		int k1=3;
		
		System.out.println(highestSum(array1,k1));
		
		Integer[] array2= {2, 3, 4, 1, 5};
		int k2=2;
		
		System.out.println(highestSum(array2,k2));
	}
	
	public static int highestSum(Integer[] array, int k) {
		int total=0;
		int highest=0;
		for(int i=0;i<array.length;i++) {
			if(i<k) {
				total+=array[i];
				highest+=array[i];
				continue;
			}
			total-=array[i-k];
			total+=array[i];
			if(total>highest) {
				highest=total;
			}
		}
		return highest;
	}

}
