### Source code ada di folder praktikum
### Screenshot hasil report
<img width="1088" alt="image" src="https://user-images.githubusercontent.com/70261732/229336807-54394078-1e2f-4ba6-bf93-20786e208c2a.png">
<img width="1086" alt="image" src="https://user-images.githubusercontent.com/70261732/229336843-ea614658-47fd-4f0e-899a-471bae5a0eb5.png">   
Tahap pengerjaan singkat
  
1. Membuat file feature yang berisi tahapan tahapan pengujian dalam bahasa Gerkhin. Untuk judul, saya menambahkan [POS] sebagai penanda test case positif dan [NEG] untuk penanda test case negatif. 
<img width="778" alt="image" src="https://user-images.githubusercontent.com/70261732/229336951-607b5ff1-c567-4bb4-98ad-4d7c3a738cce.png">
2. Mengisi file step yang berisi pengimplementasian dari masing- masing baris gerkhin. File step akan diusahakan untuk meminimalisir kode yang redundan, dengan memanfaatkan fungsi yang reusable. 
<img width="665" alt="image" src="https://user-images.githubusercontent.com/70261732/229337105-812e0287-36ff-4364-8bc5-c7601e5f80ac.png">
3. Pada file step, kita akan memanggil fungsi yang sudah dibuat pada class object yang saya buat bernama Post. Pada class Post, akan terdapat method untuk melakukan pemanggilan API, maupun memverifikasi hasil pemanggilan API. Berikut contoh pemanggilan POST API 
<img width="709" alt="image" src="https://user-images.githubusercontent.com/70261732/229337150-6863175c-fbef-49e2-9383-792241e4cb2f.png">
Berikut contoh kode untuk verifikasi apakah respon mengembalikan data yang sesuai dengan yang dikirim
<img width="564" alt="image" src="https://user-images.githubusercontent.com/70261732/229337187-4f923ada-8277-4c17-9468-fb2bbacaac48.png">
Berikut contoh kode untuk verifikasi tipe data yang dikembalikan sesuai pada method GET all
<img width="510" alt="image" src="https://user-images.githubusercontent.com/70261732/229337234-8f3089ca-b6ef-4439-952d-de6a3dd372df.png">
4. Setelah pengerjaan, maka saya tinggal menjalankan kode dengan mvn clean verify, lalu melakukan revisi kode berdasarkan hasil dari report. 

