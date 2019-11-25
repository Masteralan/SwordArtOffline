// To compile: javac main.java
// To run: java main

//import java.awt.key;
import javax.swing.JFrame;
import Rendering.RenderWindow;

class Main {
    public static void main(String args[]) {
        System.out.println("Hello world!");

        RenderWindow window = new RenderWindow("Sword Art Offline");

        long lastTick = System.currentTimeMillis();
        while (window.isActive()) {  //While the frame is open (window has not been closed)
            long tick = System.currentTimeMillis();
            float deltaTime = (tick - lastTick) / 1000;
            lastTick = tick;

            window.tick(deltaTime);
            window.repaint();
        }
    }
}