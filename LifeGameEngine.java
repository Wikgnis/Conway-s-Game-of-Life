import java.util.HashMap;
import java.util.ArrayList;;

public class LifeGameEngine{
    /* attributs */
    private int width;
    private int height;
    // cells
    private class Cell{
        private boolean alive;
        public Cell(){}
    }
    private Cell[][] map;
    private HashMap<Cell, Cell[]> nCell;
    /* constructor */
    public LifeGameEngine(int w, int h){
        map = new Cell[h][w];
        nCell = new HashMap<Cell, Cell[]>();
        /* init map */
        for (int i=0; i<h; i++){
            for (int e=0; e<w; e++){
                map[i][e] = new Cell();
            }
        }
        /* init neighbour */
        ArrayList<Cell> tempN = new ArrayList<Cell>();
        for (int i = 0; i < h; i++) {
            for (int e = 0; e < w; e++) {
                // clear the ArrayList we use to temporary store the neighbour list
                tempN.clear();
                // check if top possible
                if (i > 0) {
                    tempN.add(map[i-1][e]);
                    if (e > 0) {
                        tempN.add(map[i-1][e - 1]);
                    }
                    if (e < w - 1) {
                        tempN.add(map[i-1][e + 1]);
                    }
                }
                // check if bottom possible
                if (i < h - 1){
                    tempN.add(map[i+1][e]);
                    if (e > 0) {
                        tempN.add(map[i+1][e - 1]);
                    }
                    if (e < w - 1) {
                        tempN.add(map[i+1][e + 1]);
                    }
                }
                // check if left possible
                if (e > 0) {
                    tempN.add(map[i][e - 1]);
                }
                // check if Right possible
                if (e < w - 1) {
                    tempN.add(map[i][e + 1]);
                }
                /* put the ArrayList converted in array in the HashMap - tempN.toArray(new Cell[tempN.size()]) */
                nCell.put(map[i][e], tempN.toArray(new Cell[tempN.size()]));
            }
        }
        System.out.println("Engine loaded.");
    }
    /* methods */
    public int getW(){ return width; }
    public int getH() { return height; }
    public int getNbneighbour(int x, int y){ return nCell.get(map[x][y]).length; }
    public void update() { }
}