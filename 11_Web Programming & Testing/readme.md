### Source code ada di folder praktikum
### Soal 1: serenity-sauce-demo
### Soal 2: serenity-sepulsa
### Screenshot hasil Run sauce demo (Terdapat 14 test case)
<img width="1083" alt="image" src="https://user-images.githubusercontent.com/70261732/229837619-31480b12-6e83-4209-a255-98b513ce1230.png">
<img width="1077" alt="image" src="https://user-images.githubusercontent.com/70261732/229837671-a1dfb21b-42b5-416d-9746-981e4c066fd1.png">
<img width="1079" alt="image" src="https://user-images.githubusercontent.com/70261732/229837808-05a80b8e-6397-4078-801f-1c19fbbde109.png">
<img width="1067" alt="image" src="https://user-images.githubusercontent.com/70261732/229837848-0463c8b6-0242-48d4-9da6-e6bfad883330.png">    
 
### Screenshot hasil sepulsa (Terdapat 4 test case)
<img width="1074" alt="image" src="https://user-images.githubusercontent.com/70261732/229838311-ee5adc0c-19dd-4129-b983-686dde7c89df.png">
<img width="1081" alt="image" src="https://user-images.githubusercontent.com/70261732/229838358-6a372215-0d7a-44ac-9568-21a91685a2af.png">
<img width="1071" alt="image" src="https://user-images.githubusercontent.com/70261732/229838404-b0451420-604d-4779-bbe5-b890ffc23b68.png">

### Tahapan singkat pengerjaan soal 1 dan soal 2.
1.Membuat file feature yang berisi tahapan tes dalam bahasa gerkhin. Feature file akan dibagi berdasarkan fitur besar pengerjaan. Seperti berikut contoh untuk kasus soal 1:  
<img width="197" alt="image" src="https://user-images.githubusercontent.com/70261732/229838748-ff62c0da-5bf5-48ba-83cc-edf57de5c2d5.png">  
Masing masing feature file akan berformat BDD, seperti contohnya berikut:
<img width="643" alt="image" src="https://user-images.githubusercontent.com/70261732/229839006-05594b1d-d806-40b3-a2ad-1e4a179184f9.png">  
2. Mengisi file step yang akan mengintepretasikan command- command gerkhin pada file .feature. File step akan memanggil object dari class lain yang extend PageObject. Dan akan memiliki tanda Gerkhin diatas setiap method seperti Given, When, And, dan Then yang sesuai dengan file .feature. Satu file step mungkin memanggil lebih dari satu object class. Berikut contoh implementasi file step pada sauce-demo untuk fitur cart
<img width="1052" alt="image" src="https://user-images.githubusercontent.com/70261732/229841676-116a8836-1030-4722-a8b8-a4704068442d.png">
<img width="1036" alt="image" src="https://user-images.githubusercontent.com/70261732/229840037-9b0929ee-25d2-4f7f-9de5-161dd8fd9fab.png">  
3. Membuat file object, yang berisi obyek UI yang akan dilakukan interaksi, serta method public yang akan menghandle interaksi nya. Method tersebutlah yang akan dipanggil pada class step. Dalam implementasinnya, saya menggunakan library Selenium untuk mencari dan berinteraksi dengan komponen UI tersebut. Dalam mencari, saya menggunakan ID locator, class name, maupun CSS XPath. Lalu untuk interaksinya, saya akan memanfaatkan method- method yang sudah disediakan oleh Selenium, seperti click(), type(), waitUntilVisible(), dan lain- lain. Berikut contoh- contohnya:  
<img width="952" alt="image" src="https://user-images.githubusercontent.com/70261732/229841171-990c1201-33b9-4673-ac44-82bf79169c60.png">
<img width="1035" alt="image" src="https://user-images.githubusercontent.com/70261732/229841333-a1b17a98-9482-497f-bad0-92ad098cf168.png">  
4. Setelah code selesai, maka tinggal menajalankan dengan maven, lalu debug jika terdapat kesalahan pada code berdasarkan report yang dibuat.

