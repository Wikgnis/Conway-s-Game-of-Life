import java.util.ArrayList;

public class LifeGameEngine{
    /* attributs */
    private int width;
    private int height;
    // cells
    private class Cell{
        public boolean alive;
        private Cell[] n;
        private int nCell;
        Cell(){
            alive = false;
            nCell = 0;
        }
        public void add_n(Cell cell){
            n[nCell] = cell;
            nCell++;
        }
    }
    private Cell[][] cellsMap;
    /* constructor */
    public LifeGameEngine(int w, int h){
        cellsMap = new Cell[h][w];
        for (int i=0; i<h; i++){
            for (int e=0; e<w; e++){
                cellsMap[i][e] = new Cell();
            }
        }
        System.out.println("Engine loaded.");
    }
    /* methods */
    public int getW(){ return width; }
    public int getH() { return height; }
    public void update() { }
}