package blocchi;

import javafx.scene.paint.Color;

public abstract class AbstractBlock implements Block {

    public String blockname;

    public char valore;
    public boolean falls_with_gravity;
    public boolean fall_through;
    public boolean pickable;
    public boolean torchable;

    public Color colore;

    public char Display() {
        return valore;
    }

    public boolean getFalls_with_gravity() {
        return falls_with_gravity;
    }

    public boolean getFall_through() {
        return fall_through;
    }

    public String toString() {
        return this.blockname + " [" + this.valore + "]";
    }

    public void display_in_inventory(){
        System.out.print('['+valore+']');
    }

    public boolean pickable(){
        return pickable;
    }

    public boolean torchable(){
        return torchable;
    }
}

