package Model;

public class Barang {
    //atribut
    private long id;
    private int jumlah_stok;
    private String nama_barang;
    
    //konstruktor
    public Barang(){
        
    }
    
    public Barang(long id, int jumlah_stok, String nama_barang){
        this.id = id;
        this.jumlah_stok = jumlah_stok;
        this.nama_barang = nama_barang;
    }
    
    //method
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getJumlah_stok() {
        return jumlah_stok;
    }

    public void setJumlah_stok(int jumlah_stok) {
        this.jumlah_stok = jumlah_stok;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
}
