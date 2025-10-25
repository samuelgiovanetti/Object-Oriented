package utente;
import Utils.Coordinates;
import blocchi.*;
import java.util.Scanner;
import java.util.Random;


public class Map {
    private Block[][] blocchi;

    Block getBlock(int x, int y){
        return blocchi[x][y];
    }

    void setBlock(int x, int y, Block b){
        blocchi[x][y]=b;
    }
    private BlockFactory bf = new BlockFactory();

    private Inventory myinventory;
    public Map(int row, int column, Inventory myinventory) {

        blocchi = new Block[row][column];

        this.myinventory = myinventory;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                blocchi[i][j] = bf.airBlock();
            }
        }

        Random rand = new Random();
        int RANDOM_BLOCKS_TO_ADD = 20;
        for(int i = 0; i < RANDOM_BLOCKS_TO_ADD; i++){
            Block b = bf.randomBlock();
            int riga = rand.nextInt(Coordinates.map_row);
            int colonna = rand.nextInt(Coordinates.map_col);
            blocchi[riga][colonna]=b;
            insert_rec(riga, colonna);
            // inserite b a row-col
        }

    }


    public void change_cell(Coordinates coo) {
        if (coo.row< Coordinates.map_row && coo.col< Coordinates.map_col) {
            Random rand = new Random();
            Scanner myObj = new Scanner(System.in);
            //char chara = (char) rand.nextInt(65,123);
            System.out.print("Enter block value: ");
            char c = myObj.next().charAt(0);
            if (c=='s'){
                blocchi[coo.row][coo.col]=bf.sand_block();
            }
            if (c=='w'){
                blocchi[coo.row][coo.col]=bf.sand_block();
            }
            insert_rec(coo.row, coo.col);

        }else{
            System.out.print("Error! The values are out of map" + '\n');
        }
    }

    public String display_on_out() {
        String result = "";
        for (int i = 0; i < Coordinates.map_row; i++) {
            result = result + '\n';
            for (int j = 0; j < Coordinates.map_col; j++) {
                result = result + blocchi[i][j].Display() + " ";
            }
        }
        System.out.println(result + '\n');
        return result;
    }

    protected Block[][] insert_rec(int row, int col) {
        if (blocchi[row][col].getFalls_with_gravity()) {
            if (row>=(Coordinates.map_row-1) || !blocchi[row + 1][col].getFall_through()){
                return blocchi;
            }else {
                if (blocchi[row + 1][col] instanceof TorchBlock) {
                    if (blocchi[row][col].torchable())
                        blocchi[row][col]=new AirBlock();
                }else {
                     swap(row, col);
                     return insert_rec(++row, col);
                }
            }
        }
        return blocchi;
    }
    private Block[][] swap(int a, int b) {
        Block temp = blocchi[a][b];
        blocchi[a][b] = blocchi[a + 1][b];
        blocchi[a + 1][b] = temp;
        return blocchi;
    }

    protected void order_map(){
        for (int k=0; k < (Coordinates.map_row-1); k++) {
            for (int i = 0; i < (Coordinates.map_row - 1); i++) {
                for (int j = 0; j < (Coordinates.map_col - 1); j++) {
                    if (blocchi[i][j].getFalls_with_gravity() && blocchi[i + 1][j].getFall_through()) {
                        swap(i, j);
                    }
                }
            }
        }
    }

    private void addRowsOfWater() {
        for (int i = 0; i< Coordinates.map_col; i++) {
            blocchi[0][i] = bf.waterBlock();
            insert_rec(0, i);
        }

    }

    public void addRiver(){
        addRowsOfWater();
    }

    public void addSea(){
        for (int i=0; i<3; i++){
            addRowsOfWater();
        }
    }

    protected Boolean isMeltable(int col) throws BlockErrorException{

        if (myinventory.ArrayList[col]instanceof SmeltableBlock){
            return true;
        }else {
            return false;
        }

    }

    SmeltableBlock gimme_smeltable(int col){
         return (SmeltableBlock) myinventory.ArrayList[col];
    }

    protected boolean is_pickable(Coordinates c) {
        if (!blocchi[c.row][c.col].pickable()) {
            return false;
        }
        return true;
    }

    Block gimme_pickable(Coordinates c) throws BlockErrorException  {
        if (!blocchi[c.row][c.col].pickable()){
            throw new BlockErrorException("The block is not pickable, try again with another block");
        }

        return blocchi[c.row][c.col];
    }

}
