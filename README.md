# Minpro-2-PBO-SistemPengelolaanStudioTattoo

> Nama : Awang Rifky Muhadzib NIM : 2509116059

## 1. Deskripsi Singkat Program

Program ini adalah pengembangan dari Mini Project 1, berupa aplikasi **CRUD berbasis console (Java)** untuk mengelola data **booking/transaksi pada studio tattoo**. Setiap booking mencatat data pelanggan, data tattoo artist yang mengerjakan, nama desain/layanan, harga, tanggal, dan status pengerjaan (Menunggu, Dikerjakan, Selesai). Pada versi ini, program direstrukturisasi mengikuti pola **MVC (Model-View-Controller)** dan ditambahkan penerapan **inheritance** serta **polymorphism**.

## 2. Penjelasan Alur Program

1. Program dimulai dari `Main.java`, yang membuat objek `BookingController` sebagai pengelola data.
2. Saat `BookingController` dibuat, method `seedData()` otomatis menjalankan **dummy data awal** (2 data booking beserta pelanggan dan artist-nya), sehingga menu **Lihat Semua Booking** langsung menampilkan data tanpa perlu input manual terlebih dahulu.
3. Program menampilkan menu utama secara berulang menggunakan `do-while`, sehingga terus berjalan sampai pengguna memilih menu **0 (Keluar)**.
4. Pemilihan menu diproses dengan `switch`, mengarah ke lima aksi:
   - **Tambah Booking** - pengguna mengisi data pelanggan, artist, dan layanan sekaligus dalam satu alur input (tidak ada menu terpisah untuk kelola pelanggan). Sebelum input dimulai, program menampilkan petunjuk singkat mengenai pilihan spesialisasi artist yang tersedia. Program lalu membuat objek `Pelanggan`, `TattooArtist`, dan `Booking` secara langsung.
   - **Lihat Semua Booking** - menampilkan seluruh data booking, termasuk info pelanggan dan artist yang diambil lewat method `getInfo()` (lihat bagian Polymorphism di bawah).
   - **Update Booking** - memperbarui nama desain, harga, dan tanggal booking berdasarkan ID.
   - **Ubah Status Booking** - mengubah status booking berdasarkan ID.
   - **Hapus Booking** - menghapus data booking berdasarkan ID.
5. Setiap input pengguna divalidasi lewat `InputValidator`, yang juga mendukung penampilan contoh/petunjuk (lewat overload method) - saat ini dipakai untuk memberi tahu pilihan spesialisasi artist di awal alur Tambah Booking, dan format tanggal tepat sebelum field tanggal ditanya.
6. Program kembali ke menu utama setelah setiap aksi, dan berulang hingga pengguna memilih keluar.

## 3. Penjelasan Penerapan Encapsulation dan Inheritance

### Struktur Class
 
| Class | Package | Peran |
|---|---|---|
| `Orang` | `model` | Superclass (abstract) - menyimpan atribut umum `nama` dan `noHp`, serta method abstrak `getInfo()` |
| `Pelanggan` | `model` | Subclass dari `Orang` - menambahkan atribut `alamat` |
| `TattooArtist` | `model` | Subclass dari `Orang` - menambahkan atribut `spesialisasi` |
| `Booking` | `model` | Menyimpan data booking, termasuk objek `Pelanggan` dan `TattooArtist` |
| `BookingView` | `view` | Menampilkan menu utama dan daftar booking ke layar |
| `BookingController` | `controller` | Menyimpan `ArrayList<Booking>`, fungsi CRUD, dan dummy data awal |
| `InputValidator` | `util` | Membaca dan memvalidasi input dari pengguna |
| `Main` | *(default)* | Entry point - menampilkan alur menu dan menghubungkan `controller` dengan `view` |

### Encapsulation

Seluruh atribut pada class `Orang`, `Pelanggan`, `TattooArtist`, dan `Booking` dideklarasikan sebagai `private`, dan hanya dapat diakses/diubah melalui method `getter` dan `setter` yang disediakan.

- **`model/Orang.java`**

<p align="center">
<img width="640" height="362" alt="image" src="https://github.com/user-attachments/assets/f1599319-f55d-4008-a8f8-c611183e8d22" />
</p>

- **`model/Pelanggan.java`**

<p align="center">
<img width="867" height="362" alt="image" src="https://github.com/user-attachments/assets/e187b4a4-9407-46ed-9224-0c555e5ba85a" />
</p>

- **`model/Booking.java`**

<p align="center">
<img width="348" height="176" alt="image" src="https://github.com/user-attachments/assets/b3934e11-7d07-444b-8c5a-0fc14d3fb983" />
</p>

<p align="center">
<img width="567" height="170" alt="image" src="https://github.com/user-attachments/assets/f9dc4386-86cb-46d3-8ed0-d3c8e5a91d08" />
</p>

