package Model;

public abstract class Orang {
    //attribut
    protected String nama;
    protected long id;
    
    //konstruktor
    public Orang(){
        
    }
    
    public Orang(String nama, long id){
        this.nama = nama;
        this.id = id;
    }
    
    //method
    public abstract String getNama();

    public abstract void setNama(String nama);

    public abstract long getId();

    public abstract void setId(long id);
}
