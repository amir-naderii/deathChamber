package ir.ac.kntu.gamelogic;

public class Soldiers{
    protected String id;
    protected int lives;
    protected boolean isRed;
    protected Guns gun;

    public Soldiers(String  id, int lives, boolean isRed) {
        this.id = id;
        this.lives = lives;
        this.isRed = isRed;
    }


    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Guns getGun() {
        return gun;
    }

    public void setGun(Guns gun) {
        this.gun = gun;
    }

    public static void soldierSetting(int numberOfSoldiers){
        for(int i=0 ; i<numberOfSoldiers ; i++){

            Soldiers redSoldier = new Soldiers("R" + (i + 1),30,true );
            Soldiers blueSoldier = new Soldiers("B" + (i+1),30,false);
            TheGame.redSoldiers.add(redSoldier);
            TheGame.blueSoldiers.add(blueSoldier);
            if(RandomHelper.nextBoolean()){
                AssaultRifle gun = new AssaultRifle();
                TheGame.redSoldiers.get(i).setGun(gun);
            }
            else{
                SniperRifle gun = new SniperRifle();
                TheGame.redSoldiers.get(i).setGun(gun);
            }
            if(RandomHelper.nextBoolean()){
                AssaultRifle gun = new AssaultRifle();
                TheGame.blueSoldiers.get(i).setGun(gun);
            }
            else{
                SniperRifle gun = new SniperRifle();
                TheGame.blueSoldiers.get(i).setGun(gun);
            }
        }
    }
}
