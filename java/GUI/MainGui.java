package GUI;

import Main.Main;
import Utils.Coordinates;
import javafx.scene.layout.BorderPane;
import blocchi.*;
import javafx.scene.layout.StackPane;
import utente.Furnace;
import utente.MainView;


public class MainGui extends BorderPane {
    static MapPane mp = new MapPane();
    ButtonListPane blp = new ButtonListPane();
    InventoryPane inventoryPane = new InventoryPane();
    public MainGui(){

        this.setCenter(mp);
        this.setLeft(blp);

        BlockFactory bf = new BlockFactory();
        FurnacePane fp = new FurnacePane(new BlockPane((AbstractBlock) bf.randomBlock()),new BlockPane((AbstractBlock) bf.randomBlock()));
        this.setRight(fp);


        StackPane root = new StackPane();
        Block[] bl = new Block[5];
        for (int i=0; i<5; i++){
            bl[i]=bf.randomBlock();
        }

        inventoryPane.addBlocks(bl);
        root.getChildren().add(inventoryPane);


    }
}
