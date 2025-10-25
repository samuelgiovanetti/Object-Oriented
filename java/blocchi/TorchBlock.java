package blocchi;

import static javafx.scene.paint.Color.LIGHTYELLOW;
import static javafx.scene.paint.Color.WHITE;

public class TorchBlock extends AbstractSolidBlock{
    public TorchBlock() {
        super();
        this.valore='T';
        this.blockname = "Torch";
        this.colore= LIGHTYELLOW;
    }

}
