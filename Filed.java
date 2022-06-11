import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Filed- Background for Level 5.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class  Filed implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0, 100, 0));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.white);
        d.drawLine(250, 200, 250, 50);
        d.drawLine(550, 200, 550, 50);
        d.drawLine(250, 200, 550, 200);
        d.drawLine(350, 130, 350, 50);
        d.drawLine(450, 130, 450, 50);
        d.drawLine(350, 130, 450, 130);
        d.drawLine(250, 600, 250, 450);
        d.drawLine(550, 600, 550, 450);
        d.drawLine(250, 450, 550, 450);
        d.drawLine(350, 600, 350, 550);
        d.drawLine(450, 600, 450, 550);
        d.drawLine(350, 550, 450, 550);
        d.drawLine(0, 325, 800, 325);
        d.drawCircle(400, 320, 90);
    }

    @Override
    public void timePassed() {

    }
}
