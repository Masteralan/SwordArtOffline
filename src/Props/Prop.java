package Props;

import java.awt.Color;

// Most basic form of prop, has position, size, velocity, acceleration, and friction
public class Prop {
    // instance variables - replace the example below with your own
    protected double velocityY = 0;
    protected double velocityX = 0;
    protected double accelerationX = 0;
    protected double accelerationY = 0;
    protected double friction;
    protected boolean collideable = true;
    protected boolean grounded = true;

    protected int positionY;
    protected int positionX;
    protected int sizeY;
    protected int sizeX;

    protected Color drawColor = Color.black;

    //Constructs for player
    public Prop() {
        friction = 0.6;

        positionX = 400;
        positionY = 0;

        sizeX = 50;
        sizeY = 50;
    }
    // Create an object with parameters position, size, and friction
    public Prop(int posY, int posX, int sX, int sY, double fric) {
        friction = fric;
        positionX = posX;
        positionY = posY;
        sizeX = sX;
        sizeY = sY;
    }

    public int GetPositionX() {
        return positionX;
    }
    public int GetPositionY() {
        return positionY;
    }
    public int GetSizeX() {
        return sizeX;
    }
    public int GetSizeY() {
        return sizeY;
    }
    public Color GetDrawColor() { return drawColor; }

    public boolean CanCollide() {
        return collideable;
    }
    public boolean IsGrounded() { return grounded; }

    // Tick object's physics by a frame
    public void Tick(int floor) {
        accelerationY/=1.1;//subject to change
        accelerationX/=1.1;//subject to change
        velocityX += accelerationX - friction*velocityX;
        velocityY += accelerationY - friction*velocityY;
        positionX = (int) velocityX + positionX;

        if ((int) velocityY + positionY >= floor) {
            positionY = floor;
            accelerationY = 0;
            velocityY = 0;
            grounded = true;
        } else {
            positionY = (int) velocityY + positionY;
            accelerationY += 1;
            grounded = false;
        }
    }
}