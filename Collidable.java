/**
 * The interface Collidable.
 *
 * @author Daniel Levy ID:208150433
 */
public interface Collidable {
    /**
     * The method returns the collision shape of the object.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter          the ball who hit.
     * @return the new velocity after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}