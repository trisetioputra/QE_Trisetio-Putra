package IterableAndMap;

import java.util.*;

public class Soal3 {

	public static void main(String[] args) {
		Integer[] input1= {1, 2, 3, 4, 6};
		Integer target1=6;
		System.out.println(checkSum(input1, target1));
		
		Integer[] input2= {2, 5, 9, 11};
		Integer target2=11;
		System.out.println(checkSum(input2, target2));
	}
	
	public static String checkSum(Integer[] arrayInt, int total){
		Integer[] result = new Integer[2];
		int leftIndex=0;
		int rightIndex=arrayInt.length-1;
		while(leftIndex<rightIndex){
			if(arrayInt[leftIndex]+arrayInt[rightIndex]==total) {
				result[0]=leftIndex;
				result[1]=rightIndex;
				return Arrays.toString(result);
			}
			else if(arrayInt[leftIndex]+arrayInt[rightIndex]<total) {
				leftIndex++;
			}
			else {
				rightIndex--;
			}
		}
		return Arrays.toString(result);
	}
}
