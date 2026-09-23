/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author LENOVO
 */
import model.Booking;
import model.Pelanggan;
import model.TattooArtist;
import java.util.ArrayList;
 
public class BookingController {
    private ArrayList<Booking> daftarBooking = new ArrayList<>();
    private int nextId = 1;
 
    public BookingController() {
        seedData(); // dummy data awal wajib, minimal 1
    }
 
    private void seedData() {
        Pelanggan p1 = new Pelanggan("Andi Saputra", "08124657890", "Banjarmasin");
        TattooArtist a1 = new TattooArtist("Rian Ink", "0821767686", "Realis");
        tambahBooking(p1, a1, "Naga Jepang", 750000, "12-09-2026");
 
        Pelanggan p2 = new Pelanggan("Siti Nurhaliza", "081355657898", "Martapura");
        TattooArtist a2 = new TattooArtist("Dewi Tattoo", "082145456655", "Minimalis");
        tambahBooking(p2, a2, "Bunga Mawar", 350000, "13-09-2026");
    }
 
    public Booking tambahBooking(Pelanggan pelanggan, TattooArtist artist, String namaDesain, double harga, String tanggal) {
        Booking b = new Booking(nextId++, pelanggan, artist, namaDesain, harga, tanggal);
        daftarBooking.add(b);
        return b;
    }
 
    public ArrayList<Booking> getAllBooking() {
        return daftarBooking;
    }
 
    public Booking cariById(int id) {
        for (Booking b : daftarBooking) {
            if (b.getId() == id) return b;
        }
        return null;
    }
 
    public boolean updateBooking(int id, String namaDesain, double harga, String tanggal) {
        Booking b = cariById(id);
        if (b == null) return false;
        b.setNamaDesain(namaDesain);
        b.setHarga(harga);
        b.setTanggal(tanggal);
        return true;
    }
 
    public boolean ubahStatus(int id, String status) {
        Booking b = cariById(id);
        if (b == null) return false;
        b.setStatus(status);
        return true;
    }
 
    public boolean hapusBooking(int id) {
        Booking b = cariById(id);
        if (b == null) return false;
        daftarBooking.remove(b);
        return true;
    }
}
