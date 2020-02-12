package Objects;

import java.awt.*;
import java.awt.image.ImageObserver;

// An object that holds basic data for position, size, and texture
public class Prop {
    public float x;   // X Position
    public float y;   // Y Position
    public int SizeX;
    public int SizeY;

    public Image texture = null;
    public Color color;

    public Prop(float xPosition, float yPosition) {
        x = xPosition;
        y = yPosition;

        SizeX = 100;
        SizeY = 100;

        color = new Color(200,200,200);
    }

    //Draws image
    public void draw(Graphics g, ImageObserver observer) {
        g.setColor(color);

        if (texture != null)
            g.drawImage(texture, (int) x, (int) y, observer);
        else
            g.fillRect((int) x, (int) y, SizeX, SizeY);
    }
}
