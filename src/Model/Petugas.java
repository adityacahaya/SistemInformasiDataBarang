package Model;

import View.MenuPetugas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Petugas extends Orang{
    //attribut
    File log = new File("Data Gudang.txt");
    Gudang g = new Gudang();
            
    //konstruktor
    public Petugas(){
        bacaFile();
    }
    
    public Petugas(String nama, String id){
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
    
    //method petugas
    public void addBarang(String nama_barang, int jumlah){
        Penyedia p = new Penyedia();
        Barang b = new Barang();
        boolean ketemu = false;
        
        int i = 0;
        int j = 0;
        for(i = 0; i < p.getIndex(); i++){
            if(p.getDaftarBarang()[i].getNama_barang().equals(nama_barang)){
                b = p.getDaftarBarang()[i];
                break;
            }
        }
        for(j = 0; j < g.getIndex(); j++){
            if(g.getBarangGudang()[j].getNama_barang().equals(nama_barang)){
                ketemu = true;
                break;
            }
        }
        if(ketemu){
            JOptionPane.showMessageDialog(null, "Barang "
                    + "Sudah Ada Dalam Gudang", "Error !", 0);
        }else
        if(jumlah > b.getJumlah_stok() || jumlah > g.getKapasitas_Sisa()){
            JOptionPane.showMessageDialog(null, "Jumlah Barang "
                    + "melebihi kapasitas", "Error !", 0);
        }
        else{
            b.setJumlah_stok(jumlah);
            g.addBarang(b);
            try {
                if(log.exists() == false){
                    log.createNewFile();
                }
                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                out.println(b.getNama_barang());
                out.println(b.getId());
                out.println(String.valueOf(jumlah));
                out.close();
                out.flush();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            JOptionPane.showMessageDialog(null, "Barang Berhasil"
                + "di Tambahkan","Sukses !", 1);
        }   
    }
    
    public void hapusBarang(String nama_barang){
        Penyedia p = new Penyedia();
        Barang b = new Barang();
        boolean ketemu = false;
        
        int j = 0;
        for(j = 0; j < g.getIndex(); j++){
            if(g.getBarangGudang()[j].getNama_barang().equals(nama_barang)){
                ketemu = true;
                break;
            }
        }
        if(ketemu==false){
            JOptionPane.showMessageDialog(null, "Barang "
                    + "Tidak Ada Dalam Gudang", "Error !", 0);
        }else{
            int k = 0;
            g.setKapasitas_Sisa(g.getKapasitas_Sisa() + g.getBarangGudang()[j]
                    .getJumlah_stok());
            for(k = j; k < g.getIndex(); k++){
                g.getBarangGudang()[k] = g.getBarangGudang()[k+1];
            }
            g.setIndex(g.getIndex()-1);
            try {
                if(log.exists() == false){
                    log.createNewFile();
                }
                PrintWriter out = new PrintWriter(new FileWriter(log, false));
                out.close();
                out.flush();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            
            try {
                if(log.exists() == false){
                    log.createNewFile();
                }
                PrintWriter out = new PrintWriter(new FileWriter(log, false));
                for(int i = 0; i < g.getIndex(); i++){
                    out.println(g.getBarangGudang()[i].getNama_barang());
                    out.println(g.getBarangGudang()[i].getId());
                    out.println(g.getBarangGudang()[i].getJumlah_stok());
                }
                out.close();
                out.flush();
                JOptionPane.showMessageDialog(null, "Barang "
                    + "Telah Di Hapus", "Sukses !", 1);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void editBarang(String nama_barang, int jumlah){
        Penyedia p = new Penyedia();
        Barang b = new Barang();
        boolean ketemu = false;
        int j = 0;
        for(j = 0; j < g.getIndex(); j++){
            if(g.getBarangGudang()[j].getNama_barang().equals(nama_barang)){
                ketemu = true;
                break;
            }
        }
        System.out.println(ketemu);
        
        if(ketemu==false){
            JOptionPane.showMessageDialog(null, "Barang "
                    + "Tidak Ada Dalam Gudang", "Error !", 0);
        }else
        if(jumlah > g.getKapasitas_Sisa()){
            JOptionPane.showMessageDialog(null, "Kapasitas "
                    + "Gudang Kurang", "Error !", 0);
        }else{
            g.getBarangGudang()[j].setJumlah_stok(jumlah);
            
            try {
                if(log.exists() == false){
                    log.createNewFile();
                }
                PrintWriter out = new PrintWriter(new FileWriter(log, false));
                out.close();
                out.flush();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            
            try {
                if(log.exists() == false){
                    log.createNewFile();
                }
                int jum = 0;
                PrintWriter out = new PrintWriter(new FileWriter(log, false));
                for(int i = 0; i < g.getIndex(); i++){
                    out.println(g.getBarangGudang()[i].getNama_barang());
                    out.println(g.getBarangGudang()[i].getId());
                    out.println(g.getBarangGudang()[i].getJumlah_stok());
                    jum = jum + g.getBarangGudang()[i].getJumlah_stok();
                }
                g.setKapasitas_Sisa(g.getKapasitas() - jum);
                out.close();
                out.flush();
                JOptionPane.showMessageDialog(null, "Barang "
                    + "Telah Di Edit", "Sukses !", 1);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void lihatBarang(MenuPetugas m, String nama){
        String[] kolom = {"Nama Barang","Id Barang","Jumlah"};
        if(nama.equals("--")){
            Object[][] objekTable = new Object[this.g.getIndex()][3];
            for(int i = 0; i < this.g.getIndex(); i++){
                String[] arrData = {
                    this.g.getBarangGudang()[i].getNama_barang(),
                    this.g.getBarangGudang()[i].getId(),
                    String.valueOf(this.g.getBarangGudang()[i].getJumlah_stok())};
                objekTable[i] = arrData;
                TableModel tm = new DefaultTableModel(objekTable,kolom);
                m.getTableDataGudang().setModel(tm);
            }
        }else{
            for(int i = 0; i < this.g.getIndex(); i++){
                if(g.getBarangGudang()[i].getNama_barang().equals(nama)){
                    String[] arrData = {
                        this.g.getBarangGudang()[i].getNama_barang(),
                        this.g.getBarangGudang()[i].getId(),
                        String.valueOf(this.g.getBarangGudang()[i].getJumlah_stok())};
                    Object[][] objekTable = new Object[1][3];
                    objekTable[0] = arrData;
                    TableModel tm = new DefaultTableModel(objekTable,kolom);
                    m.getTableDataGudang().setModel(tm);
                    break;
                }
            }
        }    
    }
    
    public void bacaFile(){
        try {
            g.setNama_gudang("Gudang 1");
            g.setId(100);
            g.setKapasitas(100);
            g.setKapasitas_Sisa(100);
            
            FileReader fr = new FileReader("Data Gudang.txt");
            BufferedReader bf = new BufferedReader(fr);
            String x = "";
            String nama_barang = "";
            String id_barang = "";
            int jumlah_barang;
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
                        jumlah_barang = Integer.parseInt(x);
                        i++;
                        Barang brg = new Barang(id_barang,jumlah_barang,nama_barang);
                        g.addBarang(brg);
                        i = 0;
                    }
                }
                
            } catch (IOException ex) {
                System.out.println("File Gagal Di Baca");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Gagal Di Baca");
        }
    }
    
    public Gudang getGudang(){
        return this.g;
    }
    
    public void setGudang(Gudang g){
        this.g = g;
    }
}
