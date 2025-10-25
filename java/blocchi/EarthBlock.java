package blocchi;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.WHITE;

public class EarthBlock extends AbstractSolidBlock{
    public EarthBlock(){
        this.falls_with_gravity=false;
        this.fall_through=false;
        this.pickable=true;
        this.torchable=false;
        this.valore = 'E';
        this.blockname = "Earth";
        this.colore= GREEN;
    }
}
