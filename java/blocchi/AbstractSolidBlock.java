package blocchi;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock(){
        this.falls_with_gravity=true;
        this.fall_through=false;
        this.pickable=true;
        this.torchable=false;
    }

}
