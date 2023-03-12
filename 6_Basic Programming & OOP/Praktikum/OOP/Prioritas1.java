package OOP;

public class Prioritas1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product coffee=new Product("coffee","this is coffee",15000,10);
		System.out.println(coffee.getInfo());
		Product milk=new Product("milk","this is fresh milk",25000,10);
		System.out.println(milk.getInfo());
		Product juice=new Product("apple juice","this is juice",18000,20);
		System.out.println(juice.getInfo());
	}

}

class Product{
	private String name;
	private String deskripsi;
	private int harga;
	private int jumlahStokProduk;
	
	public Product(String name, String deskripsi, int harga, int jumlahStokProduk) {
		this.name = name;
		this.deskripsi = deskripsi;
		this.harga = harga;
		this.jumlahStokProduk = jumlahStokProduk;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getDeskripsi() {
		return deskripsi;
	}
	protected void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	protected int getHarga() {
		return harga;
	}
	protected void setHarga(int harga) {
		this.harga = harga;
	}
	protected int getJumlahStokProduk() {
		return jumlahStokProduk;
	}
	protected void setJumlahStokProduk(int jumlahStokProduk) {
		this.jumlahStokProduk = jumlahStokProduk;
	}
	
	protected String getInfo() {
		String result="";
		result+="===\nInfo Produk\n";
		result+=String.format("nama: %s \n",getName());
		result+=String.format("deskripsi: %s \n",getDeskripsi());
		result+=String.format("harga: %d \n",getHarga());
		result+=String.format("jumlah stok: %d \n",getJumlahStokProduk());
		result+="===";
		return result;
	}

}
