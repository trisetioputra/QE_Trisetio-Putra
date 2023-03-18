package IterableAndMap;

import java.util.*;

public class Soal1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array1= {"kazuya", "jin", "lee"};
		String[] array2= {"kazuya", "feng"};

		System.out.println(merge(array1,array2));
		
		String[] array3= {"lee", "jin"};
		String[] array4= {"kazuya", "panda"};

		System.out.println(merge(array3,array4));

	}
	
	public static Set<String> merge(String[] array1, String[] array2){
		Set<String> merge= new HashSet<String>();
		List first= Arrays.asList(array1);
		List second= Arrays.asList(array2);
		merge.addAll(first);
		merge.addAll(second);

		return merge;
		
	}

}
