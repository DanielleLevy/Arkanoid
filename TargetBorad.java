import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Target borad.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class TargetBorad implements Sprite {
    private int biggerCircleSize;
    private int numberOfcircle;

    /**
     * Instantiates a new Target borad.
     *
     * @param r            the radius
     * @param numberCircle the number circle
     */
    public TargetBorad(int r, int numberCircle) {
        this.biggerCircleSize = r;
        this.numberOfcircle = numberCircle;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.pink);
        d.fillCircle(400, 200, this.biggerCircleSize);
        for (int i = 0; i < numberOfcircle - 1; i++) {
            if (i % 2 == 0) {
                d.setColor(Color.white);
            } else {
                d.setColor(Color.pink);
            }
            d.fillCircle(400, 200, this.biggerCircleSize - 5 * (i + 1));
        }
    }

    @Override
    public void timePassed() {

    }
}
