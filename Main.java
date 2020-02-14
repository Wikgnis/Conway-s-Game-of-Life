public class Main{
    public static void main(String[] args){
        LifeGameEngine engine = new LifeGameEngine(20, 20);
        GameOfLifeInterface display = new GameOfLifeInterface(engine);
        engine.generateEcosystem();
        display.CMD_display();
    }
}