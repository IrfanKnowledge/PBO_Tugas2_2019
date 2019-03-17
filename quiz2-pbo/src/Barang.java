public class Barang {
    String id;           //untuk keperluan mencocokan, misal kunci cocok dengan pintu
    String deskripsi;

    public Barang(String id, String deskripsi) {
        this.id = id;
        this.deskripsi = deskripsi;
    }

    public Barang(){

    }

    //untuk Polymorphism
    public int getKekuatan(){
        return 0;
    }
}
