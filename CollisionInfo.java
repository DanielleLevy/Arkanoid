/**
 * The type Collision info.
 *  @author Daniel Levy ID:208150433
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor
     * Instantiates a new Collision info.
     *
     * @param p      the collision point
     * @param object the collision object
     */
    public CollisionInfo(Point p, Collidable object) {
        this.collisionPoint = p;
        this.collisionObject = object;
    }

    /**
     * return the point at which the collision occurs.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * return the collidable object involved in the collision.
     *
     * @return the object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}