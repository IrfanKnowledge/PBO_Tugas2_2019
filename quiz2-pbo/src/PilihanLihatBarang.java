/*
     Pilihan untuk melihat barang yg tersedia di dalam adegan (misal barang di atas meja)
     Aksi adalah memindahkan barang adegan ke dalam kantong.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PilihanLihatBarang extends Pilihan {

    //barang yg ada di adegan (misal kunci yg ada di atas meja)
    //Barang[] arrBarang = new Barang[5];
    //int jumBarang = 0;

    ArrayList<Barang> arrBarang = new ArrayList<>();

    public Adegan oAdegan;


    public PilihanLihatBarang(Adegan vAdegan, String narasi) {
        super(narasi);
        oAdegan = vAdegan;
    }

    @Override
    public void aksi() {

        //jika ada, tampilkan barang yang ada di dalam adegan
        if (arrBarang.size() > 0) {
            System.out.println("Barang yang bisa diambil:");

            //tampilkan barang
            /*
                for (int i = 0; i < jumBarang; i++) {
                    System.out.print(String.format("- %s \n", arrBarang[i].deskripsi));
                }
            */

            for(Barang print : arrBarang){
                System.out.print(String.format("- %s \n", print.deskripsi));
            }

            System.out.println("1. Ambil semua barang dan pindahkan ke kantong");
            System.out.println("2. Tidak mengambil apapun");
            Scanner sc = new Scanner(System.in);
            int pilihan = sc.nextInt();
            if (pilihan==1) {
                //ambil barang
                isiKantong();
            }
        } else {
            System.out.println("Tidak ada barang disekitar yang dapat diambil... ");
        }
    }

    /* private karena internal
      pindahkan semua barang di dalam adegan ke dalam kantong
      kosongkan arrBarang dgn cara reset posisi
    */
    private void isiKantong() {
        //pindahkan barang di adegan ke player
        /*
            for (int i = 0; i < jumBarang; i++) {
                oAdegan.oPlayer.tambahBarang(arrBarang[i]);
            }
        */

        for(Barang brg : arrBarang){
            oAdegan.oPlayer.tambahBarang(brg);
        }
        arrBarang.clear(); //reset barang menjadi kosong

        //jumBarang = 0; //reset posisi, barang kosong
        System.out.println("Barang telah diambil..");
    }

    /* tambah barang yg ada di adegan, misal di atas meja ada barang kunci, senter dsb yg bisa diambil user
       dan masuk ke kantongBarang
     */
    public void tambahBarang(Barang vBarang) {
        //arrBarang[jumBarang] = vBarang;
        //jumBarang++;

        arrBarang.add(vBarang);
    }


}
