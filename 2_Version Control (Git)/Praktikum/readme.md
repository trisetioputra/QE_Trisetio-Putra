### Soal Prioritas 1
<img width="1081" alt="image" src="https://user-images.githubusercontent.com/70261732/221183684-1137f0d7-b2fc-4231-bd8d-c3e22d2096fd.png">  

### Soal Prioritas 2
- Buatlah branch baru pada github yang kalian buat
<img width="800" alt="image" src="https://user-images.githubusercontent.com/70261732/221196553-2fa392b1-0853-4f39-915f-3c7387b97f55.png">

Saya menambahkan kata kata pada readme.md directory terluar

- Lakukan Pull Request pada branch tersebut sehingga akan menambah hal baru pada branch main/master
    - terdapat foto terkait Pull Request
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221198858-1f638d87-cd72-4d4a-8b77-9e6673957893.png">
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221198593-898ba9e2-68dc-4b18-b003-5eeff58fd708.png">
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221199011-ebd45884-638e-46fb-af9f-a802c229b34c.png">


### Soal Eksplorasi
- dengan project terserah kalian, praktikkan salah satu workflow serderhana dan buktikan dengan Screenshoot. github flow/gitflow/trunkbase
    - akan ada foto terkait flow yang disebutkan
- lakukan management konflik pada github
- Lakukan code review pada github yang kalian kumpulkan
    - terdapat foto seperti apa itu code review

1. Pada soal ini, saya mencoba membuat class Java bernama MathTest yang hanya berisi constructor dan fungsi add
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221217902-3226c523-f8da-4ab8-aaa2-eeaef3af1658.png">
2. Lalu code tersebut saya push ke remote repository di branch main
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221218108-a1a7202c-2950-4b23-9543-9d9327381175.png">
3. Kemudian, saya membuat dua branch baru dari main, yang bernama feat/delete dan feat/multiply  
4. Pada branch feat/delete dilakukan penambahan dari code di main, yaitu fungsi delete untuk pengurangan
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221218646-341d9ebf-f40a-435d-a0f1-786c12983d6a.png">
5. Pada branch feat/multiply dilakukan penambahan dari code di main, yaitu fungsi multiply untuk perkalian
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221219219-e8adfceb-d3d9-443d-a223-24c44d26e07a.png">
6. Setelah di push, maka akan muncul notifikasi pull request di github
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221219665-5c07130b-c51e-417a-bc30-e1b9d1bedd26.png">
7. Karena kedua fitur sudah selesai dikembangkan, maka akan dilakukan merging pada branch main. Untuk pertama, branch feat/delete yang dimerge ke main. Karena tidak terdapat conflict, maka kita bisa langsung merge tanpa ada isu.
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221219968-c1d2621f-ac52-45ab-982d-711cfde94a7d.png">
8. Maka pada saat ini, class MathTest sudah memiliki dua fitur, yaitu add dan delete. Sehingga code akan seperti ini di branch main
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221220190-87adcb5f-62b6-41e2-bc54-4615182dec32.png">
9. Kemudian, kita akan melakukan PR dari branch feat/multiply ke main. Namun, akan muncul conflict, karena saat ini, fungsi multiply berada pada fungsi delete. Sehingga ketika dilakukan PR, akan muncul peringatan seperti berikut
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221220843-7a156160-97a7-4916-abf2-1307f461a929.png">
10. Namun, sebelum merge, akan ditambahkan fitur division juga yang merupakan requirement baru. Namun, dalam pengembangan fungsi division, terdapat code review untuk perbaikan code
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221221582-64a057d0-706e-48b0-bcd3-850567bab902.png">
11. Setelah dilakukan perbaikan kode berdasarkan code review, dilakukan push ulang ke branch feat/multiply dan dilakukan conflict resolvement melalui github
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221222002-40e6c77d-a5f6-4015-b363-a140300a9846.png">
12. Setelah itu, code berhasil di merge dan fitur multiply dan division sudah ada di branch main
<img width="500" alt="image" src="https://user-images.githubusercontent.com/70261732/221222481-1e31d1a9-b6aa-42cd-be85-0f630892c27b.png">



