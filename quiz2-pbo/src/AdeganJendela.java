public class AdeganJendela extends Adegan{
    boolean isTerkunci = true;
    String narasiTerkunci = "Rudi mendekati jendela. Rudi mencoba membuka jendela. \"Ah terkunci\"";
    String narasiTerbuka  = "Rudi mencoba membuka jendela dan terbuka!";

    //constructor
    public AdeganJendela () {
        narasi = narasiTerkunci;
    }

    /* user berhasil menggunakan kunci untuk membuka jendela */
    @Override
    public void gunakanBarang(Barang barangPilih) {
        super.gunakanBarang(barangPilih); //panggil parent
        isTerkunci = false;
        narasi = narasiTerbuka;

        //karena jendela sudah terbuka ada pilihan baru keluar dari kamar melalui jendela
        Adegan  adeganLuarJendela = new AdeganDiLuarJendela();
        Zombie zombie = new Zombie();
        adeganLuarJendela.narasi = "Rudi pelan-pelan membuka jendela dan keluar dari kamar. Rudi sekarang berada di luar bangunan " +
                "yang sangat luas\n" +
                "Tiba - tiba ada sesosok manusia nampak seperti zombie yang akan menyerang Rudi !!!\n" +
                "Kesehatan Zombie: " + zombie.getKesehatan() + "\n";
        adeganLuarJendela.idBarangBisaDigunakan = "senjata";
        Pilihan pilihanMenujuLuarJendela = new PilihanGantiAdegan(adeganLuarJendela, "menuju luar jendela");
        tambahPilihan(pilihanMenujuLuarJendela);
    }
}
