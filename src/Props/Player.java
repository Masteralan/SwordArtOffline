package Props;

// An object with movement and attack functions
public class Player extends Object {
    public Player(int posY, int posX, int sX, int sY) {
        super(posY, posX, sX, sY, 0.7);
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
