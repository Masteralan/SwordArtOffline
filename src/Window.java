import Props.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class Window implements Runnable {
    JFrame frame;
    Canvas canvas;
    BufferStrategy bufferStrategy;

    boolean running = true;
    boolean up, down, left, right, attack;

    Player plr; // The player object of the player playing the game
    int floor = 500;

    public Window() {
        frame = new JFrame("Sword Art Offline");
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
            if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
                down = true;
            if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
                up = true;
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
                left = true;
            if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
                right = true;
            if (key == KeyEvent.VK_SPACE)
                attack = true;

            if (key == KeyEvent.VK_ESCAPE) {  // Close window upon hitting escape
                running = false;
                frame.dispose();
            }
          }

          @Override
          public void keyReleased(KeyEvent evt) {
            int key = evt.getKeyCode();
            if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
                down = false;
            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
                up = false;
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
                left = false;
            if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
                right = false;
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
        plr = new Player(0,0,50,50);

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
        plr.move(up, down, left, right, floor);

        //Image img = Toolkit.getDefaultToolkit().getImage("person.png");
        //g.drawImage(img, positionX,positionY,null);
        g.setColor(Color.BLACK);
        g.fillRect(plr.GetPositionX(),plr.GetPositionY(), plr.GetSizeX(),plr.GetSizeY());

    }
}
