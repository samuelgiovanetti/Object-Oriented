package GUI;

import blocchi.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;


public class BlockPane extends StackPane{
    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 9;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;
    private Block blocco;
    private Rectangle bloccoRectangle;
    private Text bloccoText;
    public BlockPane(AbstractBlock blocco){
        this.blocco=blocco;
        this.bloccoRectangle = new Rectangle(DIM_SQUARE, DIM_SQUARE, getBlockColor(blocco));
        this.bloccoText = new Text(blocco.blockname);

        initialise();
    }
    static Color getBlockColor(AbstractBlock b){
        return b.colore;
    }

    private void initialise(){
        bloccoRectangle.setStroke(BLOCK_BORDER);
        bloccoText.setFill(FONT_FILL);
        bloccoText.setStroke(FONT_BORDER);
        bloccoText.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));

        getChildren().addAll(bloccoRectangle, bloccoText);
    }

    public void change_block(Block b){
        blocco = b;
        bloccoRectangle = new Rectangle(DIM_SQUARE, DIM_SQUARE, getBlockColor((AbstractBlock) blocco));
        bloccoText = new Text(((AbstractBlock) blocco).blockname);

        initialise();
    }
}
