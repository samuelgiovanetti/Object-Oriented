package blocchi;

import static javafx.scene.paint.Color.DARKGREY;
import static javafx.scene.paint.Color.WHITE;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{
    public RawIronBlock()  {
        super();
        this.valore='I';
        this.blockname = "RawIron";
        this.colore= DARKGREY;
    }

    public Block smelt() {
        return new IronSwordBlock();
    }
}
