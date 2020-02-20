import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.*;
import java.awt.*;
import java.io.File;

public class Window implements Runnable {
    JFrame frame;
    int positionX = 400;
    int positionY = 0;
    int floor = 500;
    double velocityY = 0;
    double velocityX = 0;
    double accelerationX = 0;
    double accelerationY = 10;
    double friction = 0.6;
    Canvas canvas;
    BufferStrategy bufferStrategy;
    boolean running = true;
    boolean up, down, left, right;
    public Window() {
      frame = new JFrame("frame");
      JPanel panel = (JPanel) frame.getContentPane();
      panel.setPreferredSize(new Dimension(1400, 800));
      panel.setLayout(null);
      canvas = new Canvas();
      canvas.setBounds(0, 0, 1400, 800);
      canvas.setIgnoreRepaint(true);
      panel.add(canvas);
      canvas.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent evt) {
            int key =evt.getKeyCode();
            if(key==KeyEvent.VK_DOWN) {
              down = true;
            }
            if(key==KeyEvent.VK_UP) {
              up = true;
            }
            if(key==KeyEvent.VK_LEFT) {
              left = true;
            }
            if(key==KeyEvent.VK_RIGHT) {
              right = true;
            }
          }
          @Override
          public void keyReleased(KeyEvent evt) {
            int key = evt.getKeyCode();
            if(key==KeyEvent.VK_DOWN) {
              down = false;
            }
            if(key==KeyEvent.VK_UP) {
              up = false;
            }
            if(key==KeyEvent.VK_LEFT) {
              left = false;
             }
             if(key==KeyEvent.VK_RIGHT) {
              right = false;
            }
          }
      });
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
  }
  public void run() {
    while (running = true) {
      Paint();
      try {
        Thread.sleep(25);
      } catch (InterruptedException e) {
      }
    }
  }
  public static void main(String[] args) {
      Thread.currentThread().setPriority((int)(Thread.MAX_PRIORITY));
      Window game = new Window();
      new Thread(game).start();
  }
  public void Paint() {
      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
      g.clearRect(0, 0, 1400, 800);
      Paint(g);
      bufferStrategy.show();
  }
  protected void Paint(Graphics2D g) {

    if(up) {
      //positionY-=8;
      if(positionY>=floor)
        accelerationY-=20;
    }
    if(down) {
      //positionY+=8;
      accelerationY++;
    }
    if(left) {
      //positionX-=8;
      accelerationX--;
    }
    if(right) {
      //positionX+=8;
      accelerationX++;
    }
    accelerationY/=1.1;//subject to change
    accelerationX/=1.1;//subject to change
    velocityX+=accelerationX - friction*velocityX;
    velocityY+=accelerationY - friction*velocityY;
    positionX = (int)velocityX+positionX;
    if((int)velocityY+positionY>=floor)
      positionY = floor;
    else {
      positionY = (int)velocityY+positionY;
      accelerationY+=1;

    }
    //Image img = Toolkit.getDefaultToolkit().getImage("person.png");
    //g.drawImage(img, positionX,positionY,null);
    g.setColor(Color.BLACK);
    g.fillRect(positionX,positionY,50,50);

  }
  public void moveIt(KeyEvent evt) {
    int key =evt.getKeyCode();
    if(key==KeyEvent.VK_DOWN) {
      down = true;
    }
    if(key==KeyEvent.VK_UP) {
      up = true;
    }
    if(key==KeyEvent.VK_LEFT) {
      left = true;
    }
     if(key==KeyEvent.VK_RIGHT) {
      right = true;
    }
  }
}
