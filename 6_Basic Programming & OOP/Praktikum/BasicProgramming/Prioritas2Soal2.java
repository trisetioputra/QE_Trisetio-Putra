package BasicProgramming;

public class Prioritas2Soal2 {

	public static void printAsterisk(int n) {
		// TODO: complete this code
		for(int i=1;i<=n;i++) {
			int gap=n-i;
			System.out.print(" ".repeat(gap));
			int iter=(i*2)-1;
			for(int j=1;j<=iter;j++) {
				String out=(j%2==1?"*":" ");
				System.out.print(out);
			}
			System.out.print(" ".repeat(gap));
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		printAsterisk(5);
	}

}
