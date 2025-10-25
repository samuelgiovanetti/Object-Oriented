package utente;

import blocchi.*;


public class Furnace{
    BlockFactory bf = new BlockFactory();
    SmeltableBlock furnaceInput = new NullBlock();
    Block furnaceOutput = new NullBlock();
    Map mymap;
    Inventory myinventory;

    public Furnace(Map mymap, Inventory myinventory) { // Modify the constructor to accept a MainView instance
        this.mymap = mymap;
        this.myinventory=myinventory;
    }

    public void move_into_furnace(int col){
            setInput(mymap.gimme_smeltable(col));
            myinventory.ArrayList[col]= bf.nullBlock();
    }
    public void display_on_out(){
        System.out.println("|| "
                +this.furnaceInput.Display()
                +" --> "
                +this.furnaceOutput.Display()
                +" ||");
    }

    public void smelt(){
        System.out.println("Smelting "+furnaceInput.toString()+" into "+furnaceOutput.toString());
        if (furnaceInput instanceof SandBlock){
            myinventory.add_block(new GlassBlock());
        }
        else if (furnaceInput instanceof RawIronBlock){
            myinventory.add_block(new IronSwordBlock());
        }
        else {
            System.out.println("No inventory where to store the smelted " + furnaceOutput.toString());
            furnaceOutput = bf.nullBlock();
        }
        furnaceInput = bf.nullBlock();

    }

    private void setInput(SmeltableBlock a){
        furnaceInput = a;
        furnaceOutput=furnaceInput.smelt();
    }

    public Block getInput(){
        return furnaceInput;
    }
    public Block getOutput(){
        return furnaceOutput;
    }
}
