import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GameOfLifeInterface extends JFrame implements KeyListener{
    /* attributs */
    private LifeGameEngine engine;
    private enum typeDisplay{ Abstract, CMD_line, Graphical_interface }
    private typeDisplay currentDisplay;
    private boolean running;
    private boolean pause;
    private GameOfLifeGraphicInterface graphicDisplay;
    /* constructor */
    public GameOfLifeInterface(LifeGameEngine engine){
        this.engine = engine;
        running = true;
        pause = false;
        currentDisplay = typeDisplay.CMD_line;
        /* log */
        System.out.println("Display loaded.");
    }
    
    public GameOfLifeInterface(LifeGameEngine engine, String type) {
        this.engine = engine;
        running = true;
        pause = false;
        int cellSize = 1;
        /* choice display setup */
        switch (type) {
            case "CMD_lineDisplay":
                currentDisplay = typeDisplay.CMD_line;
                break;
            case "Graphical_interfaceDisplay":
                currentDisplay = typeDisplay.Graphical_interface;
                /* window in itself */
                this.setTitle("Snake in Java");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setResizable(false);
                /* jpannel */
                graphicDisplay = new GameOfLifeGraphicInterface(engine, cellSize);
                this.setContentPane(graphicDisplay);
                this.getContentPane().setPreferredSize(new Dimension(cellSize*engine.getW(), cellSize*engine.getH()));
                /* keylistener */
                this.addKeyListener(this);
                /* center window */
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
                /* show window */
                this.pack();
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                break;
            default:
                currentDisplay = typeDisplay.CMD_line;
                break;
        }
        /* log */
        System.out.println("Display loaded.");
    }
    /* methods */
    public boolean running() { return running; }
    public boolean pause() { return pause; }

    public void CMD_lineDisplay() {
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
    public void AbstractDisplay() { }
    public void Graphical_interfaceDisplay() {
        graphicDisplay.repaint();
        
    }
    public void display() {
        switch (currentDisplay) {
            case Abstract:
                AbstractDisplay();
                break;
            case CMD_line:
                CMD_lineDisplay();
                break;
            case Graphical_interface:
                Graphical_interfaceDisplay();
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        pause = !pause;
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }
}