import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class GameOfLifeGraphicInterface extends JPanel{
    /* attributs */
    private LifeGameEngine engine;
    int sizeCell;
    /* constructor */
    public GameOfLifeGraphicInterface( LifeGameEngine e, int sCell) {
        sizeCell = sCell;
        engine = e;
    }
    /* methods */
    public void paintComponent(Graphics g) {
        /* background */
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        /* Cell */
        g.setColor(Color.black);
        for (int i=0; i<engine.getH(); i++){
            for (int e=0; e<engine.getW(); e++){
                if (engine.alive(i, e)) {
                    g.fillRect(e * sizeCell, i * sizeCell, sizeCell, sizeCell);
                }
            }
        }
    }
}