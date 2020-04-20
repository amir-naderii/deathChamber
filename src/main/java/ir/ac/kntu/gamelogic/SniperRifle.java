package ir.ac.kntu.gamelogic;

public class SniperRifle extends Guns{
    private boolean zoom;


    public SniperRifle() {
        super(20,60);
    }

    public boolean isZoom() {
        return zoom;
    }

    public void setZoom(boolean zoom) {
        this.zoom = zoom;
        if(zoom)
            this.range += 5 + RandomHelper.nextInt(10);
    }


}
