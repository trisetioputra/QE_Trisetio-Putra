package BasicProgramming;

import java.util.Scanner;

public class Prioritas1Soal2 {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int hargaBeli= scanner.nextInt();
		int hargaJual= scanner.nextInt();
		
		int gap=hargaJual-hargaBeli;
		
		if(gap==0) {
			System.out.println("sama saja");
		}
		else {
			if(gap>0) {
				System.out.printf("untung sebesar: %.0f", (double) gap);
			}
			else {
				System.out.printf("rugi sebesar: %.0f", (double) gap);
			}
		}
		scanner.close();
	}
}
