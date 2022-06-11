/**
 * The interface Hit listener.
 * @author Daniel Levy ID:208150433
 */
public interface HitListener {
    /**
     * Hit event.
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the being hit object
     * @param hitter   the hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}
