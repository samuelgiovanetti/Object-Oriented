package blocchi;

import javafx.scene.paint.Color;

public interface Block extends InventoryBlock {

    char Display();
    boolean getFalls_with_gravity();
    boolean getFall_through();
    boolean torchable();

}