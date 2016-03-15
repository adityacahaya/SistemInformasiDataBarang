package Model;

import java.io.File;

public class Gudang {
    //attribut
    private long id;
    private int kapasitas;
    private int kapasitas_sisa;
    private String nama_gudang;
    private Barang[] barangGudang = new Barang[1000];
    private int index = 0;
    
    //konstruktor
    public Gudang(){
        
    }
    
    public Gudang(long id, int kapasitas, String nama_gudang){
        this.id = id;
        this.kapasitas = kapasitas;
        this.nama_gudang = nama_gudang;  
    }
    
    //method
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    public String getNama_gudang() {
        return nama_gudang;
    }

    public void setNama_gudang(String nama_gudang) {
        this.nama_gudang = nama_gudang;
    }

    public Barang[] getBarangGudang() {
        return barangGudang;
    }

    public void setBarangGudang(int jumlah_jenis) {
        barangGudang = new Barang[jumlah_jenis];
    }
    
    public int getKapasitas_Sisa(){
        return kapasitas_sisa;
    }
    
    public void setKapasitas_Sisa(int kapasitas){
        this.kapasitas_sisa = kapasitas;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void addBarang(Barang brg, int jumlah){
        this.barangGudang[index] = brg;
        this.setKapasitas_Sisa(this.kapasitas_sisa - jumlah);
        index++;
    }
}
