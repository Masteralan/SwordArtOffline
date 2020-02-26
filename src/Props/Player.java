package Props;

// An object with movement and attack functions
public class Player extends Prop {
    public Player(int posY, int posX, int sX, int sY) {
        super(posY, posX, sX, sY, 0.7);
    }

    // Moves the object ith given inputs
    public void move(boolean up, boolean down, boolean left, boolean right) {

        if(up && IsGrounded())
            accelerationY-=20;
        if(down)
            accelerationY++;
        if(left)
            accelerationX--;
        if(right)
            accelerationX++;
    }
}
