/* 2D Java Game AKA Sword Art Offline
by Will V, Clayton S, and Alan O

Runs in Java 11 SDK

How to configure project when using IntelliJ IDEA (scroll to bottom)
https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000156824-How-to-choose-main-class

*/

import Rendering.RenderWindow;

public class main {
    public static void main(String args[]) {
        System.out.println("Hello world!");

        RenderWindow window = new RenderWindow("Sword Art Offline");

        long lastTick = System.currentTimeMillis();
        while (window.isActive()) {  //While the frame is open (window has not been closed)
            long tick = System.currentTimeMillis();
            float deltaTime = (tick - lastTick) / (float) 1000;
            lastTick = tick;

            window.tick(deltaTime);
            window.repaint(tick);
        }
    }
}