package blocchi;

import static javafx.scene.paint.Color.*;

public class AirBlock extends AbstractBlock {
    public AirBlock  () {
        this.valore='*';
        this.falls_with_gravity=false;
        this.fall_through=true;
        this.pickable=false;
        this.torchable=false;
        this.blockname = "Air";
        this.colore= LIGHTSKYBLUE;
    }

}


