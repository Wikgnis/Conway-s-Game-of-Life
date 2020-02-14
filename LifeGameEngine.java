import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

public class LifeGameEngine{
    /* attributs */
    private int width;
    private int height;
    // cells
    private class Cell{
        public boolean alive;
        public Cell(){
            alive = false;
        }
    }
    private Cell[][] map;
    private HashMap<Cell, Cell[]> nCell;
    /* constructor */
    public LifeGameEngine(int w, int h){
        width = w;
        height = h;
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
    public boolean alive(int x, int y){ return map[x][y].alive;}
    // action on cells
    private boolean ifCellAlive(int x, int y){
        int count = 0;
        /* run through neighbour */
        for (int i = 0; i < getNbneighbour(x, y); i++) {
            // if neighbour alive
            if (nCell.get(map[x][y])[i].alive)
                count++;
        }
        return (count == 3 || count == 2);
    }
    private boolean ifCellDead(int x, int y) {
        int count = 0;
        /* run through neighbour */
        for (int i=0; i<getNbneighbour(x, y); i++){
            // if neighbour alive
            if (nCell.get(map[x][y])[i].alive) count++;
        }
        return (count == 3);
    }
    public boolean isAliveNext(int x, int y){
        if (map[x][y] != null){
            if (map[x][y].alive) return ifCellAlive(x, y);
            else return ifCellDead(x, y);
        }
        return false;
    }
    // engine action
    public void generateEcosystem(){
        Random r = new Random();
        for (int i=0; i<height; i++){
            for (int e=0; e<width; e++){
                map[i][e].alive = r.nextBoolean();
            }
        }
    }
    public void update() {
        Cell[][] tempMap = map.clone();
        for (int i = 0; i < height; i++) {
            for (int e = 0; e < width; e++) {
                tempMap[i][e].alive = isAliveNext(e, i);
            }
        }
        map = tempMap;
    }
}