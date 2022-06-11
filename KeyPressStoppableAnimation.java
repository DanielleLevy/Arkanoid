import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private Animation animation;
    private boolean stop;
    private String tav;
    private boolean isPress;

    @Override
    public void doOneFrame(DrawSurface d) {
        if (keyboardSensor.isPressed(tav)) {
            this.stop = true;
        } else {
            this.isPress = false;
        }
        this.animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the keyboard sensor
     * @param key       the key that pressed
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.tav = key;
        this.keyboardSensor = sensor;
        this.animation = animation;
        this.isPress = true;
        this.stop = false;
    }
}
