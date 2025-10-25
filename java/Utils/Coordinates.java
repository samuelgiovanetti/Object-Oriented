package Utils;

import utente.BlockErrorException;

public class Coordinates {
    public static int map_row; //come faccio a renderlo final dopo la prima assegnazione ?
    public static int map_col;

    public int row;
    public int col;

    public Coordinates(int r, int c){
        this.row = r;
        this.col = c;
    }
}
