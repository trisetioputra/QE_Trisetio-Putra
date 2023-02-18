# Soal Software Testing Fundamental
## Soal Prioritas 1
1. Sebutkan dan jelaskan berbagai automation testing tool yang dapat digunakan (minimal 3)!
    - Selenium. Merupakan salah satu automation testing framework yang paling populer untuk digunakan terhadap web testing. Web automation testing sendiri berfokus pada fungsionalitas dari komponen UI dan logika bisnis yang dimiliki oleh web. Selenium sendiri memiliki 4 komponen utama, yaitu IDE, Remote Control (RC), Webdriver, dan Grid. 
    - Cypress. Merupakan tools automation lainnya yang sering digunakan dalam pengujian terhadap web. Dari pengalaman saya, menggunakan Cypress cukup memudahkan dikarenakan penggunaan bahasa yang familiar (Javascript) dan juga kemampuan Cypress dalam memanfaatkan DOM yang dimiliki website untuk pencarian dan manipulasi komponen website yang ingin diuji. 
    - Postman. Meskipun Postman lebih sering digunakan sebagai shared API collection, namun Postman juga juga memiliki fungsi bawaan untuk pengujian API terhadap endpoint yang ingin diuji. Tentunya, pada produk API, schema respon merupakan hal yang sangat penting untuk diuji. Dengan Postman, hal tersebut bisa diautomasikan hanya dengan mendefinisikan expected scheme untuk endpoint tersebut. Selain itu, kita juga dapat mengintegrasikan test suite yang dibuat ke dalam pipeline CI/CD.
    - Appium. Berbeda dengan tools sebelumnya, Appium dapat digunakan secara baik untuk automation produk aplikasi native. Appium sendiri berdiri diatas basis javascript dan dapat di-setup secara mudah dengan Node library. Untuk dapat menggunakan Appium, kita harus terlebih dahulu memiliki file .apk untuk android atau .ipa untuk IOS sehingga Appium dapat menjalankan driver di dalam app tersebut. Layaknya pengujian web automation, Appium dapat digunakan untuk menguji fungsionalitas dari aplikasi. Alur automation script yang digunakan juga mirip dengan web automation, dimana akan dilakukan finding terhadap widget menggunakan identifier tertentu, lalu akan dilakukan suatu aksi, yang kemudian akan disamakan antara hasil dari automation dengan hasil expected.
2. Tuliskan secara lengkap kesimpulan dari gambar berikut!
![image](https://user-images.githubusercontent.com/70261732/219845752-d933d25b-9ad5-44b9-b834-6e9ca2cfb100.png)  
Dari gambar tersebut, kita bisa melihat sebuah class sederhana yang mengimplementasikan suatu kalkulator dengan kemampuan untuk menambah dan mengurangi dua buah angka. 
   - Fungsi add memiliki dua parameter, yaitu a dan b dengan tipe data integer. Fungsi akan menjalankan program dengan melakukan penyimpanan hasil penjumlahan a terhadap b ke dalam variabel c. Yang kemudian fungsi akan mengembalikan hasil berupa c. Fungsi add akan mengembalikan error apabila pengguna mengirim nilai a atau b yang berupa non-integer (String, float, double, dll).
   - Fungsi substract memiliki dua parameter, yaitu a dan b dengan tipe data integer. Fungsi akan menjalankan program dengan melakukan penyimpanan hasil pengurangan a terhadap b ke dalam variabel c. Yang kemudian fungsi akan mengembalikan hasil berupa c. Fungsi substract akan mengembalikan error apabila pengguna mengirim nilai a atau b yang berupa non-integer (String, float, double, dll).

## Soal Prioritas 2
1. Tuliskan secara lengkap kesimpulan dari gambar berikut!
![image](https://user-images.githubusercontent.com/70261732/219846169-f117b09e-dc7f-40ec-8f17-bef807bfc86c.png)  
Dapat dilihat dari hasil automation test tersebut, bahwa dilakukan pengujian terhadap 2 fungsi yang berbeda. Yaitu terhadap fungsi add dan juga terhadap fungsi substract. Dapat dilihat juga bahwa fungsi add memiliki satu buah case yang berhasil dan memiliki satu buah case yang gagal. Sama halnya dengan fungsi substract, dimana terdapat satu buah case yang berhasil dan satu buah case yang gagal. Sehingga dapat dikatakan bahwa program yang diuji masih belum bisa diberikan kepada pengguna karena memiliki cacat. Dari sini, perlu dilakukan pengecekan kembali pada kode untuk memastikan bahwa dua case yang masih gagal dapat berhasil. Dapat dilihat juga bahwa waktu pengetesan sangatlah cepat (0.0 ms), sehingga dapat diisyaratkan bahwa pengetesan ini tidak dilakukan terhadap produk API atau front end, namun pengetesan ini hanyalah sebuah unit testing untuk menguji kode. 
## Soal Explorasi
1. Tulis kesimpulan dari hasil pengujian berikut.
![image](https://user-images.githubusercontent.com/70261732/219846830-73e5d508-4759-4820-8bbd-4dff8f89c3a5.png)  
Beberapa hal dapat diamati pada hasil pengetesan tersebut, diantaranya adalah:
    - Pengetesan selesai dalam 21.7 detik
    - Dilakukan terhadap 15 virtual user
    - Terdapat 110 iterasi, atau pengetesan dilakukan sebanyak 110 pengujian
    - Terdapat dua skenario yang diuji
    - 

# Software Testing as a Career Path  

adasda

## Referensi:
https://www.guru99.com/introduction-to-selenium.html
