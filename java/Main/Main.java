package Main;


import GUI.*;
import Utils.*;
import blocchi.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utente.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        MainGui mg = new MainGui();

        Scene scene = new Scene(mg, (Coordinates.map_col*60+400), (Coordinates.map_row*60));
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row number: ");
        Coordinates.map_row = scanner.nextInt();
        System.out.print("Enter column numeber: ");
        Coordinates.map_col = scanner.nextInt();

        MainView view = new MainView(Coordinates.map_row, Coordinates.map_col);
        launch();
        view.display_on_out();

        //change_at_coords(view.mymap);

        //MainView m = new MainGui();
        int INTERACTIONS = 20;
        /*for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row and then column, or enter '0' and then '0' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 0 && col == 0){
                view.myfurnace.smelt();
            }else{
                view.myfurnace.move_into_furnace(row, col);
            }
            view.display_on_out();
        }
        System.out.print(MainView.mymap.display_on_out() + '\n');*/


        view.display_on_out();
        for (int i = 0; i < INTERACTIONS; i++) {
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '0' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 0) {
                view.move_into_furnace_from_inventory(col);
            } else if (row == 99) {
                if (col == 9) {
                    view.smelt();
                } else if (col == 0) {
                    view.toggle_inventory_comparator();
                } else {
                    view.move_into_inventory_from_furnace();
                }
            } else {
                Coordinates c = new Coordinates(row, col);
                try {
                    if (c.row > 10 && c.col > 10) {
                        throw new WrongCoordinatesException("The coordinates are out of the map");
                    }
                } catch (WrongCoordinatesException exeption) {
                    continue;
                }
                view.pick_up_block(c);
            }
            view.display_on_out();
        }
    }

    private void change_at_coords(Map mymap) {

        for (int i = 0; i < 2; i++) {
            // Random rand = new Random();
            Scanner myObj = new Scanner(System.in);

            AbstractBlock myblock = new AirBlock();
            System.out.print(myblock.Display());


            //int row = rand.nextInt(row);
            System.out.print("Enter block row: ");
            int row = myObj.nextInt();

            //int col = rand.nextInt(col);
            System.out.print("Enter block column: ");
            int col = myObj.nextInt();

            Coordinates c = new Coordinates(row, col);

            mymap.change_cell(c);
            System.out.print(mymap.display_on_out() + '\n');
        }

    }


}
