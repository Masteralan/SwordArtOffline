/* 2D Java Game AKA Sword Art Offline
by Will V, Clayton S, and Alan O

Runs in Java 11 SDK

How to configure project when using IntelliJ IDEA (scroll to bottom)
https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000156824-How-to-choose-main-class

*/

import Objects.Entities.Entity;
import Rendering.RenderWindow;
import UserInterface.ControlScheme;

import java.awt.*;
import java.awt.event.WindowEvent;

public class main {
    public static void main(String args[]) {
        System.out.println("Hello world!");

        RenderWindow window = new RenderWindow("Sword Art Offline");
        ControlScheme input = new ControlScheme();

        System.out.println("Window and input set up.");

        Entity player = new Entity(100,100);
        player.color = new Color(200, 0, 100);
        window.AddProp(player);
        //window.props.add(player);
        player.color = new Color(0,160,0);

        System.out.println("Set up complete!");

        // Wait for window to become active
        while (!window.isActive()) {

        }

        long lastTick = System.currentTimeMillis();
        while (window.isActive()) {  //While the frame is open (window has not been closed)
            long tick = System.currentTimeMillis();
            float deltaTime = (tick - lastTick) / (float) 1000;
            lastTick = tick;
            System.out.println("New frame with DT " + deltaTime);
            boolean up, down, left, right;
            up = input.IsKeyDown('w');
            right = input.IsKeyDown('d');
            left = input.IsKeyDown('a');
            down = input.IsKeyDown('s');
            int playerDirX = 0;
            int playerDirY = 0;
            if (right)
                playerDirX++;
            if (left)
                playerDirX--;
            if (up)
                playerDirY++;
            if (down)
                playerDirY--;
            player.Move((float) playerDirX, (float) playerDirY);
            player.Tick(deltaTime);

            player.x += player.vx*deltaTime;
            player.y += player.vy*deltaTime;

            System.out.println("Player has position " + player.x + ", " + player.y + " and velocity " + player.vx + ", " + player.vy);

            window.tick(deltaTime);
            //window.repaint(tick);

            if (input.IsKeyDown('x'))
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        }

        System.out.println("Closing!");

        input.Close();

        System.out.println("Goodbye!");
    }
}
