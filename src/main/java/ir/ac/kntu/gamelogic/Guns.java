package ir.ac.kntu.gamelogic;

public class Guns{
    protected boolean calibre7;
    protected int damage;
    protected int range;

    public Guns(int damage, int range) {
        this.damage = damage;
        this.range = range;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public boolean isCalibre7() {
        return calibre7;
    }

    public void setCalibre7(boolean calibre7) {
        this.calibre7 = calibre7;
    }


}
