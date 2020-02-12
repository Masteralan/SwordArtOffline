package Rendering;

import Objects.Prop;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class RenderWindow extends JFrame {
    private ImageObserver imageObserver;

    public RenderWindow(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIgnoreRepaint(false);
        
        setLocation(100, 100);    //Set top left corner location on screen to 100, 100
        setSize(800, 600);        //Set window size to 800x600
        //frame.pack();                 //Automatically scales window to fit content
        setVisible(true);         //Makes the window visible
    }

    private float time = 0;
    private float deltaTime = 0;
    public void tick(float DeltaTime) {
        time += DeltaTime;
        deltaTime = DeltaTime;
    }


    public ArrayList<Prop> props = new ArrayList<Prop>();
    public void AddProp(Prop newProp) {
        if (newProp != null)
            props.add(newProp);
    }
    public void RemoveProp(Prop propToRemove) {
        props.remove(propToRemove);
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw each individual object
        if (props.size() > 0) {
            for (Prop prop : props) {
                prop.draw(g, imageObserver);

                //System.out.println("Drawing Prop at " + prop.x + ", " + prop.y);
            }
        }
    }
}