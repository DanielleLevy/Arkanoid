import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Sea.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433 */
public class Sea implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(252, 196, 9));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(new Color(255, 194, 0));
        d.fillRectangle(0, 110, 800, 100);
        d.setColor(new Color(241, 149, 4));
        d.fillRectangle(0, 210, 800, 100);
        d.setColor(new Color(250, 108, 0));
        d.fillRectangle(0, 250, 800, 200);
        d.setColor(new Color(255, 243, 4));
        d.fillCircle(400, 360, 70);
        d.setColor(new Color(83, 173, 227));
        d.fillRectangle(0, 350, 800, 400);

    }

    @Override
    public void timePassed() {

    }
}
