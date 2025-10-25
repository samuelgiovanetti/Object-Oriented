package utente;

import Utils.Coordinates;
import blocchi.AirBlock;
import GUI.*;



public class MainView {
    private final Map mymap;
    private final Furnace myfurnace;
    private final Inventory myinventory;


    public MainView(int map_row, int map_col) {
        myinventory = new Inventory();
        mymap = new Map(map_row, map_col, myinventory);
        myfurnace = new Furnace(mymap, myinventory);

        mymap.addRiver();
        System.out.print(mymap.display_on_out() + '\n');

    }


    public void display_on_out() {
        mymap.display_on_out();
        myfurnace.display_on_out();
        myinventory.display_in_inventory();
    }

    public Inventory get_myinventory(){
        return myinventory;
    }

    public Map get_mymap(){
        return mymap;
    }

    public Furnace get_myfurnace(){
        return myfurnace;
    }

    public void smelt() {
        myfurnace.smelt();
    }

    public void move_into_furnace_from_inventory(int col) {
        try {
            mymap.isMeltable(col);
        } catch (BlockErrorException exeption) {
            System.out.println("The Block is not Smeltable");
        }
        myfurnace.move_into_furnace(col);
    }

    public void move_into_inventory_from_furnace() {
            myinventory.move_to_inventory(myfurnace.getInput());
        }

    public void pick_up_block(Coordinates c)  {
        try{
            myinventory.move_to_inventory(mymap.gimme_pickable(c));
        }catch(BlockErrorException exception) {
            return;
        }
        mymap.setBlock(c.row,c.col,new AirBlock());
        mymap.order_map();
    }

    public void toggle_inventory_comparator(){
        myinventory.change_comparetor();
    }

    
}
