package GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class FurnacePane extends VBox {
    private BlockPane input;
    private BlockPane output;

    public FurnacePane(BlockPane i, BlockPane o){
        this.input=i;
        this.output=o;
        display_on_out();
    }

    public void display_on_out(){
        Text f = new Text("Furnace");
        Text arrow = new Text("-->");

        f.setTextAlignment(TextAlignment.JUSTIFY);
        arrow.setTextAlignment(TextAlignment.JUSTIFY);
        setAlignment(Pos.BASELINE_RIGHT);

        getChildren().addAll(f,input,arrow,output);


    }
}
