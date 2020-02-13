import java.util.ArrayList;

public class LifeGameEngine{
    /* attributs */
    private int width;
    private int height;
    // cells
    private boolean[][] cellsMap;
    /* constructor */
    public LifeGameEngine(int w, int h){
        cellsMap = new boolean[h][w];
        for (int i=0; i<h; i++){
            for (int e=0; e<w; e++){
                cellsMap[i][e] = false;
            }
        }
        System.out.println("Engine loaded.");
    }
    /* methods */
    public int getW(){ return width; }
    public int getH() { return height; }

}