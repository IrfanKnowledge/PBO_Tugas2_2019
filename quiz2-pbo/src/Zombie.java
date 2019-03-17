public class Zombie{
    private int kesehatan = 100;
    private int kekuatan = 10;

    public void kurangiKesehatan(int serangan){
        kesehatan -= serangan;
        if(kesehatan < 0){
            kesehatan = 0;
        }
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public int getKekuatan() {
        return kekuatan;
    }

    public void printKesehatan(){
        System.out.println("Kesehatan Zombie: " + kesehatan);
    }

}
