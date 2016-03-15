package Model;

public abstract class Orang {
    //attribut
    protected String nama;
    protected String id;
    
    //konstruktor
    public Orang(){
        
    }
    
    public Orang(String nama, String id){
        this.nama = nama;
        this.id = id;
    }
    
    //method
    public abstract String getNama();

    public abstract void setNama(String nama);

    public abstract String getId();

    public abstract void setId(String id);
}
