package Utils;

import blocchi.AbstractBlock;
import blocchi.Block;
import utente.Inventory;

public class BlockComparator implements Comparator<Block>{

    // il numero assegnato ad ogni blocco è rappresentato dalla posizione del blocco all'intenro dell'Inventory
    public BlockComparator(AbstractBlock a, AbstractBlock b, Block[] ArrayList){
        for (int i=0; i<31; i++){
            for (int j=0; j<31; j++) {
                if ((ArrayList[i] == a)&&(ArrayList[j] == b)){
                    if (i>j){
                        Inventory.max = a;
                        Inventory.min = b;
                    }else{
                        Inventory.max = b;
                        Inventory.min = a;
                    }
                }
            }
        }
    }
}
