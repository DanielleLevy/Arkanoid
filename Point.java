/**
 * @author Daniel Levy
 * ID:208150433
 * The type Point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance double.
     *
     * @param other the other point
     * @return the distance between the points.
     */
    public double distance(Point other) {
        return (Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2)));
    }

    /**
     * equals -- return true is the points are equal, false otherwise.
     *
     * @param other the other point
     * @return true if equals, false otherwise.
     */
    public boolean equals(Point other) {
        if ((other == null || this == null)) {
            return false;
        }
        return (this.getX() == other.getX()) && (this.getY() == other.getY());
    }

    /**
     * Return the x value of this point.
     *
     * @return the x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the y value of this point.
     *
     * @return the y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Gets an X and sets it as the X of this point.
     *
     * @param x1 the x
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * Gets an Y and sets it as the Y of this point.
     *
     * @param y1 the y
     */
    public void setY(double y1) {
        this.y = y1;
    }
}
