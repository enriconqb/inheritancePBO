import java.util.ArrayList;
import java.util.Scanner;

// import static java.lang.String.format;

public class Player extends Karakter{
    //Item default (attribute terisi)
    private Item objCincin = new Item("Cincin Emas");
    private ArrayList<Item> arrItem;
    //--CHANGE----------------------------
    // private String nama = "budiwati";
    // private int kesehatan = 100;
    // Tidak diperlukan karena sudah pindahkan ke GameEngine
    //------------------------------------

    //Object grup
    private Ruangan ruanganAktif;  //ruangan tempat player saat ini berada
    private GameInfo objGameInfo;
    private Scanner sc = new Scanner(System.in);

    //Contruct
    public Player(String name) {
        super(name); //--add----
        arrItem = new ArrayList<>();
        objCincin.setDeskripsi("Cincin emas bertuliskan suatu kalimat..");
        arrItem.add(objCincin);
    }

    //Setter n Getter
    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objCincin.setObjGameInfo(objGameInfo);
    }
    public void setRuanganAktif(Ruangan ruanganAktif) {
        this.ruanganAktif = ruanganAktif;
    }
    public Ruangan getRuanganAktif() {
        return ruanganAktif;
    }

    //=========== Method ==============
    //Tambah item ke inventory player
    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    //cari item yang dimiliki oleh player, return TRUE jika ada
    //salah satu yg menggunakan: pintu untuk mengecek apakah player sudah punya kunci
    public boolean cariItem(String namaItem) {
        for (Item objItem:arrItem) {
             if (namaItem.equals(objItem.getNama())) {
                 return (true);
            }
        }
        return(false); //tidak ketemu
    }

    //info Player
    public void printPlayer() {
        System.out.println("Nama Player     : "+this.getName());
        System.out.println("Kesehatan Player: "+this.getHealth());
    }

    //Info Item
    public void printItem() {
        System.out.println("Item milik player");
        int cc = 0;
        for (Item objItem:arrItem) {
            cc++;
            System.out.printf("%d. %s%n",cc,objItem.getNama());
            System.out.println(objItem.getDeskripsi());
        }
    }

    //Player buang item dari inventory
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);
    }

    //Opsi Player
    public void pilihanAksi() {
        System.out.println("**** Pilihan Aksi pada Player *** ");
        //disamakan dengan  ruangan
        //bisa direfactoring nanti supaya tdk duplikasi

        //Aksi sesuai Item pada player
            //Deklar var
        int urutPil = 0;  //item
        int subPil;   //aksinya
        //Main Progran
        System.out.println("Item yang dimiliki player");
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }

        //Info Player
            //Deklar Var
        urutPil++;
        subPil = 0;
        int pilInfoPlayer  = urutPil; //catat untuk pintu
        //Main Program
        System.out.println("Info Player");
        //hanya satu
        subPil++;
        System.out.printf("%d%d. info player%n", urutPil, subPil);
        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        if (pil == pilInfoPlayer) {
            printPlayer();
        } else {
            Item objItemPilih = arrItem.get(pil-1);
            //Bila yang dibuang adalah ramuan maka dianggap menggunakan ramuan
            if(objItemPilih.getNama().equals("Ramuan HP")){
                double total = this.getHealth() + 50;
                this.setHealth(total);
            }
            objItemPilih.prosesAksi(subPil); //aksi item
        }
//        System.out.println("2. Item milik player");
//        System.out.print("Pilihan anda?");
//        int pil = sc.nextInt();
//        System.out.println("--");
//        if (pil==1) {
//            printPlayer();
//        } else if (pil==2) {
//            printItem();
//        }
    }


}
