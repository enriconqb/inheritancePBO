import java.util.ArrayList;

public class Enemy extends Karakter{
    //Constructor
    public Enemy(String name){
        super(name);
    }

    //================ Method ================
    //Opsi Enemy
    public ArrayList<String> getAksi() {
        ArrayList<String> arrOut = new ArrayList<>();
        arrOut.add("Status Monster");
        arrOut.add("Serang Monster");
        return(arrOut);
        
    }

    //Opsi Proses Aksi
    public void prosesAksi(int subPil, Player objPlayer){
        //Menampilkan Status monster
        if (subPil==1){
            System.out.println(""+
            "Monster\n"+
            "HP   : "+this.getHealth());
        } 
        //Menyerang monster
        else if(subPil == 2){
            if(this.enemyDie()){ //identifikasi darah monster bila sudah dikalahkan
                System.out.println("Monster Telah dikalahkan!");
            }
            else{
                if(objPlayer.cariItem("Pedang")){
                    objPlayer.setAttack(50);
                }
                else{
                    objPlayer.setAttack(30);
                }
                objPlayer.attack(this);
                this.attack(objPlayer);
                if(this.enemyDie()){
                    System.out.println("Monster Telah dikalahkan!");
                }
            }
        }
    }

    //Check Nyawa Monster
    public boolean enemyDie(){
        boolean value = false;
        if(this.getHealth()<=0){
            value=true;
        }
        return value;
    }
}
