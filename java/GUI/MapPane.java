package GUI;

import Utils.Coordinates;
import blocchi.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class MapPane extends GridPane {
    private final int map_row;
    private final int map_col;

    private BlockFactory bf = new BlockFactory();
    public MapPane(){
        super();
        this.map_row= Coordinates.map_row;
        this.map_col= Coordinates.map_col;

        initialise_air();
    }
    static GridPane gp= new GridPane();

    void initialise_air(){
        for (int i = 0; i < map_row; i++) {
            for (int j = 0; j < map_col; j++) {
                AirBlock ai = bf.airBlock();
                BlockPane bp = new BlockPane(ai);
                add(bp, i, j);
            }
        }
    }
    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    BlockPane get_block_at_coord(Coordinates c){
        return (BlockPane) getElementAt(gp,c.row, c.col);
    }

     void  setCell(Coordinates c, Block b){
        BlockPane bp = get_block_at_coord(c);
        if (bp == null){
            bp = new BlockPane((AbstractBlock) b);
            add(bp, c.col, c.row);
        }else{
            add(bp, c.col, c.row);
        }
    }
}
