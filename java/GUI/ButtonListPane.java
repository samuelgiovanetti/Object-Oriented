package GUI;

import Utils.Coordinates;
import blocchi.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Random;


public class ButtonListPane extends VBox {
    public ButtonListPane(){
        change_block();
        pick_block();
        move_to_furnace();
        smelt();
        move_back();
        toggle_inventory_sorting();
    }

    void change_block(){
        Button change_block = new Button();
        change_block.setText("Change Block random");
        change_block.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Random rand = new Random();
                BlockFactory bf = new BlockFactory();
                Block sb = bf.randomBlock();
                Coordinates c = new Coordinates(rand.nextInt(Coordinates.map_row), rand.nextInt(Coordinates.map_col));
                MainGui.mp.setCell(c,sb);
            }
        });
        getChildren().addAll(change_block);
    }
    void pick_block(){
        HBox pick_box = new HBox();
        Text pick_field = new Text("TextField");
        Text pick_field2 = new Text("TextField");
        Button pick = new Button();
        pick.setText("Pick");
        pick_box.getChildren().addAll(pick_field,pick_field2,pick);
        this.getChildren().addAll(pick_box);
        pick.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

            }
        });
        getChildren().addAll(pick);
    }

    void move_to_furnace(){
        HBox move_to_furnace_box = new HBox();
        Text move_to_furnace_field = new Text("TextField");
        Button move_to_furnace = new Button();
        move_to_furnace.setText("Move to Furnace");
        move_to_furnace.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            }
        });
        move_to_furnace_box.getChildren().addAll(move_to_furnace_field,move_to_furnace);
        this.getChildren().add(move_to_furnace_box);
    }

    void smelt(){
        Button smelt = new Button();
        smelt.setText("Smelt");
        smelt.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            }
        });
        getChildren().addAll(smelt);
    }

    void move_back(){
        Button move_back = new Button();
        move_back.setText("Move back");
        move_back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            }
        });
        getChildren().addAll(move_back);
    }

    void toggle_inventory_sorting(){
        Button toggle_inventory_sorting = new Button();
        toggle_inventory_sorting.setText("Toggle Inventory Sorting");
        toggle_inventory_sorting.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            }
        });
        getChildren().addAll(toggle_inventory_sorting);
    }

}




