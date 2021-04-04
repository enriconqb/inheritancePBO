public class BuffItem extends Item{
    //Var Grup
    private double addHP;
    private double addMana;

    //Setter n Getter
    public double getAddHP() {
        return this.addHP;
    }
    public void setAddHP(double addHP) {
        this.addHP = addHP;
    }
    public double getAddMana() {
        return this.addMana;
    }
    public void setAddMana(double addMana) {
        this.addMana = addMana;
    }
    
    //Constructor
    public BuffItem(String nama, double hp, double mana){
        super(nama);
        this.addHP = hp;
        this.addMana = mana;
    }

}
