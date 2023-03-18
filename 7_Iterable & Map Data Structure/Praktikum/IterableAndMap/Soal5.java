package IterableAndMap;

import java.util.*;

public class Soal5 {

	public static void main(String[] args) {
		Integer[] input1= {2, 3, 3, 3, 6, 9, 9};
		System.out.println(UniqueArrayLength(input1));
		
		Integer[] input2= {2, 2, 2, 11};
		System.out.println(UniqueArrayLength(input2));
	}
	
	public static Integer UniqueArrayLength(Integer[] arrayInt){
		Stack<Integer> stack= new Stack<Integer>();
		for(int i=0;i<arrayInt.length;i++) {
			if(stack.size()==0) {
				stack.push(arrayInt[i]);
				continue;
			}
			if(stack.peek()!=arrayInt[i]) {
				stack.push(arrayInt[i]);
			}
			else {
				continue;
			}
		}
		
		return stack.size();
	}

}
