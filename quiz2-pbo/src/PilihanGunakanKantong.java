/*
    pilihan untuk menampilkan barang yang dimiliki player (isi kantong) dan menggunakannya
 */

public class PilihanGunakanKantong extends Pilihan {

    //adegan tempat pilihan ini berada
    public Adegan oAdegan;


    public PilihanGunakanKantong(Adegan vAdegan, String narasi) {
        super(narasi);
        oAdegan = vAdegan;
    }

    @Override
    public void aksi() {
        //tampilkan dialog untuk memilih barang
        Barang barangPilih = oAdegan.oPlayer.pilihBarang();
        if (barangPilih!=null) {
            //ada barang dipilih, gunakan barang tersebut
            //cek apakah barang bisa digunakan
            if(oAdegan.idBarangMakanan == barangPilih.id){
                //proses menambah kesehatan
                oAdegan.oPlayer.tambahKesehatan(barangPilih);
            }else{
                if (oAdegan.idBarangBisaDigunakan == barangPilih.id)   {
                    //bisa digunakan
                    oAdegan.gunakanBarang(barangPilih);
                } else {
                    System.out.println(String.format("Barang  %s  tidak bisa digunakan!",barangPilih.deskripsi));
                }

                //mengurangi kesehatan krn capek
                oAdegan.oPlayer.kurangiKesehatanKarenaCapek();
            }
        }
    }
}
