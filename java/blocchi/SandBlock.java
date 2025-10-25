package blocchi;


import static javafx.scene.paint.Color.SANDYBROWN;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock()  {
        super();
        this.valore='S';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.pickable =true;
        this.torchable=true;
        this.blockname = "Sand";
        this.colore= SANDYBROWN;
    }

    public Block smelt(){
        return new GlassBlock();
    }

}


