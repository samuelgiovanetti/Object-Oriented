package Utils;
import blocchi.*;
import utente.Inventory;

public class AlphabeticalBlockComparator implements Comparator<Block> {

    public  AlphabeticalBlockComparator(AbstractBlock a, AbstractBlock b) {

        if (a.valore > b.valore) {
            Inventory.max = a;
            Inventory.min = b;
        } else {
            Inventory.max = b;
            Inventory.min = a;
        }
    }
}
