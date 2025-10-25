package blocchi;

import static javafx.scene.paint.Color.SILVER;

public class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterface{
    public IronSwordBlock()  {
        super();
        this.valore='/';
        this.blockname = "IronSword";
        this.colore= SILVER;
    }
}
