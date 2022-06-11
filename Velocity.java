/**
 * @author Daniel Levy
 *  ID:208150433
 * The type Velocity.
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Instantiates a new Velocity.
     *constructor
     * @param dx the delta x
     * @param dy the delta y
     */

    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Gets dx.
     *
     * @return the delta x
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     *
     * @return the delta y
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Apply to point point.
     *The method gets a point and returns its new position after the changes.
     * The changes are made according to delta x,y.
     * @param p the point
     * @return the point in the new position.
     */
    public Point applyToPoint(Point p) {
        Point veloPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return veloPoint;
    }

    /**
     * From angle and speed velocity.
     *The method gets angle and speed and determines the Delta X-Y according to them.
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle - 90.0);
        double dx = Math.cos(angleRad) * speed;
        double dy = Math.sin(angleRad) * speed;
        return new Velocity(dx, dy);
    }
}