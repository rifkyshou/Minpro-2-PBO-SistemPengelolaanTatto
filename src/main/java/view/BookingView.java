/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author LENOVO
 */
import model.Booking;
import model.Orang;
import java.util.ArrayList;
 
public class BookingView {
 
    public static void tampilkanMenuUtama() {
        System.out.println("\n========================================================================");
        System.out.println("|                    SISTEM PENGELOLAAN STUDIO TATTOO                  |");
        System.out.println("========================================================================");
        System.out.println(" 1. Tambah Booking");
        System.out.println(" 2. Lihat Semua Booking");
        System.out.println(" 3. Update Booking");                                              
        System.out.println(" 4. Ubah Status Booking");
        System.out.println(" 5. Hapus Booking");
        System.out.println(" 0. Keluar");
        System.out.println("========================================================================");
    }
 
    public static void tampilkanDaftarBooking(ArrayList<Booking> daftar) {
        System.out.println("\n========================================================================");
        System.out.println("|                          Daftar Booking                              |");
        if (daftar.isEmpty()) {
            System.out.println("(Belum ada data)");
            return;
        }
        for (Booking b : daftar) {
            Orang pelanggan = b.getPelanggan();
            Orang artist = b.getArtist();
 
            System.out.println("========================================================================");
            System.out.println("ID Booking : " + b.getId());
            System.out.println("Pelanggan  : " + pelanggan.getInfo());
            System.out.println("Artist     : " + artist.getInfo());
            System.out.println("Desain     : " + b.getNamaDesain());
            System.out.println("Harga      : Rp" + b.getHarga());
            System.out.println("Tanggal    : " + b.getTanggal());
            System.out.println("Status     : " + b.getStatus());
        }
        System.out.println("========================================================================");
    }
 
    public static void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}
