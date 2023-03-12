package BasicProgramming;

public class Prioritas1Soal1 {
	public static void main(String[] args) {
		// segitiga
		float alas = 20;
		float tinggi = 25;
		float luasSegitiga= 0.5f*alas*tinggi;
		
		System.out.printf("Luas segitiga: %.2f \n",luasSegitiga);
		// TODO: hitung luas segitiga

		// persegi panjang
		float panjang = 40;
		float lebar = 6;

		float luasPersegi= panjang*lebar;
		
		System.out.printf("Luas persegi: %.2f \n",luasPersegi);
		//TODO: hitung luas persegi panjang

		// lingkaran
		double jari2 = 7;

		double luasLingkaran= 3.14f*Math.pow(jari2, 2);
		
		System.out.printf("Luas lingkaran: %.2f \n",luasLingkaran);
		//TODO: hitung luas lingkaran
	}
}