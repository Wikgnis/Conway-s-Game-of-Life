public class GameOfLifeInterface{
    /* attributs */
    LifeGameEngine engine;
    /* constructor */
    public GameOfLifeInterface(LifeGameEngine engine){
        this.engine = engine;
        System.out.println("Display loaded.");
    }
    /* methods */
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
}