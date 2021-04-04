public class GameInfo {
    private Boolean isGameOver = false;
    private Player objPlayer;
    private Ruangan objRuangan; //ruangan aktif
    private BuffItem objBuffItem;
    private Enemy objEnemy;

    //Setter n Getter


    public Enemy getObjEnemy() {
        return this.objEnemy;
    }

    public void setObjEnemy(Enemy objEnemy) {
        this.objEnemy = objEnemy;
    }

    public Boolean isIsGameOver() {
        return this.isGameOver;
    }

    public Boolean getIsGameOver() {
        return this.isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public BuffItem getObjBuffItem() {
        return this.objBuffItem;
    }

    public void setObjBuffItem(BuffItem objBuffItem) {
        this.objBuffItem = objBuffItem;
    }


    public Ruangan getObjRuangan() {
        return objRuangan;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

    public Player getObjPlayer() {
        return objPlayer;
    }

    public void setObjPlayer(Player objPlayer) {
        this.objPlayer = objPlayer;
    }

    public Boolean getGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }
}
