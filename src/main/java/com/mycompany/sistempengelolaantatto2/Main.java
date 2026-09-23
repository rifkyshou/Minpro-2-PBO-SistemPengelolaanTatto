/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistempengelolaantatto2;
import model.Booking;
import model.Pelanggan;
import model.TattooArtist;
import view.BookingView;
import controller.BookingController;
import util.InputValidator;

/**
 *
 * @author LENOVO
 */
public class Main {
    static BookingController controller = new BookingController();
 
    public static void main(String[] args) {
        int pilihan;
        do {
            BookingView.tampilkanMenuUtama();
            pilihan = InputValidator.bacaInt("Pilih menu: ");
            switch (pilihan) {
                case 1: tambahBooking(); break;
                case 2: BookingView.tampilkanDaftarBooking(controller.getAllBooking()); break;
                case 3: updateBooking(); break;
                case 4: ubahStatus(); break;
                case 5: hapusBooking(); break;
                case 0: BookingView.tampilkanPesan("Terima kasih, program selesai."); break;
                default: BookingView.tampilkanPesan("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
 
    static void tambahBooking() {
        BookingView.tampilkanPesan("\n========================================================================");
        BookingView.tampilkanPesan("|                         Input Booking Baru                           |");
        BookingView.tampilkanPesan("========================================================================");
        BookingView.tampilkanPesan("Isi data pelanggan, artist, dan layanan berikut ini:");
        BookingView.tampilkanPesan("(Spesialisasi Artist: Realis / Tribal / Minimalis)");
 
        String namaPelanggan = InputValidator.bacaString("Nama Pelanggan: ");
        String hpPelanggan = InputValidator.bacaString("No HP Pelanggan: ");
        String alamatPelanggan = InputValidator.bacaString("Alamat Pelanggan: ");
        Pelanggan pelanggan = new Pelanggan(namaPelanggan, hpPelanggan, alamatPelanggan);
 
        String namaArtist = InputValidator.bacaString("Nama Tattoo Artist: ");
        String hpArtist = InputValidator.bacaString("No HP Artist: ");
        String spesialisasi = InputValidator.bacaString("Spesialisasi Artist: ");
        TattooArtist artist = new TattooArtist(namaArtist, hpArtist, spesialisasi);
 
        String namaDesain = InputValidator.bacaString("Nama Desain/Layanan: ");
        double harga = InputValidator.bacaDouble("Harga: ");
        String tanggal = InputValidator.bacaString("Tanggal Booking (dd-mm-yyyy): ", "20-09-2026");
 
        controller.tambahBooking(pelanggan, artist, namaDesain, harga, tanggal);
        BookingView.tampilkanPesan("Booking berhasil ditambahkan.");
    }
 
    static void updateBooking() {
        int id = InputValidator.bacaInt("ID Booking yang diupdate: ");
        Booking b = controller.cariById(id);
        if (b == null) {
            BookingView.tampilkanPesan("ID tidak ditemukan.");
            return;
        }
 
        BookingView.tampilkanPesan("Isi data baru untuk layanan booking ini:");
        String namaDesain = InputValidator.bacaString("Nama Desain baru: ");
        double harga = InputValidator.bacaDouble("Harga baru: ");
        String tanggal = InputValidator.bacaString("Tanggal baru (dd-mm-yyyy): ", "20-09-2026");
 
        boolean berhasil = controller.updateBooking(id, namaDesain, harga, tanggal);
        BookingView.tampilkanPesan(berhasil ? "Data booking diperbarui." : "ID tidak ditemukan.");
    }
 
    static void ubahStatus() {
        int id = InputValidator.bacaInt("ID Booking: ");
        String status = InputValidator.bacaString("Status baru (Menunggu/Dikerjakan/Selesai): ");
        boolean berhasil = controller.ubahStatus(id, status);
        BookingView.tampilkanPesan(berhasil ? "Status diperbarui." : "ID tidak ditemukan.");
    }
 
    static void hapusBooking() {
        int id = InputValidator.bacaInt("ID Booking yang dihapus: ");
        boolean berhasil = controller.hapusBooking(id);
        BookingView.tampilkanPesan(berhasil ? "Data dihapus." : "ID tidak ditemukan.");
    }
}
