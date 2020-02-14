public class Main{
    public static void main(String[] args){
        LifeGameEngine engine = new LifeGameEngine(500, 500);
        GameOfLifeInterface display = new GameOfLifeInterface(engine, "Graphical_interfaceDisplay");
        engine.generateEcosystem();
        while (display.running()){
            if (!display.pause()) engine.update();
            display.display();
        }
    }
}