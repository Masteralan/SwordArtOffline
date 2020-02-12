package Objects.Entities;

import Objects.PhysicsProp;

// An object that has living properties
public class Entity extends PhysicsProp  {
    protected int Health = 100;
    protected int MaxHealth = 100;

    public float Lifetime = 0;

    public int Movement_MaxSpeed = 50;
    public int Movement_Force = 100;            //How quickly entity can accelerate
    protected float Movement_XThrottle = 0.0f;
    protected float Movement_YThrottle = 0.0f;  //Do we need this? (Enemies should jump, but??)

    public Entity(float xPosition, float yPosition) {
        super(xPosition, yPosition);

    }

    // Set movement throttles
    public void Move(float xThrottle, float yThrottle) {
        Movement_XThrottle = xThrottle;
        Movement_YThrottle = yThrottle;
    }

    public void Tick(float DeltaTime) {
        Lifetime+=DeltaTime;

        float applyX = 0;
        float applyY = 0;
        if (Math.abs(vx) < Math.abs(Movement_MaxSpeed*Movement_XThrottle)) {
            applyX = Movement_XThrottle;
        }
        if (Math.abs(vy) < Math.abs(Movement_MaxSpeed*Movement_YThrottle)) {
            applyY = -Movement_YThrottle;
        }

        ApplyForce(applyX*Movement_Force, applyY*Movement_Force, DeltaTime);
    }
}
