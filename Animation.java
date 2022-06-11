import biuoop.DrawSurface;

/**
 * The interface Animation.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public interface Animation {
    /**
     * Do one frame.
     *
     * @param d the d
     */
    void doOneFrame(DrawSurface d);

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    boolean shouldStop();
}