public class BarangSenjata extends Barang {
    int kekuatan;

    public BarangSenjata(String id, String deskrpisi, int kekuatan){
        this.id = id;
        this.deskripsi = deskrpisi;
        this.kekuatan = kekuatan;
    }

    @Override
    public int getKekuatan() {
        return kekuatan;
    }
}
