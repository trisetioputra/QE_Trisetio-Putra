package IterableAndMap;

import java.util.*;

public class Soal4 {

	public static void main(String[] args) {		
		Integer[] array1= {1,2,3,4};
		Integer[] array2= {1, 3, 5, 10, 16};
		System.out.println(leftJoin(array1,array2));

		Integer[] array3= {3,8};
		Integer[] array4= {2,8};
		System.out.println(leftJoin(array3,array4));
	}
	
	public static String leftJoin(Integer[] array1, Integer[] array2){		
		Set<Integer> firstSet= new HashSet<Integer>();
		firstSet.addAll(Arrays.asList(array1));
		Set<Integer> secondSet=new HashSet<Integer>();		
		secondSet.addAll(Arrays.asList(array2));

		for(Integer number:secondSet) {
			if(firstSet.contains(number)) {
				firstSet.remove(number);
			}
		}
		
		return firstSet.toString();
		
	}
}
