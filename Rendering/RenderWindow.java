import javax.swing.*;
import java.awt.*;

// https://stackoverflow.com/questions/22402131/draw-rectangle-in-jframe-not-working

public class RenderWindow extends JFrame {
    RenderWindow(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation(100, 100);    //Set top left corner location on screen to 100, 100
        setSize(800, 600);        //Set window size to 800x600
        //frame.pack();                 //Automatically scales window to fit content
        setVisible(true);         //Makes the window visible
    }

    private float time = 0;
    private float deltaTime = 0;
    public void tick(float DeltaTime) {
        time+=DeltaTime;
        deltaTime = DeltaTime;
    }

    @Override
    public void paint(Grahpics g) {
        g.drawRect(200, 300);
    }
}