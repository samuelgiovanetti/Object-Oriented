package blocchi;

import java.util.Random;

public class BlockFactory{

    public BlockFactory (){}

    public Block randomBlock() {
        Random rand = new Random();
        int n = rand.nextInt(4);

        switch (n) {
            case 0:
                return this.sand_block();
            case 1:
                return this.earthBlock();
            case 2:
                return this.rawironBlock();
            case 3:
                return this.torchBlock();
        }
        return null;
    }

    public SandBlock sand_block(){
        return new SandBlock();
    }
    public WaterBlock waterBlock(){
        return new WaterBlock();
    }
    public EarthBlock earthBlock(){

        return new EarthBlock();
    }
    public RawIronBlock rawironBlock(){

        return new RawIronBlock();
    }
    public NullBlock nullBlock(){

        return new NullBlock();
    }

    public TorchBlock torchBlock(){

        return new TorchBlock();
    }

    public AirBlock airBlock(){
        return new AirBlock();
    }

}


