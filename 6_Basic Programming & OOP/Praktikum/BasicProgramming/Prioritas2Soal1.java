package BasicProgramming;

public class Prioritas2Soal1 {
	public static void main(String[] args) {
		drawXYZ(5);
	}
	public static void drawXYZ(int n) {
		for (int i=1;i<=Math.pow(n, 2);i++) {
			String word= (i%3==0? "X ": (i%2==1? "Y ":"Z "));
			System.out.print(word);
			if (i%n==0)System.out.print("\n");
		}
	}
}