Dengan pola ini, data pada tiap objek tidak dapat diubah langsung dari luar class (misalnya `booking.harga = 0;` tidak bisa dilakukan), melainkan harus melalui method yang telah disediakan - sehingga nilai yang masuk lebih terkontrol.

### Inheritance

Program menerapkan inheritance dengan **1 superclass dan 2 subclass**:

- **`model/Orang.java`** (superclass, abstract)

<p align="center">
<img width="335" height="72" alt="image" src="https://github.com/user-attachments/assets/6d0e6de0-d18c-4eb8-8e15-aab7b00b18d0" />
</p>

- **`model/Pelanggan.java`** (subclass 1)

<p align="center">
<img width="408" height="50" alt="image" src="https://github.com/user-attachments/assets/d2834560-4d40-482a-8c9f-7e54395df1af" />
</p>

- **`model/TattooArtist.java`** (subclass 2)

<p align="center">
<img width="437" height="46" alt="image" src="https://github.com/user-attachments/assets/6130a3b7-9072-41b1-8921-6af99bdf86df" />
</p>

Kedua subclass **mewarisi** atribut dan method dari `Orang` (seperti `getNama()`, `getNoHp()`, `setNama()`, `setNoHp()`), sekaligus menambahkan atributnya masing-masing (`alamat` pada `Pelanggan`, `spesialisasi` pada `TattooArtist`).

## 4. Penjelasan Letak Penerapan Nilai Tambah

### Struktur MVC (Model-View-Controller)

Program disusun dalam package terpisah sebagai berikut:

<p align="center">
<img width="402" height="332" alt="image" src="https://github.com/user-attachments/assets/466d8e5a-8fe0-4c3c-be5a-f610d3bdb8a0" />
</p>

- **`model`** - hanya berisi struktur data (atribut, constructor, getter/setter), tidak ada logic tampilan maupun proses CRUD.
- **`view`** (`BookingView.java`) - bertanggung jawab menampilkan menu dan data ke layar. Tidak menyimpan data maupun logic pengolahan.
- **`controller`** (`BookingController.java`) - menjembatani `model` dan `view`; menyimpan `ArrayList<Booking>` serta fungsi tambah/cari/update/ubah status/hapus, termasuk dummy data awal.
- **`util`** (`InputValidator.java`) - class pendukung untuk membaca dan memvalidasi input dari pengguna.
- **`Main.java`** - menghubungkan `controller` (proses data) dan `view` (tampilkan hasil ke pengguna).

### Polymorphism - Method Overriding

- **`model/Orang.java`** mendeklarasikan method abstrak:

<p align="center">
<img width="350" height="32" alt="image" src="https://github.com/user-attachments/assets/7a565fb3-bec8-4275-a6ca-c322baa47001" />
</p>

- **`model/Pelanggan.java`** dan **`model/TattooArtist.java`** mengimplementasikannya secara berbeda:

<p align="center">
<img width="831" height="40" alt="image" src="https://github.com/user-attachments/assets/def2f321-2c5e-4d03-bdbd-f38e836e90ff" />
</p>

<p align="center">
<img width="705" height="40" alt="image" src="https://github.com/user-attachments/assets/074ed9a9-baa3-4184-b984-6425b0fde862" />
</p>

- **`view/BookingView.java`** memanggilnya lewat reference bertipe `Orang`:

<p align="center">
<img width="370" height="47" alt="image" src="https://github.com/user-attachments/assets/a4a45650-440b-48db-b219-9ca3856505b7" />
</p>

Method yang dijalankan ditentukan berdasarkan objek aslinya saat runtime, meskipun tipe reference-nya sama (`Orang`) - inilah yang disebut polymorphism.

### Polymorphism - Method Overloading

- **`util/InputValidator.java`** memiliki dua versi method dengan nama sama tapi parameter berbeda:

<p align="center">
<img width="697" height="253" alt="image" src="https://github.com/user-attachments/assets/4d85dfae-8bf9-4390-8656-33e0c291c56e" />
</p>

Pola yang sama diterapkan juga pada `bacaInt()` dan `bacaDouble()`. Versi dengan parameter `contoh` inilah yang dipakai di `Main.java` untuk menampilkan petunjuk pilihan spesialisasi artist dan format tanggal.

### Dummy Data Awal

- **`controller/BookingController.java`**, method `seedData()` dipanggil otomatis lewat constructor, mengisi 2 data booking beserta pelanggan dan artist-nya begitu program dijalankan - sehingga menu **Lihat Semua Booking** langsung menampilkan data tanpa input manual.

### Validasi Input

- **`util/InputValidator.java`** memastikan input angka benar-benar angka (`try-catch NumberFormatException`) dan input teks tidak boleh kosong, dengan validasi ID juga diterapkan pada fitur update/ubah status/hapus di `Main.java`.

## Struktur File Lengkap

```
Main.java
model/Orang.java
model/Pelanggan.java
model/TattooArtist.java
model/Booking.java
view/BookingView.java
controller/BookingController.java
util/InputValidator.java
README.md
```
