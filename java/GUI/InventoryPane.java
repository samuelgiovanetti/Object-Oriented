package GUI;

import blocchi.AbstractBlock;
import blocchi.Block;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InventoryPane extends HBox {
    private Text inventory_text;
    private HBox inventory_hbox;

    public InventoryPane(){
        inventory_text = new Text("Inventory:");
        inventory_hbox = new HBox();

        inventory_text.setTextAlignment(TextAlignment.JUSTIFY);
        setAlignment(Pos.CENTER);
        getChildren().addAll(inventory_text,inventory_hbox);
    }

    public void addBlocks(Block[] blocks) {
        for (int i = 0; i<blocks.length; i++) {
            getChildren().add(new BlockPane((AbstractBlock) blocks[i]));
        }
    }
}
