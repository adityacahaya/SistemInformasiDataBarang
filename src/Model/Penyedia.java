package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Penyedia extends Orang{
    //attribut
    private Barang[] daftarBarang = new Barang[1000];
    private int index = 0;
    File log = new File("Data Barang.txt");
        
    //konstruktor
    public Penyedia(){
        bacaFile();
    }
    
    public Penyedia(String nama, String id){
        super(nama,id);
        bacaFile();
    }
    
    //method abstract
    public String getNama() {
        return super.nama; 
    }

    public void setNama(String nama) {
        super.nama = nama;
    }

    public String getId() {
        return super.id;
    }

    public void setId(String id) {
        super.id = id;
    }
    
    //method Penyedia
    public void bacaFile(){
        try {
            FileReader fr = new FileReader("Data Barang.txt");
            BufferedReader bf = new BufferedReader(fr);
            String x = "";
            String nama_barang = "";
            String id_barang = "";
            int jumlah = 0;
            int i = 0;
            try {
                while((x = bf.readLine()) != null){
                    if(i == 0){
                        nama_barang = x;
                        i++;
                    }else if(i == 1){
                        id_barang = x;
                        i++;
                    }else if(i == 2){
                        jumlah = Integer.parseInt(x);
                        i = 0;
                        Barang brg = new Barang(id_barang,jumlah,nama_barang);
                        this.daftarBarang[index] = brg;
                        index++;
                    }
                }
            } catch (IOException ex) {
                System.out.println("File Gagal Di Baca");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Gagal Di Baca");
        }
    }
    
    public void createBarang(String nama_barang, String id_barang, int jumlah){
        try {
            if(log.exists() == false){
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.println(nama_barang);
            out.println(id_barang);
            out.println(String.valueOf(jumlah));
            out.close();
            out.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        Barang brg = new Barang(id_barang,jumlah,nama_barang);
        this.daftarBarang[index] = brg;
        index++;
    }

    public Barang[] getDaftarBarang() {
        return daftarBarang;
    }
    
    public void setDaftarBarang(int kapasitas){
        daftarBarang = new Barang[kapasitas];
    }
    
    public int getIndex(){
        return index;
    }
}
