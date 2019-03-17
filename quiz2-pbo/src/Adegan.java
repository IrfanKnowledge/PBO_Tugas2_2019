import java.util.ArrayList;
import java.util.Scanner;

public class Adegan {

    //static, satu objek player yang sama untuk semua objek adegan
    public static Player oPlayer;

    //pilihan yang ada di semua adegan
    PilihanGunakanKantong oPilihanGunakanKantong;  //lihat barang milik player dan gunakan
    PilihanLihatBarang oPilihanLihatBarang;        //lihat barang di dalam adegan dan pindahkan ke kantong player

    //barang yg valid digunakan dalam adegan ini (misal kunci dalam adegan pintu)
    String idBarangBisaDigunakan;

    //khusus untuk makanan dalam setiap adegan
    String idBarangMakanan = "makanan";


    String narasi;
    //idealnya menggunakan ArrayList
    //pilihan yang bisa dipilih user untuk setiap adegan
    //int jumPil = 0;
    //Pilihan[] arrPilihan = new Pilihan[50];

    ArrayList<Pilihan> arrPilihan = new ArrayList<>();


    //constructor
    public Adegan() {
        //setiap adegan memiliki 2 pilihan yg sama yaitu untuk melihat barang milik player dan melihat barang dalam adegan tsb.
        oPilihanGunakanKantong = new PilihanGunakanKantong(this,"Lihat dan gunakan barang yang dimiliki player");
        tambahPilihan(oPilihanGunakanKantong);

        oPilihanLihatBarang = new PilihanLihatBarang(this,"Lihat barang di sekitar...");
        tambahPilihan(oPilihanLihatBarang);

    }

    //tambah barang yg berada di adegan
    public void tambahBarang(Barang vBarang) {
        oPilihanLihatBarang.tambahBarang(vBarang);
    }


    /*
       tambah pilihan
     */
    public void tambahPilihan(Pilihan oPilihan) {
        /*
            arrPilihan[jumPil] = oPilihan;
            jumPil++;
        */

        arrPilihan.add(oPilihan);
    }


    public void mainkan() {
        //print narasi dan pilihan
        System.out.println(""); //spasi

        //memperlihatkan kesehatan
        this.oPlayer.printKesehatan();

        System.out.println(narasi);

        //print pilihan array biasa
        /*
            for (int i = 0; i < jumPil; i++) {
                System.out.print(String.format("%d. %s \n", i + 1, arrPilihan.get(i).deskripsi));
            }
        */

        //print pilihan ArrayList
        int i = 0;
        for(Pilihan print : arrPilihan){
            System.out.print(String.format("%d. %s \n", i + 1, print.deskripsi));
            i++;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Pilihan anda:");
        int pilihan = sc.nextInt();
        System.out.println(""); //spasi

        if(pilihan < 1 || pilihan > arrPilihan.size()){
            System.out.println("Maaf, pilihan tidak tersedia.");
        }else{
            //eksekusi pilihan yang dipilih user
            arrPilihan.get(pilihan-1).aksi();
        }
    }

    //User memilih barang yang dimiliki player. lihat class PilihanGunakanKantong
    public void gunakanBarang(Barang barangPilih) {
          System.out.println(String.format("Rudi mengambil %s dan menggunakannya...",barangPilih.deskripsi));
    }
}
