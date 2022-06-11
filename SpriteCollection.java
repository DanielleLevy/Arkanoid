import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * The type Sprite collection.
 *
 * @author Daniel Levy ID:208150433
 */
public class SpriteCollection {
    private ArrayList<Sprite> spriteArrayList;

    /**
     * constructor
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spriteArrayList = new ArrayList<Sprite>();
    }

    /**
     * Add sprite to the sprite array.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.spriteArrayList.add(s);
    }

    /**
     * Remove sprite from the array.
     *
     * @param s the sprite to remove
     */
    public void removeSprite(Sprite s) {
        this.spriteArrayList.remove(s);
    }


    /**
     * Notify all time passed.
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteArrayList.size(); i++) {
            spriteArrayList.get(i).timePassed();
        }
    }

    /**
     * Draw all on.
     * call drawOn(d) on all sprites.
     *
     * @param d the drawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteArrayList.size(); i++) {
            spriteArrayList.get(i).drawOn(d);
        }
    }
}