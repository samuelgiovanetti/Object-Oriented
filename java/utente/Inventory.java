package utente;
import Utils.AlphabeticalBlockComparator;
import Utils.BlockComparator;
import blocchi.*;

public class Inventory {
    public Inventory() {
        init_inventory();
        //Utils.Comparator<Block> compAlpha = new AlphabeticalBlockComparator((AbstractBlock) ArrayList[0], (AbstractBlock) ArrayList[1]);
        //Utils.Comparator<Block> compComp = new BlockComparator((AbstractBlock) ArrayList[0], (AbstractBlock) ArrayList[1]);
    }

    public Block[] ArrayList = new Block[32];

    public Block get_inventory_not_null_block(){
        for (int i = 0; i < 32; i++) {
            if (!(ArrayList[i] instanceof NullBlock)) {
                return ArrayList[i];
            }
        }
        return new NullBlock();
    }

    private void init_inventory() {
        BlockFactory bf = new BlockFactory();
        for (int i = 0; i < 32; i++) {
            ArrayList[i] = bf.nullBlock();
        }
    }

    void display_in_inventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < 32; i++) {
            if (!(ArrayList[i] instanceof NullBlock)) {
                System.out.println(i + " " + ArrayList[i] + " ");
            }
        }
    }

    public void add_block(Block b) {
        for (int i = 0; i < 32; i++) {
            if ((ArrayList[i] instanceof NullBlock)) {
                ArrayList[i] = b;
                break;
            }
        }
    }

    private Boolean is_smeltable(int col) throws BlockErrorException {
        if (ArrayList[col]instanceof SmeltableBlock){
            return true;
        }else {
            throw new BlockErrorException("The block is not Smeltable");
        }
    }

    private SmeltableBlock get_smeltable_item(int index) {
        return (SmeltableBlock) ArrayList[index];
    }

    public void move_to_inventory(Block b) {
        add_block(b);
        order_inventory(comp_type);
    }

    public static AbstractBlock min = null;
    public static AbstractBlock max = null;

    Boolean comp_type = true; //se ture vuole dire che il comparetor utilizzato è alfanumerico, se false, è numerico

    private void order_inventory(Boolean comp_type) {
        for (int j = 0; j < 31; j++) {
            for (int i = 0; i < 31; i++) {
                if (!(ArrayList[i] instanceof NullBlock) && !(ArrayList[i + 1] instanceof NullBlock)) {
                    if (comp_type) {
                        new AlphabeticalBlockComparator((AbstractBlock) ArrayList[i], (AbstractBlock) ArrayList[i + 1]);
                    } else {
                        new BlockComparator((AbstractBlock) ArrayList[i], (AbstractBlock) ArrayList[i + 1], ArrayList);
                    }
                    ArrayList[i] = min;
                    ArrayList[i + 1] = max;
                }
            }
        }
    }

    void change_comparetor(){
        comp_type= !comp_type;
    }
}


