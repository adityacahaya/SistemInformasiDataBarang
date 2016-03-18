package Model;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainProgram {
    
    public static void menuUtama() {
        
        Scanner s = new Scanner(System.in);
        int pilihan = 0;
        String nama;
        String id;
        
        System.out.println("   Sistem Informasi Data Barang   ");
        System.out.println("==================================");
        System.out.println("Masukkan Pilihan Menu : ");
        System.out.println("1. Penyedia");
        System.out.println("2. Petugas");
        System.out.print("Masukkan Pilihan : ");
        pilihan = s.nextInt();
        System.out.println("");
        switch(pilihan){
            case 1 :{
                System.out.println("Masukkan Identitas Penyedia : ");
                System.out.print("Nama : ");
                nama = s.next();
                System.out.print("Id   : ");
                id = s.next();
                
                Penyedia penyedia = new Penyedia(id, nama);
                
                System.out.println("");
                menuPenyedia(penyedia);
                break;
            }
            case 2 :{
                System.out.println("Masukkan Identitas Petugas : ");
                System.out.print("Nama : ");
                nama = s.next();
                System.out.print("Id   : ");
                id = s.next();
                
                Petugas p = new Petugas(id, nama);
                
                System.out.println("");
                menuPetugas(p);
                break;
            }
        }
    }
    
    public static void menuPenyedia(Penyedia p){
        
        Scanner s = new Scanner(System.in);
        int pilihan = 0;
        
        System.out.println("==========Menu Penyedia==========");
        System.out.println("Nama Penyedia : "+p.getNama());
        System.out.println("Id            : "+p.getId());
        System.out.println("=================================");
        System.out.println("Masukkan Pilihan Menu Penyedia : ");
        System.out.println("1. Create Data Barang");
        System.out.println("2. Lihat Data Barang");
        System.out.println("3. Keluar");
        System.out.print("Masukkan Pilihan : ");
        pilihan = s.nextInt();
        System.out.println("");
        switch(pilihan){
            case 1 :{
                createBarang(p);
                break;
            }
            case 2 :{
                lihatDataBarang(p);
                break;
            }
            case 3 :{
                System.exit(0);
                break;
            }
        }
    }
    
    public static void createBarang(Penyedia p) {
        
        Scanner s = new Scanner(System.in);
        String namaBarang;
        String idBarang;
        int jumlahStok;
        
        System.out.println("==========Create Barang==========");
        System.out.println("Nama Penyedia : "+p.getNama());
        System.out.println("Id            : "+p.getId());
        System.out.println("=================================");
        System.out.println("Masukkan Data Barang : ");
        System.out.print("Nama Barang : ");
        namaBarang = s.next();
        System.out.print("Id Barang   : ");
        idBarang = s.next();
        System.out.print("Jumlah Stok : ");
        jumlahStok = s.nextInt();
        
        System.out.println("");
        if(namaBarang.equals("")){
            System.out.println("Error! Nama Tidak Boleh Kosong");
            System.out.println("");
            createBarang(p);
        }else
        if(idBarang.equals("")){
            System.out.println("Error! Id Tidak Boleh Kosong");
            System.out.println("");
            createBarang(p);
        }else{
            try{
                boolean ketemu = true;
                for(int i=0; i< p.getIndex(); i++){
                    if(p.getDaftarBarang()[i].getNama_barang().equals(namaBarang)){
                        System.out.println("Error ! Nama Barang Sudah "
                                + "Digunakan");
                        System.out.println("");
                        createBarang(p);
                        ketemu = false;
                        break;
                    }else
                    if(p.getDaftarBarang()[i].getId().equals(idBarang)){
                        System.out.println("Error ! Id Barang Sudah "
                                + "Digunakan");
                        System.out.println("");
                        createBarang(p);
                        ketemu = false;
                        break;
                    }
                }
                if(ketemu){
                    p.createBarang(namaBarang, idBarang, jumlahStok);
                    System.out.println("Sukses ! Barang Berhasil "
                                + "Di Buat");
                    System.out.println("");
                    menuPenyedia(p);
                    ketemu = false;
                }
            }catch(Exception e){
                System.out.println("Error ! Data Inputan Salah");
                System.out.println("");
                createBarang(p);
            }
        }
        
    }
    
    public static void lihatDataBarang(Penyedia p) {
        
        System.out.println("========= Lihat Barang ==========");
        System.out.println("Nama Penyedia : "+p.getNama());
        System.out.println("Id            : "+p.getId());
        System.out.println("=================================");
        for(int i = 0; i < p.getIndex(); i++){
            System.out.println("Nama Barang : "+p.getDaftarBarang()[i]
                    .getNama_barang());
            System.out.println("Id Barang   : "+p.getDaftarBarang()[i]
                    .getId());    
            System.out.println("Jumlah Stok : "+p.getDaftarBarang()[i]
                    .getJumlah_stok());
            System.out.println("=================================");
        }
        System.out.println("");
        menuPenyedia(p);
    }
    
    public static void menuPetugas(Petugas p){
        
        Scanner s = new Scanner(System.in);
        int pilihan = 0;
        
        System.out.println("==========Menu Petugas==========");
        System.out.println("Nama Petugas  : "+p.getNama());
        System.out.println("Id            : "+p.getId());
        System.out.println("=================================");
        System.out.println("Masukkan Pilihan Menu Petugas : ");
        System.out.println("1. Tambah Barang ke Gudang");
        System.out.println("2. Lihat Data Barang dalam Gudang");
        System.out.println("3. Edit Data Barang dalam Gudang");
        System.out.println("4. Hapus Data Barang dalam Gudang");
        System.out.println("5. Keluar");
        System.out.print("Masukkan Pilihan : ");
        pilihan = s.nextInt();
        System.out.println("");
        switch(pilihan){
            case 1 :{
                tambahBarangGudang(p);
                break;
            }
            case 2 :{
                lihatBarangGudang(p);
                break;
            }
            case 3 :{
                editBarangGudang(p);
                break;
            }
            case 4 :{
                hapusBarangGudang(p);
                break;
            }
            case 5 :{
                System.exit(0);
                break;
            }
        }
    }
    
    public static void tambahBarangGudang(Petugas p) {
        
        Scanner s = new Scanner(System.in);
        Penyedia pp = new Penyedia();
        String namaBarang;
        String idBarang;
        int jumlahStok;
        
        System.out.println("=======Tambah Barang Gudang======");
        System.out.println("Nama Petugas : "+p.getNama());
        System.out.println("Id           : "+p.getId());
        System.out.println("=================================");
        System.out.println("Masukkan Data Barang : ");
        System.out.print("Nama Barang : ");
        namaBarang = s.next();
        System.out.print("Jumlah Stok : ");
        jumlahStok = s.nextInt();
        
        for(int i = 0; i < pp.getIndex(); i++){
            if(pp.getDaftarBarang()[i].getNama_barang().equals(namaBarang)){
                System.out.println("Error ! Barang Sudah Pernah di Masukkan");
                System.out.println("");
                menuPetugas(p);
                break;
            }
        }
        
    }
    
    public static void lihatBarangGudang(Petugas p) {
        
    }
    
    public static void editBarangGudang(Petugas p) {
        
    }
    
    public static void hapusBarangGudang(Petugas p) {
        
    }
    
    public static void main(String[] args) {
        menuUtama();
    }
}
