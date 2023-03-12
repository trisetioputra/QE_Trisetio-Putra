package OOP;

public class Prioritas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		System.out.print(calculator.add(3, 4));
		System.out.print(calculator.subtract(15, 4));
		System.out.print(calculator.multiply(10, 10));
		System.out.print(calculator.divide(12, 3));
	}

}

class Calculator{
	protected static String add(int a, int b) {
		return String.format("Penjumlahan: %d \n", a+b);
	}
	protected static String subtract(int a, int b) {
		return String.format("Pengurangan: %d \n", a-b);
	}
	protected static String multiply(int a, int b) {
		return String.format("Perkalian: %d \n", a*b);
	}
	protected static String divide(int a, int b) {
		return String.format("Pembagian: %d \n", a/b);
	}
}
