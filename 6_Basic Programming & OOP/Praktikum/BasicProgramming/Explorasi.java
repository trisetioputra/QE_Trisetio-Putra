package BasicProgramming;

import java.util.Scanner;

public class Explorasi {
	public static void main(String[] args) {
		System.out.println(encrypt("SEPULSA OKE")); // COZEVCK YUO
		System.out.println(encrypt("ALTERRA ACADEMY")); // KVDOBBK KMKNOWI
		System.out.println(encrypt("INDONESIA")); // SXNYXOCSK
		System.out.println(encrypt("GOLANG")); // QYVKXQ
		System.out.println(encrypt("PROGRAMMER")); // ZBYQBKWWOB
	}
	public static String encrypt(String word) {
		String result="";
		for(int i=0;i<word.length();i++) {
			char chr=word.charAt(i);
			if(chr==' ') {
				result+=" ";
				continue;
			}
			int check=chr+10;
			check = (check>90?(check-90+64):check);
			char test=(char) check;
			result+=Character.toString(test);
		}
		return result;
	}
}
