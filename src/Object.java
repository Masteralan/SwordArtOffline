//
public class Object {
    // instance variables - replace the example below with your own
    private double velocityY;
    private double velocityX;
    private double accelerationX;
    private double accelerationY;
    private double friction;

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

    // Moves the object ith given inputs
    public void move(boolean up, boolean down, boolean left, boolean right, int floor) {

        if(up && positionY>=floor)
            accelerationY-=20;
        if(down)
          accelerationY++;
        if(left)
          accelerationX--;
        if(right)
          accelerationX++;

        accelerationY/=1.1;//subject to change
        accelerationX/=1.1;//subject to change
        velocityX+=accelerationX - friction*velocityX;
        velocityY+=accelerationY - friction*velocityY;
        positionX = (int)velocityX+positionX;

        if((int)velocityY+positionY>=floor) {
            positionY = floor;
            accelerationY = 0;
            velocityY = 0;
        }
        else {
            positionY = (int)velocityY+positionY;
            accelerationY+=1;
        }
    }
}