public class AdeganDiLuarJendela extends Adegan {
    private Zombie oZombie = new Zombie();

    /*aksi menyerang zombie dengan idBarang tertentu yang bisa digunakan untuk menyerang zombie */
    @Override
    public void gunakanBarang(Barang barangPilih) {
        super.gunakanBarang(barangPilih); //panggil parent

        //aksi mengurangi kesehtan zombie dengan mengambil nilai kekuatan pada senjata tersebut
        // menggunakan TEKNIK POLYMORPHISM
        oZombie.kurangiKesehatan(barangPilih.getKekuatan());
        oZombie.printKesehatan();

        //aksi mengurangi kesehatan player dengan mengambil nilai kekuatan pada zombie yang menyerang player
        System.out.println(String.format("Zombie menyerang %s dengan gigitannya!" , Adegan.oPlayer.nama));
        Adegan.oPlayer.kurangiKesehatanDiserangMusuh(oZombie.getKekuatan());

        if(oZombie.getKesehatan() < 1){
            Adegan.oPlayer.isSelesai = true;
        }
    }
}
