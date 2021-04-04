import java.util.ArrayList;
import java.util.Scanner;

// import static java.lang.String.format;

public class Ruangan {

    private Pintu objPintu;
    private NPC objNPC;
    private ArrayList<Item> arrItem = new ArrayList<>();
    private String deskripsi;
    private GameInfo objGameInfo;
    private Scanner sc = new Scanner(System.in);
    private Item  objRoti;
    // --Add-------------------------------------
    private Enemy objEnemy; 
    private ActiveItem pedang;
    private BuffItem hpPotion;
    // =========================================
    
    //Contruct
    public Ruangan() {
        // init ruangan
        // init pintu, kunci dan roti.
        objPintu = new Pintu(); //Menyelesaikan Ruangan
        objNPC = new NPC();     //Memegang kunci
        objRoti= new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);
        //tambah item ke array
        arrItem.add(objRoti);

        // --ADD-------------------------------------
        //init monster, pedang, ramuan
        objEnemy = new Enemy("Monster");

        pedang = new ActiveItem("Pedang", 30, 0);
        pedang.setDeskripsi("Senjata tajam yang dipegang dengan kedua tangan");
        pedang.setObjRuangan(this);
        arrItem.add(pedang);

        hpPotion = new BuffItem("Ramuan HP", 50, 0);
        hpPotion.setDeskripsi("Ramuan penambah darah");
        hpPotion.setObjRuangan(this);
        arrItem.add(hpPotion);
        // =========================================

    }

    //Setter n Getter
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Enemy getObjEnemy(){
        return objEnemy;
    }

    //=========== Method ==============
    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi

    //Opsi di Ruangan
    public void pilihanAksi() {
        //Deklar var
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        //========= Aksi item (Player/Ruangan) ============
        System.out.println("Item di ruangan");
        
        for (Item objItem:arrItem) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());

            //Ambil Pilihan (berdasarkan letak Item)(generic)
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }


        //========= Aksi PINTU =========
        //belum menggunakan inheritance, jadi masih perlu penanganan terpisah untuk item spesifik seperti pintu
        urutPil++;
        subPil = 0;
        int pilPintu  = urutPil; //catat untuk pintu
        System.out.println("Pintu");
        for (String strPil:objPintu.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }
        
        //========= Aksi NPC =========
        urutPil++;
        subPil = 0;
        int pilNPC  = urutPil; //catat untuk pintu
        System.out.println("NPC");
        for (String strPil:objNPC.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }
        // --ADD-------------------------------------
        //========= Lawan Monster =========
        urutPil++;
        subPil = 0;
        int pilMons  = urutPil; //catat untuk pintu
        System.out.println("Monster");
        for (String strPil:objEnemy.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }
        //============================================
        System.out.print("Pilihan anda? ");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        //tdk perlu if spt ini kalau sudah menggunakan inheritance
        if (pil==pilPintu) {
            objPintu.prosesAksi(subPil);  //aksi pintu
        } else if (pil==pilNPC) {
            objNPC.prosesAksi(subPil);
        } else if (pil==pilMons){
            objEnemy.prosesAksi(subPil,objGameInfo.getObjPlayer());
        }else {
            //item
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }
    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);   //add item
    }

    

}
