import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameOfLifeInterface extends JFrame implements KeyListener{
    /* attributs */
    private LifeGameEngine engine;
    private boolean running;
    private boolean pause;
    /* constructor */
    public GameOfLifeInterface(LifeGameEngine engine){
        this.engine = engine;
        running = true;
        pause = false;
        /* window in itself */
        this.setTitle("Game of life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        /* keylistener */
        this.addKeyListener(this);
        /* center window */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        /* show window */
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        /* log */
        System.out.println("Display loaded.");
    }
    /* methods */
    public boolean running() { return running; }
    public boolean pause() { return pause; }

    public void CMD_display() {
        /* top border */
        System.out.print("+ ");
        for (int i = 0; i < engine.getW(); i++) System.out.print("- ");
        System.out.print("+\n");
        /* main */ 
        for (int i=0; i<engine.getH(); i++){
            System.out.print("| ");
            for (int e=0; e<engine.getW(); e++){
                if (engine.alive(i, e)) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.print("|\n");
        }
        /* lower border */
        System.out.print("+ ");
        for (int i = 0; i < engine.getW(); i++) System.out.print("- ");
        System.out.print("+\n");
    }
    
    public void keyPressed(KeyEvent e) {
        pause = !pause;
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }
}