## Soal Manual to Automation
### https://docs.google.com/document/d/1RuHZIi0RXlYM44fAz1v9yt49Xr02w_nmLiF2le7o4G8/edit?usp=sharing

## Soal BDD
### Prioritas 1: Source code ada di folder serenity-cucumber-linkedin
### Hasil Report:
<img width="1086" alt="image" src="https://user-images.githubusercontent.com/70261732/228456801-645c4862-dbd6-48b6-b4d3-561a12b9c6cb.png">
<img width="1083" alt="image" src="https://user-images.githubusercontent.com/70261732/228456853-a882d982-123c-4af4-8ee6-6caa72dd0923.png">
<img width="1084" alt="image" src="https://user-images.githubusercontent.com/70261732/228456898-97aafc6b-4a98-4a43-938b-e1ad894e02cb.png">

### Prioritas 2: Source code ada di folder serenity-cucumber-sepulsa
### Hasil Report:
<img width="1081" alt="image" src="https://user-images.githubusercontent.com/70261732/227795692-290b7aa5-9334-4995-8db2-215aefe5bb9d.png">
<img width="1000" alt="image" src="https://user-images.githubusercontent.com/70261732/227795729-34a08bb0-38a2-41bc-9fff-9bfefeea3483.png">
<img width="1000" alt="image" src="https://user-images.githubusercontent.com/70261732/227795741-84915093-a8d7-4776-a8df-16029daff67c.png">

### Penjelasan singkat terkait flow pengerjaan Serenity untuk nomor 1 dan 2
Langkah pengerjaan yang saya lakukan sebagai berikut:
1. Mengeksplorasi manual dahulu terkait apa saja yang bisa di tes dari halaman/ fitur tersebut
2. Membuat syntax gerkhin untuk BDD di file .feature 
<img width="723" alt="image" src="https://user-images.githubusercontent.com/70261732/228457592-ce943fb9-d9ce-484f-812d-dfe149bca498.png">
3. Menambahkan komponen yang akan diinteraksikan pada folder bernama finder. Komponen- komponen tersebut akan dicari berdasarkan CSS locator, dimana identifier nya berdasarkan komponen id ataupun class pada source code HTML.
<img width="700" alt="image" src="https://user-images.githubusercontent.com/70261732/228457941-bbf6d639-41ed-46b6-a3c2-74a5dbce8cd7.png"> 
Jika tidak terdapat id, maka saya biasanya akan menggunakan class yang dikombinasikan dengan contains text. 
<img width="685" alt="image" src="https://user-images.githubusercontent.com/70261732/228458601-1dc5d2d7-a972-4195-9380-b206c4e12b78.png">
Serta jika ada komponen yang harus dicari berdasarkan kata kunci, saya akan mengubahnya dari tipe data Target menjadi Performable, dimana locator akan berjalan sesuai dengan kata kunci yang diterima.
<img width="693" alt="image" src="https://user-images.githubusercontent.com/70261732/228459481-7352a798-bddc-4269-9748-0c5635b7f697.png">
4. Setelah komponen ditemukan, saya akan menambahkan interaksi di dalam folder navigation dengan kembalian berupa tipe data Performable. Interaksi kali ini terbatas pada Click dan Enter value. Seperti berikut:
<img width="705" alt="image" src="https://user-images.githubusercontent.com/70261732/228459743-5d744f95-630b-435d-b049-7a4409a8fbaf.png">
Interaksi akan dilakukan terhadap komponen yang ada pada tahap 3.  
5. Setelahnya, method method pada nomor 4 akan dipanggil pada file StepDefinition yang berisi langkah pengerjaan yang sudah terhubung dengan file feature menggunakan syntax Given, When, And, dan Then. 
<img width="671" alt="image" src="https://user-images.githubusercontent.com/70261732/228460286-631e5fe0-82c2-46a9-ad50-c689e9e48e4a.png">
Perlu dicatat bahwa terkadang suatu komponen perlu ditunggu dulu beberapa saat, sebelum bisa kita konfirmasi kebenarannya. Seperti contohnya ketika pengguna berhasil login pada aplikasi sepulsa.com, maka akan muncul peringatan berhasil login terlebih dahulu sebelum akhirnya pengguna dimasukan ke homepage. Maka dari itu, kadang saya menggunakan syntax WaitUntil pada step definition, sebagai tanda bahwa Serenity harus menunggu hinga komponen tertentu berhasil di load, untuk dapat melanjutkan tes. Berikut contohnya
<img width="705" alt="image" src="https://user-images.githubusercontent.com/70261732/228460752-1bf2a2df-8704-4f59-a51e-d595149bff6a.png">
6. Setelahnya tinggal menjalankan maven untuk melihat hasil test.

### Explorasi: Source code ada di folder sepulsa-cypress
### Hasil report:
<img width="1104" alt="image" src="https://user-images.githubusercontent.com/70261732/228510616-df4fb19f-5076-4449-9063-258740299587.png">
### Penjelasan singkat terkait flow pengerjaan Cypress sepulsa.com
Langkah pengerjaan yang saya lakukan sebagai berikut:
1. Menggunakan file gerkhin .feature yang sama dengan Serenity, saya mengcopy ke dalam file .feature pada cypress
<img width="768" alt="image" src="https://user-images.githubusercontent.com/70261732/228511021-b0ec6a52-e2c5-4636-bad7-945c0c3bc843.png">
2. Membuat file steps yang dipisahkan berdasarkan halaman. File- file steps ini adalah pengimplementasian step gerkhin di .feature, dimana akan dilakukan verifikasi ekspektasi menggunakan method .should() yang dimiliki cypress. Berikut contohnya: 
<img width="1059" alt="image" src="https://user-images.githubusercontent.com/70261732/228511283-18dae84e-cba8-422e-a1f0-85ed325a6033.png">
3. Membuat class untuk masing- masing page yang akan kena pengujian, dimana class tersebut akan berisi method yang berfungsi untuk mencari komponen UI dengan CSS finder melalui method .get() pada cypress
<img width="1110" alt="image" src="https://user-images.githubusercontent.com/70261732/228511713-9a3d7606-9b82-484b-a4e1-11ddd04803ac.png">
Class tersebut akan dipanggil pada file step seperti yang disebutkan pada nomor 2.    
4. Menjalankan menggunakan npx cypress open dan melihat report.

