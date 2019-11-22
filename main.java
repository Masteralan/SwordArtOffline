// To compile: javac main.java
// To run: java main

//import java.awt.key;
import javax.swing.JFrame;

class Main {
    public static void main(String args[]) {
        System.out.println("Hello world!");

        JFrame frame = new JFrame("Sword Art Offline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocation(100, 100);    //Set top left corner location on screen to 100, 100
        frame.setSize(800, 600);        //Set window size to 800x600
        //frame.pack();                 //Automatically scales window to fit content
        frame.setVisible(true);         //Makes the window visible

        while (frame.isActive()) {  //While the frame is open (window has not been closed)
            
        }
    }
}