package Props;

import java.awt.Color;

public class Particle extends Object {
    private int Lifetime;   // Max lifetime of particle in frames
    private int Life = 0;       // How many frames particle has present
    private int Type;       // Type of particle to render--changes how effects work

    private Color drawColor;

    public Particle(int posX, int posY, int id) {
        super(posX, posY, 0, 0, 0);

        Type = id;
        Lifetime = 20;
        Life = 0;

        drawColor = Color.CYAN;
    }

    public Color GetDrawColor() {
        return drawColor;
    }

    // Ticks particle life by 1 frame
    public void Tick() {
        Life++;

        // Delete particle if life is over

        float percent = (float) Life / (float) Lifetime;

        // Otherwise, tick particle size and color
    }
}
