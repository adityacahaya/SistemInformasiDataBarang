package Model;

public class Penyedia extends Orang{
    //attribut
    private Barang[] daftarBarang;
    
    //konstruktor
    public Penyedia(){
        
    }
    
    public Penyedia(String nama, long id){
        super(nama,id);
    }
    
    //method abstract
    public String getNama() {
        return super.nama; 
    }

    public void setNama(String nama) {
        super.nama = nama;
    }

    public long getId() {
        return super.id;
    }

    public void setId(long id) {
        super.id = id;
    }
    
    //method Penyedia
    public void createBarang(){
        
    }

    public Barang[] getDaftarBarang() {
        return daftarBarang;
    }
    
    public void setDaftarBarang(int kapasitas){
        daftarBarang = new Barang[kapasitas];
    }
}
