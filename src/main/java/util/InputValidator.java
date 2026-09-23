/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;
 
public class InputValidator {
    private static Scanner sc = new Scanner(System.in);
 
    public static String bacaString(String pesan) {
        return bacaString(pesan, null);
    }
 
    public static String bacaString(String pesan, String contoh) {
        while (true) {
            if (contoh != null) System.out.println("contoh: " + contoh);
            System.out.print(pesan);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input tidak boleh kosong!");
        }
    }
 
    public static int bacaInt(String pesan) {
        return bacaInt(pesan, null);
    }
 
    public static int bacaInt(String pesan, String contoh) {
        while (true) {
            if (contoh != null) System.out.println("contoh: " + contoh);
            System.out.print(pesan);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat!");
            }
        }
    }
 
    public static double bacaDouble(String pesan) {
        return bacaDouble(pesan, null);
    }
 
    public static double bacaDouble(String pesan, String contoh) {
        while (true) {
            if (contoh != null) System.out.println("contoh: " + contoh);
            System.out.print(pesan);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
}
