// To compile: javac main.java
// To run: java main

//import java.awt.key;
import javax.swing.JFrame;

class Main {
    public static void main(String args[]) {
        System.out.println("Hello world!");

        JFrame frame = new JFrame("Sword Art Offline");
        //frame.setTitle("Sword Art Offline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocation(100, 100);
        frame.setSize(800, 600);
        frame.pack();
        frame.setVisible(true);

        while (frame.isActive()) {
            
        }
    }
}