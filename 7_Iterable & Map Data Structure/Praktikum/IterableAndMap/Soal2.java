package IterableAndMap;

import java.util.*;

public class Soal2 {

	public static void main(String[] args) {
		String input1= "76523752";
		System.out.println(unique(input1));
		
		String input2= "1122";
		System.out.println(unique(input2));
	}
	
	public static List<Integer> unique(String string){
		Map<Integer, Boolean> mapIsUnique= new HashMap<Integer, Boolean>();		
		for(int i=0;i<string.length();i++) {
			Integer x = Integer.parseInt(string.substring(i,i+1));
			if(mapIsUnique.containsKey(x)) {
				mapIsUnique.put(x, false);
			}
			else {
				mapIsUnique.put(x, true);
			}
		}
		List<Integer> uniqueList=new ArrayList<Integer>();
		for(Integer key:mapIsUnique.keySet()) {
			if(mapIsUnique.get(key)==true) {
				uniqueList.add(key);
			}
		}
		return uniqueList;
		
	}

}
