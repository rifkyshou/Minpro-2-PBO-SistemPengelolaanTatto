/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Booking {
    private int id;
    private Pelanggan pelanggan;
    private TattooArtist artist;
    private String namaDesain;
    private double harga;
    private String tanggal;
    private String status;
 
    public Booking(int id, Pelanggan pelanggan, TattooArtist artist, String namaDesain, double harga, String tanggal) {
        this.id = id;
        this.pelanggan = pelanggan;
        this.artist = artist;
        this.namaDesain = namaDesain;
        this.harga = harga;
        this.tanggal = tanggal;
        this.status = "Menunggu";
    }
 
    public int getId() { return id; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public TattooArtist getArtist() { return artist; }
    public String getNamaDesain() { return namaDesain; }
    public double getHarga() { return harga; }
    public String getTanggal() { return tanggal; }
    public String getStatus() { return status; }
 
    public void setNamaDesain(String namaDesain) { this.namaDesain = namaDesain; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public void setStatus(String status) { this.status = status; }
}
