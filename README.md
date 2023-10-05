# Tugas Besar Algeo01-22030

## Deskripsi Program
Program ini dikembangkan untuk memenuhi Tugas Besar Pertama mata kuliah Aljabar Linier dan Geometri IF2123. Program ini bertujuan untuk membantu penguna dalam menyelesaikan suatu sistem persamaan linear, mencari determinan, mencari matriks balikan dari suatu matriks menggunakan eliminasi Gauss, eliminasi Gauss-Jordan, metode matriks balikan, dan kaidah Cramer (untuk matriks dengan n peubah). Program ini juga dapat digunakan untuk menyelesaikan masalah interpolasi polinomial, regresi linear berganda, dan Bicubic Spline Interpolation.  

## Struktur File
┣ bin/<br>
┃ ┣ BicubicSplineInterpolation.class<br>
┃ ┣ IO.class<br>
┃ ┣ InterpolasiPolinomial.class<br>
┃ ┣ Inverse.class<br>
┃ ┣ Kofaktor.class<br>
┃ ┣ Main.class<br>
┃ ┣ Matrix.class<br>
┃ ┣ Menu.class<br>
┃ ┣ MetodeOBE.class<br>
┃ ┗ RegresiLinearBeganda.class<br>
┣ doc/<br>
┃ ┣ Algeo01-22030.pdf<br>
┣ src/<br>
┃ ┣ BicubicSplineInterpolation.java<br>
┃ ┣ IO.java<br>
┃ ┣ InterpolasiPolinomial.java<br>
┃ ┣ Inverse.java<br>
┃ ┣ Kofaktor.java<br>
┃ ┣ Main.java<br>
┃ ┣ Matrix.java<br>
┃ ┣ Menu.java<br>
┃ ┣ MetodeOBE.java<br>
┃ ┗ RegresiLinearBeganda.java<br>
┣ test/<br>
┃ ┣ input/<br>
┃ ┗ output/<br>
┣ Algeo01-22030.jar<br>
┗ README.md<br>

## Cara Menjalankan Program
1. Clone repository ini https://github.com/fabianradenta/Algeo01-22030.git
2. Jalankan program dengan menggunakan .class atau .jar

### Menggunakan .class

1. Pergi folder bin atau mengetik `cd bin` di terminal
2. Buka terminal 
3. Jalankan Main.class dengan mengetik `java Main`

File .txt yang ingin dimasukkan dapat ditaruh di foldet `./test`

### Menggunakan .jar

1. Unduh file .jar yang terletak di laman utama
2. Taruh file .jar pada folder yang diinginkan
3. Pada folder yang berisi file .jar , buat folder bernama `test` untuk menaruh file input
4. cd ke forder yang berisi file .jar 
5. Gunakan command `java -jar <jar-file-name>` untuk menjalankan program

## Anggota Kelompok
1. Imam Hanif Mulyarahman (13522030)
2. Nabila Shikoofa Muida (13522069)
3. Fabian Radenta Bangun (13522105)
