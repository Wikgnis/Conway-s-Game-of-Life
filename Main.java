public class Main{
    public static void main(String[] args){
        LifeGameEngine engine = new LifeGameEngine(10, 10);
        GameOfLifeInterface display = new GameOfLifeInterface(engine);
    }
}