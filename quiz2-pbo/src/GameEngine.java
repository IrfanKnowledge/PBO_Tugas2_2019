/*
    inisialisasi adegan dsb, jalankan adegan sampai permainan selesai.

 */

public class GameEngine {
    Player oPlayer;

    public GameEngine() {
        Barang koin = new Barang("koin","uang koin");
        oPlayer = new Player();
        oPlayer.tambahBarang(koin);  //dummy saja
        //perhatikan Adegan  disini adalah class, oPlayer adalah static atribut sehingga berlaku untuk semua objek
        //artinya semua objek adegan punya objek player yang sama
        Adegan.oPlayer = oPlayer;
    }

    public void mulai() {
        oPlayer.printIdentitas();
        do {
            oPlayer.adeganAktif.mainkan();
        } while (!oPlayer.isSelesai && oPlayer.kesehatan > 0);

        System.out.println(String.format("Kesehatan: %d\nPermainan Selesai!", Adegan.oPlayer.kesehatan));
    }

    public static void main(String[] args) {

        //create objek kunci
        Barang kunci = new Barang("kunci_besar","Kunci Besar");


        //create objek semua adegan di dalam ruangan pertama
        Adegan adeganPintu = new AdeganPintu();
        Adegan adeganMeja  = new Adegan();
        Adegan adeganJendela = new AdeganJendela();

        //create objek daftar pilihan yang tersedia di dalam ruangan pertama
        Pilihan pilihanMenujuPintu = new PilihanGantiAdegan(adeganPintu,"Menuju pintu");
        Pilihan pilihanMenujuMeja  = new PilihanGantiAdegan(adeganMeja,"Menuju meja");
        Pilihan pilihanMenujuJendela = new PilihanGantiAdegan(adeganJendela, "Menuju jendela");


        //init data cerita
        // == adegan awal
        Adegan  adeganAwal = new Adegan();
        //narasi pertama kali saat memulai permainan
        adeganAwal.narasi =
                "Rudi terbangun disebuah ruangan yang tidak dikenal. Dia melihat sekeliling, \n" +
                "terlihat jendela, pintu dan sebuah meja kecil";
        //daftar pilihan saat pertama kali bermain
        adeganAwal.tambahPilihan(pilihanMenujuPintu);
        adeganAwal.tambahPilihan(pilihanMenujuMeja);
        adeganAwal.tambahPilihan(pilihanMenujuJendela);


        // == adegan di depan pintu
        adeganPintu.idBarangBisaDigunakan = "kunci_besar"; //kunci_besar bisa digunakan di adegan ini
        //daftar barang yang bisa diambil saat di depan pintu
        adeganPintu.tambahBarang(new Barang("obeng", "obeng berukuran sedang"));
        //daftar pilihan saat berada di depan pintu
        adeganPintu.tambahPilihan(pilihanMenujuMeja); //pilihan ke meja direuse
        adeganPintu.tambahPilihan(pilihanMenujuJendela); //pilihan ke jendela direuse

        // == adegan di depan meja
        //narasi saat berada di depan meja
        adeganMeja.narasi = "Rudi mendekati meja. Ada beberapa barang di atas meja";
        //daftar barang yang bisa diambil saat di depan meja
        adeganMeja.tambahBarang(new Barang("kunci_besar", "Kunci berukuran besar"));
        adeganMeja.tambahBarang(new Barang("senter", "Senter kecil"));
        adeganMeja.tambahBarang(new Barang("makanan", "coklat"));
        adeganMeja.tambahBarang(new BarangSenjata("senjata", "Pistol", 25)); //untuk melawan zombie
        //daftar pilihan saat berada di depan meja
        adeganMeja.tambahPilihan(pilihanMenujuPintu); //dari meja bisa ke pintu
        adeganMeja.tambahPilihan(pilihanMenujuJendela); //dari meja bisa ke jendela;


        // == adegan di depan jendela
        adeganJendela.idBarangBisaDigunakan = "obeng"; // membuka jendela menggunakan obeng
        //daftar pilihan saat berada di depan jendela
        adeganJendela.tambahPilihan(pilihanMenujuMeja);
        adeganJendela.tambahPilihan(pilihanMenujuPintu);

        //== init game engine
        GameEngine ge = new GameEngine();
        //ge.tambahAdegan(adeganMeja);
        ge.oPlayer.adeganAktif = adeganAwal; //start dari adegan awal
        ge.mulai();
    }
}
