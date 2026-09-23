/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public abstract class Orang {
    private String nama;
    private String noHp;
 
    public Orang(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }
 
    public String getNama() { return nama; }
    public String getNoHp() { return noHp; }
    public void setNama(String nama) { this.nama = nama; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
 
    public abstract String getInfo();
}
