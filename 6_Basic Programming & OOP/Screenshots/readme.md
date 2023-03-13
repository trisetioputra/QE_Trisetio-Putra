## Laporan
#### Disclaimer: Hasil screenshot dan penjelasan mungkin tidak mencangkup semua case yang ada. Sesuai permintaan soal, seharusnya hanya membuat program saja, tidak ada perintah untuk menjeleaskan
### Basic programming
#### Soal Prioritas 1 Nomor 1
![Screen Shot 2023-03-12 at 17 28 37](https://user-images.githubusercontent.com/70261732/224538838-05b0fea8-a5fa-49e8-a9df-455aa56177c2.png)
#### Penjelasan: Dilakukan perhitungan sesuai dengan rumus kalkulasi luas segitiga, luas persegi, dan luas lingkaran. Menggunakan tipe data float dan double untuk perhitungan, untuk mengakomodasi adanya desimal pada perhitungan. Menggunakan library Math dengan method pow() untuk mendapatkan pangkat
#### Soal Prioritas 1 Nomor 2
##### Case Rugi
![Screen Shot 2023-03-12 at 17 29 27](https://user-images.githubusercontent.com/70261732/224538880-7c74a3a2-2b93-4fe2-8f8a-d1e3cfa0096c.png)
#### Penjelasan: Dilakukan pengambilan input menggunakan class Scanner, yang kemudian dilanjutkan dengan pengecekan kondisional dengan if else untuk menentukan kasus untung atau rugi pada hasil input. Jika gap nya positif maka bisnis untung, jika gap negatif maka bisnis rugi, dan jika gap = 0 maka sama saja. Untuk pencetakan digunakan print format dengan decimal 0 angka dibelakang koma, ditandai dengan %.0f
##### Case Untung
![Screen Shot 2023-03-12 at 17 31 00](https://user-images.githubusercontent.com/70261732/224538987-a09d3956-d0d6-4d59-add5-796594721f5e.png)
##### Case Sama
![Screen Shot 2023-03-12 at 17 31 22](https://user-images.githubusercontent.com/70261732/224539025-425e9ee5-1794-48d7-ae77-b668b125a839.png)
#### Soal Prioritas 2 Nomor 1
![Screen Shot 2023-03-12 at 17 31 47](https://user-images.githubusercontent.com/70261732/224539069-5347eed1-c873-40b2-bbc1-d3b641e744d7.png)
#### Penjelasan: Untuk soal ini, saya memanfaatkan nested ternary operator yang dapat diamati pada String word untuk meminimalisir penggunaan baris, dimana logikanya mengikuti perintah soal. Program juga mengakomodasi jumlah n berapapun karena pencetakan pola dilakukan pada fungsi. 
#### Soal Prioritas 2 Nomor 2
![Screen Shot 2023-03-12 at 17 32 35](https://user-images.githubusercontent.com/70261732/224539110-ad2fe5d7-c0ce-4991-92f9-e32aa7744633.png)
#### Penjelasan: Untuk soal ini, saya mengamati pola segitiga nya dimana akan dicetak bintang dengan jumlah baris sesuai input (n), sehingga perulangan pertama adalah sebesar n. Lalu dilakukan penentuan gap, yaitu celah kanan dan kiri dari bintang pertama dan terakhir yang dicetak, dimana gap akan semakin berkurang sesuai dengan bertambahnya bintang. Lalu perulangan kedua adalah untuk mencetak "*", dimana dilakukan pada pola ganjil, sementara terdapat gap " " spasi pada pola genap sejumlah i*2-1.
#### Soal Explorasi
![Screen Shot 2023-03-12 at 17 35 05](https://user-images.githubusercontent.com/70261732/224539207-e47fb193-d139-4c36-aefd-5e5c39ea0107.png)
#### Penjelasan: Untuk soal ini, awalnya saya akan melakukan iterasi sebanyak panjang dari kode. Lalu untuk setiap karakter, akan diparsing ke dalam tipe data character, yang kemudian dijadikan integer + 10, untuk mendapatkan nilai ASCII nya yang ditambahkan dengan 10 (sesuai permintaan soal). Tidak lupa untuk menghandle case ketika ada spasi. Setelah itu, untuk mengatasi ketika ASCII sudah melewati huruf Z (agar kembali mengulang ke A dan seterusnya), dilakukan pengecekan menggunakan ternary operator, dimana jika melebihi 90 (ASCII untuk Z), akan dikonversi menjadi 64 + 90-ASCII+10, dengan 64 adalah ASCII sebelum A.Setelah itu hanya tinggal kita gabung ke dalam String untuk mendapatkan hasil akhirnya. 

### OOP
#### Soal Prioritas 1 
#### Code:
![Screen Shot 2023-03-13 at 21 42 51](https://user-images.githubusercontent.com/70261732/224735453-4348146d-c7ff-4a85-8e65-0cf2f3fdf345.png)
#### Output:
![Screen Shot 2023-03-12 at 17 35 48](https://user-images.githubusercontent.com/70261732/224539238-d98bd1a9-d3c3-4246-8b75-235a2c8a9596.png)
#### Penjelasan: Untuk soal ini, dilakukan pendefinisian produk dengan atribut yang diminta soal (name, deskripsi, harga, dan jumlah stok) yang dibuati setter dan getter. Tentunya, dimanfaatkan juga access modifier, yaitu private untuk atribut dan protected untuk method. Lalu didefinisikan method getInfo() untuk melakukan pencetakan nilai sesuai yang diminta soal.
#### Soal Prioritas 2 
#### Code:
![Screen Shot 2023-03-13 at 21 45 21](https://user-images.githubusercontent.com/70261732/224736365-b244b659-05f2-438d-a5a2-c7ce03639ae5.png)
#### Output:
![Screen Shot 2023-03-12 at 17 36 07](https://user-images.githubusercontent.com/70261732/224539250-1b75c925-360c-4601-9c31-eb7082cb5c81.png)
#### Penjelasan: Untuk soal ini, dibuat class yang hanya berisi method sesuai permintaan soal, dimana setiap method dapat melakukan operator matematik sesuai permintaan soal, yaitu tambah, kurang, kali, dan bagi.
#### Soal Explorasi 
#### Code terlalu panjang untuk di screenshot
#### Penjelasan: Didefinisikan terlebih dahulu suatu Class Book yang befungsi sebagai penyimpanan obyek buku, dengan atribut ID, title, author, dan category. Setelahnya, dibuat class BookController yang bergungsi sebagai logika bisnis dari koleksi buku. BookController memiliki satu atribut yang bersifat sebagai "perpustakaan" yang bertipe HashMap. Kenapa HashMap? karena akan dilakukan operasi GET, DELETE, dan UPDATE, dan untuk memudahkan pencarian obyek, tipe data Map akan sangat cocok untuk itu. Sehingga HashMap books memiliki key berupa UUID dan value berupa objek buku. Program ini sudah dirancang agar bebas dari bug, sehingga pada setiap method GET, CREATE, UPDATE, DELETE sudah dilakukan pengecekan try dan catch apabila ada input menyesatkan, serta dilakukan handling apabila terdapat pencarian key yang salah, sehingga seharusnya program tidak akan crash. Masing- masing penjelasan methodnya sebagai berikut:
1. create: method ini akan mengambil parameter inputan dari user berupa title, author, dan category. Lalu ketiga atribut tersebut akan ditambahkan dengan UUID yang random untuk membentuk suatu objek Book. Lalu Book tersebut akan dimasukan ke perpustakaan kita dengan method books.put(ID, Book). 
2. Get: Berkat penggunaan ID sebagai Key, melakukan GET akan sangat mudah, kita hanya perlu memanfaatkan method .get() dari class HashMap, lalu ia akan mencari Book berdasarkan ID yang kita berikan. Tentunya disini kita lakukan handling jika ketika UUID tidak ditemukan. Untuk mencetak setiap atribut dari Book, kita memanfaatkan getter yang ada pada class Book
3. Update: Update dilakukan dengan memanfaatkan HashMap lagi untuk menemukan Book yang ingin diubah, lalu dilakukan modifikasi nilai atribut menggunakan setter yang telah kita buat pada class Book. 
4. Delete: Delete juga dilakukan dengan memanfaatkan HashMap, dimana kita akan menemukan Book yang ingin dihapus dengan UUID, lalu tinggal memanfaatkan method .remove()
#### Setelah BookController sudah selesai, kita kemudian membuat input handling yang dilakukan pada main class, dimana akan dilakukan perulangan while untuk meminta input secara terus menerus jika tidak dilakukan break. Lalu untuk mengatur spesialisasi input berdasarkan opsi (1,2,3,4,5,6), dilakukan pengecekan berdasarkan switch case, yang kemudian akan mencetak dan mengambil input berdasarkan pilihan opsi pengguna. Di setiap opsi akan memanfaatkan BookController sebagai operator utamanya. Berikut contoh penjaanan case nya
##### Case Create
![Screen Shot 2023-03-12 at 17 36 52](https://user-images.githubusercontent.com/70261732/224539287-80648164-cd89-4110-9762-852aa2e99e8f.png)
##### Case Update
![Screen Shot 2023-03-12 at 17 38 40](https://user-images.githubusercontent.com/70261732/224539375-d76e4cf5-97e0-4969-8781-31fe1af17d9e.png)
##### Case Get All
![Screen Shot 2023-03-12 at 17 37 39](https://user-images.githubusercontent.com/70261732/224539326-d026e80a-7529-4de4-8844-fd8fde115475.png)
##### Case Get ID
![Screen Shot 2023-03-12 at 17 38 06](https://user-images.githubusercontent.com/70261732/224539349-db1e3246-20e1-4af6-83e5-344a8faab669.png)
##### Case Delete
![Screen Shot 2023-03-12 at 17 39 01](https://user-images.githubusercontent.com/70261732/224539389-9dc464b2-72f4-415d-b793-aad1f743b061.png)






