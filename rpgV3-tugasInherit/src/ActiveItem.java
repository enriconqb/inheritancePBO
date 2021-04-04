public class ActiveItem extends Item {
    //Var Grup
    private double attackPower;
    private double penetrationPower;

    //Setter n Getter
    public double getAttackPower() {
        return this.attackPower;
    }
    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }
    public double getpenetrationPower() {
        return this.penetrationPower;
    }
    public void setpenetrationPower(double penetrationPower) {
        this.penetrationPower = penetrationPower;
    }

    //Constructor
    public ActiveItem(String nama, double attack, double penetration) {
        super(nama);
        this.attackPower = attack;
        this.penetrationPower = penetration;
    }

}
