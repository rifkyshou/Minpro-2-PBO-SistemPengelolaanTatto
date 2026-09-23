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
5. Setiap input pengguna divalidasi lewat `InputValidator`, yang juga mendukung penampilan contoh/petunjuk (lewat overload method) — saat ini dipakai untuk memberi tahu pilihan spesialisasi artist di awal alur Tambah Booking, dan format tanggal tepat sebelum field tanggal ditanya.
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
```java
private String nama;
private String noHp;

public String getNama() { return nama; }
public void setNama(String nama) { this.nama = nama; }
```

- **`model/Pelanggan.java`**
```java
private String alamat;

public String getAlamat() { return alamat; }
public void setAlamat(String alamat) { this.alamat = alamat; }
```

- **`model/Booking.java`**
```java
private double harga;
private String status;

public double getHarga() { return harga; }
public void setStatus(String status) { this.status = status; }
```

Dengan pola ini, data pada tiap objek tidak dapat diubah langsung dari luar class (misalnya `booking.harga = 0;` tidak bisa dilakukan), melainkan harus melalui method yang telah disediakan — sehingga nilai yang masuk lebih terkontrol.

### Inheritance

Program menerapkan inheritance dengan **1 superclass dan 2 subclass**:

- **`model/Orang.java`** (superclass, abstract)
```java
public abstract class Orang {
    private String nama;
    private String noHp;
    ...
    public abstract String getInfo();
}
```

- **`model/Pelanggan.java`** (subclass 1)
```java
public class Pelanggan extends Orang {
    private String alamat;
    ...
}
```

- **`model/TattooArtist.java`** (subclass 2)
```java
public class TattooArtist extends Orang {
    private String spesialisasi;
    ...
}
```

Kedua subclass **mewarisi** atribut dan method dari `Orang` (seperti `getNama()`, `getNoHp()`, `setNama()`, `setNoHp()`), sekaligus menambahkan atributnya masing-masing (`alamat` pada `Pelanggan`, `spesialisasi` pada `TattooArtist`).

## 4. Penjelasan Letak Penerapan Nilai Tambah

### Struktur MVC (Model-View-Controller)

Program disusun dalam package terpisah sebagai berikut:

```
studio-tattoo-minpro2/
├── Main.java                          -> Entry point program
├── model/                             -> MODEL: representasi data
│   ├── Orang.java                     -> superclass (abstract)
│   ├── Pelanggan.java                 -> subclass dari Orang
│   ├── TattooArtist.java              -> subclass dari Orang
│   └── Booking.java                   -> entitas transaksi
├── view/                              -> VIEW: tampilan ke layar
│   └── BookingView.java
├── controller/                        -> CONTROLLER: logika aplikasi
│   └── BookingController.java
└── util/                              -> UTILITY: validasi input
    └── InputValidator.java
```

- **`model`** - hanya berisi struktur data (atribut, constructor, getter/setter), tidak ada logic tampilan maupun proses CRUD.
- **`view`** (`BookingView.java`) - bertanggung jawab menampilkan menu dan data ke layar. Tidak menyimpan data maupun logic pengolahan.
- **`controller`** (`BookingController.java`) - menjembatani `model` dan `view`; menyimpan `ArrayList<Booking>` serta fungsi tambah/cari/update/ubah status/hapus, termasuk dummy data awal.
- **`util`** (`InputValidator.java`) - class pendukung untuk membaca dan memvalidasi input dari pengguna.
- **`Main.java`** - menghubungkan `controller` (proses data) dan `view` (tampilkan hasil ke pengguna).

### Polymorphism - Method Overriding

- **`model/Orang.java`** mendeklarasikan method abstrak:
```java
public abstract String getInfo();
```

- **`model/Pelanggan.java`** dan **`model/TattooArtist.java`** mengimplementasikannya secara berbeda:
```java
// Pelanggan.java
public String getInfo() {
    return "Nama: " + getNama() + " | HP: " + getNoHp() + " | Alamat: " + alamat;
}

// TattooArtist.java
public String getInfo() {
    return "Nama: " + getNama() + " | Spesialisasi: " + spesialisasi;
}
```

- **`view/BookingView.java`** memanggilnya lewat reference bertipe `Orang`:
```java
Orang pelanggan = b.getPelanggan();
Orang artist = b.getArtist();
System.out.println(pelanggan.getInfo()); // menjalankan versi Pelanggan
System.out.println(artist.getInfo());    // menjalankan versi TattooArtist
```
Method yang dijalankan ditentukan berdasarkan objek aslinya saat runtime, meskipun tipe reference-nya sama (`Orang`) - inilah yang disebut polymorphism.

### Polymorphism - Method Overloading

- **`util/InputValidator.java`** memiliki dua versi method dengan nama sama tapi parameter berbeda:
```java
public static String bacaString(String pesan)                 // tanpa contoh
public static String bacaString(String pesan, String contoh)  // dengan contoh/petunjuk
```
Pola yang sama diterapkan juga pada `bacaInt()` dan `bacaDouble()`. Versi dengan parameter `contoh` inilah yang dipakai di `Main.java` untuk menampilkan petunjuk pilihan spesialisasi artist dan format tanggal.

### Dummy Data Awal

- **`controller/BookingController.java`**, method `seedData()` dipanggil otomatis lewat constructor, mengisi 2 data booking beserta pelanggan dan artist-nya begitu program dijalankan — sehingga menu **Lihat Semua Booking** langsung menampilkan data tanpa input manual.

### Validasi Input

- **`util/InputValidator.java`** memastikan input angka benar-benar angka (`try-catch NumberFormatException`) dan input teks tidak boleh kosong, dengan validasi ID juga diterapkan pada fitur update/ubah status/hapus di `Main.java`.

## Cara Menjalankan Program

Jalankan dari root folder project:
```bash
javac -d . Main.java model/*.java view/*.java controller/*.java util/*.java
java Main
```

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
