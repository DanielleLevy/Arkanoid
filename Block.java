import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 *
 * @author Daniel Levy ID:208150433
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private Color c;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Block.
     *
     * @param r     the rectangle of the block
     * @param color the color of the block
     */
    public Block(Rectangle r, Color color) {
        this.shape = r;
        this.c = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        int flipX = 0, flipY = 0;
        if (this.shape.getLeftVertical().isContainL(collisionPoint)) {
            flipX = 1;
        }
        if (this.shape.getRightVertical().isContainL(collisionPoint)) {
            flipX = 1;
        }
        if (this.shape.getUpperHorizontal().isContainL(collisionPoint)) {
            flipY = 1;

        }
        if (this.shape.getDownerHorizontal().isContainL(collisionPoint)) {
            flipY = 1;
        }
        if (flipX == 1 && flipY == 0) {
            Velocity newV = new Velocity(-(currentVelocity.getDx()), currentVelocity.getDy());
            return newV;
        }
        if (flipX == 0 && flipY == 1) {
            Velocity newV = new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
            return newV;
        }
        if (flipX == 1 && flipY == 1) {
            Velocity newV = new Velocity(-(currentVelocity.getDx()), -(currentVelocity.getDy()));
            return newV;
        }
        return currentVelocity;
    }

    /**
     * The method adds the block to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove the block from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the surface of the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.c);
        surface.fillRectangle((int) this.shape.getUpperLeft().getX(), (int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * notify hit with a ball.
     *
     * @param hitter the ball who hit the block
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners =
                new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}