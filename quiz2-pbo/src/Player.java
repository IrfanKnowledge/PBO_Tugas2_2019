/*
    Menyimpan informasi tentang player seperti
    - barang yang dibawa
    - kesehatan

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    int kesehatan = 100;
    String nama = "Rudi";
    boolean isSelesai = false;
    Adegan adeganAktif; //adegan tempat player berada

    /* barang yang dimiliki player*/
    //Barang[] arrBarang = new Barang[10];
    //int jumBarang  = 0;

    ArrayList<Barang> arrBarang = new ArrayList<>();


    //jika dipanggil akan lengkapi dengan nim, nama dan tulisan saya berjanji tdk akan dst..
    public void printIdentitas() {
        System.out.println("Identitas");
        //lengkapi ...
        System.out.printf("%-7s     %-30s\n", "NIM", "Nama");
        System.out.printf("%-7s     %-30s\n", "1603719", "Irfan Muhammad Faisal");
        System.out.printf("%-10s\n", "Perjanjian");
        System.out.println("Saya bernjanji tidak berlaku curang " +
                "dan/atau membantu orang lain berbuat curang");
    }


    public void tambahBarang(Barang oBarang) {
       // arrBarang[jumBarang] = oBarang;
       // jumBarang++;
        arrBarang.add(oBarang);
    }

    /*
        cetak isi barang yang dimiliki player
        return adalah objek barang yang dipilih user untuk digunakan
        jika user tidak jadi memilih maka akan return null
        hati-hati dapat menyebabkan NullPointer exception jadi selalu cek return
     */

    public Barang pilihBarang() {
        System.out.println("Barang yang berada di dalam kantong");
        /*
            for (int i=0;i<jumBarang;i++) {
                System.out.println(String.format("%d. %s",i+1,arrBarang[i].deskripsi));
            }
        */

        int i = 0;
        for(Barang brg : arrBarang){
            System.out.println(String.format("%d. %s",i+1,brg.deskripsi));
            i++;
        }

        System.out.println(String.format("%d. %s", i+1 ,"Hanya lihat, tidak menggunakan barang"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Pilihan anda?");
        int pilihan = sc.nextInt();
        if (pilihan >0 && pilihan <= arrBarang.size())
            return(arrBarang.get(pilihan-1));
        else
            return null;
    }

    public static void main(String[] args) {
        //untuk test
        Barang permen = new Barang("p_kopiko","Permen Kopiko");
        Barang bolpen = new Barang("bolpen","Bolpen");
        Player p = new Player();
        p.tambahBarang(permen);
        p.tambahBarang(bolpen);
        Barang barangPilih = p.pilihBarang(); //
        if (barangPilih!=null) {
            System.out.println(barangPilih.deskripsi);
        }
    }

    public void kurangiKesehatanKarenaCapek(){
        this.kesehatan -= 2;
        if(this.kesehatan < 0){
            this.kesehatan = 0;
        }
    }

    public void tambahKesehatan(Barang makanan){
        this.kesehatan += 50;

        //menghapus barang tersebut
        Adegan.oPlayer.arrBarang.remove(makanan);

        System.out.println("Kesehatan Bertambah 50!");
        if(this.kesehatan>100){
            this.kesehatan = 100;
        }
    }

    public void kurangiKesehatanDiserangMusuh(int kekuatanLawan){
        this.kesehatan -= kekuatanLawan;

        if(this.kesehatan <0){
            this.kesehatan = 0;
        }
    }

    public void printKesehatan(){
        System.out.println("Kesehatan Pemain: " + kesehatan);
    }

}
