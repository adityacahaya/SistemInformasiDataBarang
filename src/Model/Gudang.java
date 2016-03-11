package Model;

public class Gudang {
    //attribut
    private long id;
    private int kapasitas;
    private String nama_gudang;
    private Barang[] barangGudang;
    
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
    
    public void addBarang(){
        
    }
}
