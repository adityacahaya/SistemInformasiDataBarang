package Model;

public class MainProgam2 {
    
    public static void main(String[] args) {
        
        //tes class penyedia
        Penyedia p = new Penyedia("Kadek","11031201069");
        p.setNama("Aditya");
        p.setId("113120104");
        System.out.println(p.getNama());
        System.out.println(p.getId());
        p.createBarang("Tas", "0008", 10);
        System.out.println(p.getDaftarBarang()[0].getNama_barang());
        System.out.println(p.getIndex());
    
    }
    
}
