package blocchi;

import static javafx.scene.paint.Color.TRANSPARENT;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {

    public NullBlock()  {
        super();
        this.valore='N';
        this.blockname = "Null";
        this.pickable=false;
        this.colore= TRANSPARENT;
    }
    public NullBlock smelt(){
        return new NullBlock();
    }
}

