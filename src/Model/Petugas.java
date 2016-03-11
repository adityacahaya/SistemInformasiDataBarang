package Model;

public class Petugas extends Orang{
    
    //konstruktor
    public Petugas(){
        
    }
    
    public Petugas(String nama, long id){
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
    
    //method petugas
    public void addBarang(){
        
    }
    
    public void hapusBarang(){
        
    }
    
    public void editBarang(){
        
    }
    
    public void lihatBarang(){
        
    }
}
