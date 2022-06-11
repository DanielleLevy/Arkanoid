import java.util.ArrayList;

/**
 * The type Game environment.
 *
 * @author Daniel Levy ID:208150433
 */
public class GameEnvironment {
    private ArrayList<Collidable> collidableArrayList;

    /**
     * constructor.
     * Instantiates a new Game environment.
     */
    public GameEnvironment() {
        this.collidableArrayList = new ArrayList<Collidable>();
    }

    /**
     * Gets collidable array list.
     *
     * @return the collidable array list
     */
    public ArrayList<Collidable> getCollidableArrayList() {
        return collidableArrayList;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the cCollidable
     */
    public void addCollidable(Collidable c) {
        this.collidableArrayList.add(c);
    }

    /**
     * Remove collidabe from the list .
     *
     * @param c the collidabe to remove
     */
    public void removeCollidabe(Collidable c) {
        this.collidableArrayList.remove(c);
    }


    /**
     * The method returns the closest collision point.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory line of the object.
     * @return the closest collision to the object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point collideClose = null, point = null;
        Rectangle r = null, rectangle = null;
        if (this.collidableArrayList.isEmpty()) {
            return null;
        }
        int indexCollide = 0, flag = -1;
        for (; indexCollide < this.collidableArrayList.size(); indexCollide++) {
            r = this.collidableArrayList.get(indexCollide).getCollisionRectangle();
            collideClose = trajectory.closestIntersectionToStartOfLine(r);
            if (collideClose != null) {
                flag = 0;
                break;
            }
        }
        if (flag == 0) {
            if (indexCollide < this.collidableArrayList.size() - 1) {
                for (int i = indexCollide + 1; i < this.collidableArrayList.size(); i++) {
                    rectangle = this.collidableArrayList.get(i).getCollisionRectangle();
                    point = trajectory.closestIntersectionToStartOfLine(rectangle);
                    if (point != null) {
                        double distancePoint = collideClose.distance(trajectory.start());
                        double distanceNew = point.distance(trajectory.start());
                        if (distanceNew <= distancePoint) {
                            collideClose = point;
                            indexCollide = i;
                        }
                    }
                }
            }
            CollisionInfo cInfo = new CollisionInfo(collideClose, this.collidableArrayList.get(indexCollide));
            return cInfo;
        } else {
            return null;
        }
    }

}