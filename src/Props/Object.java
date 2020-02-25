package Props;

// Most basic form of prop, has position, size, velocity, acceleration, and friction
public class Object {
    // instance variables - replace the example below with your own
    protected double velocityY;
    protected double velocityX;
    protected double accelerationX;
    protected double accelerationY;
    protected double friction;
    protected boolean collideable = true;

    protected int positionY;
    protected int positionX;
    protected int sizeY;
    protected int sizeX;

    //Constructs for player
    public Object() {
        velocityY = 0;
        velocityX = 0;
        accelerationX = 0;
        accelerationY = 10;
        friction = 0.6;

        positionX = 400;
        positionY = 0;

        sizeX = 50;
        sizeY = 50;
    }
    // Create an object with parameters position, size, and friction
    public Object(int posY, int posX, int sX, int sY, double fric) {
        velocityY = 0;
        velocityX = 0;
        accelerationX = 0;
        accelerationY = 0;
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

    public boolean CanCollide() {
        return collideable;
    }
}