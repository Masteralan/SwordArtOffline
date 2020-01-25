package Objects;

// A prop that holds additional data for physics and collisions
public class PhysicsProp extends Prop {
    public float vx;  // X Velocity
    public float vy;  // Y Velocity
    public int Mass;
    public boolean Anchored = false;    // Do we want the object to be affected by physics?

    public PhysicsProp(float xPosition, float yPosition) {
        super(xPosition, yPosition);

        vx = 0;
        vy = 0;
        Mass = 1;
    }

    // Applies a given force for a set amount of time (works instantaneously)
    public void ApplyForce(float ForceX, float ForceY, float DeltaTime) {
        vx += (ForceX/Mass)*DeltaTime;
        vy += (ForceY/Mass)*DeltaTime;
    }
}
