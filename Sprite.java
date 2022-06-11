import biuoop.DrawSurface;

/**
 * The interface Sprite.
 * @author Daniel Levy
 * ID:208150433
 */
public interface Sprite {
    /**
     *draw the sprite to the screen.
     *
     * @param d the surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}