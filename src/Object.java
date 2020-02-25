
/**
 * The player
 *
 * @author Will V
 * @version (a version number or a date)
 */
public class Object
{
    // instance variables - replace the example below with your own
    private double velocityY;
    private double velocityX;
    private double accelerationX;
    private double accelerationY;
    private double friction;
    protected int positionY;
    protected int positionX;

    //Constructs for player
    public Object()
    {
        velocityY = 0;
        velocityX = 0;
        accelerationX = 0;
        accelerationY = 10;
        friction = 0.6;
        positionX = 400;
        positionY = 0;
    }
    //Custom object
    public Object(double aX, double aY, double friction, int posY, int posX)
    {
        velocityY = 0;
        velocityX = 0;
        accelerationX = aX;
        accelerationY = aY;
        this.friction = friction;
        positionX = posX;
        positionY = posY;
    }

    //Moves the player
    public void move(boolean up, boolean down, boolean left, boolean right, int floor)
    {
        // put your code here
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
        if((int)velocityY+positionY>=floor)
        {
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
