import java.util.ArrayList;

public class Karakter {
    //Deklar var (default)
    private String name;
    private double health = 100;
    private double attack = 10;
    private Item objItem;
    private ArrayList<Item> arrItem = new ArrayList<>(); 


    //Setter n Getter
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return this.attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public Item getObjItem() {
        return this.objItem;
    }

    public void setObjItem(Item objItem) {
        this.objItem = objItem;
    }

    public ArrayList<Item> getArrItem() {
        return this.arrItem;
    }

    public void setArrItem(ArrayList<Item> arrItem) {
        this.arrItem = arrItem;
    }

    //Contruct
    public Karakter(String name){
        this.name = name;
    }


    //Method
    //Karakter Menyerang
    public void attack(Karakter target){
        double hpTarget = target.health;
        double attackPower = this.attack;
        double total = hpTarget-attackPower;
        target.health = total;
        System.out.println(this.name+" menyerang "+target.name+" memberikan "+this.attack+" damage");
    }

}
