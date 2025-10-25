package blocchi;

import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.WHITE;

public class WaterBlock extends AbstractBlock {
    public WaterBlock() {
        this.valore='W';
        this.falls_with_gravity=true;
        this.fall_through=true;
        this.pickable=false;
        this.blockname = "water";
        this.colore= BLUE;
    }

}


