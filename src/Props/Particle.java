package Props;

import java.awt.Color;

public class Particle extends Prop {
    private int Lifetime;   // Max lifetime of particle in frames
    private int Life = 0;       // How many frames particle has present
    private int Type;       // Type of particle to render--changes how effects work

    public Particle(int posX, int posY, int id) {
        super(posX, posY, 0, 0, 0);

        Type = id;
        Lifetime = 20;
        Life = 0;

        drawColor = Color.CYAN;
    }

    // Ticks particle life by 1 frame
    @Override
    public void Tick(int floor) {
        super.Tick(floor);
        Life++;

        float percent = (float) Life / (float) Lifetime;

        // Otherwise, tick particle size and color
        drawColor = new Color(drawColor.getRed(), drawColor.getBlue(), drawColor.getGreen(), 255*percent);
        sizeX = (int) (100*percent + 50);
        sizeY = (int) (100*percent + 50);
    }
}
