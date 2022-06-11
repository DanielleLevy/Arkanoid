
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Levy
 * ID:208150433
 * The type Rectangle.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left of the Rectangle
     * @param width     the width of the Rectangle
     * @param height    the height of the Rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * The method returns the top line of a rectangle.
     *
     * @return the upper horizontal line
     */
    public Line getUpperHorizontal() {
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Line upperHorizontal = new Line(this.upperLeft, upperRight);
        return upperHorizontal;
    }

    /**
     * The method returns the bottom line of a rectangle.
     *
     * @return the bottom horizontal line
     */
    public Line getDownerHorizontal() {
        Point downerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point downerRight = new Point(this.upperLeft.getX() + this.width, downerLeft.getY());
        Line downerHorizontal = new Line(downerLeft, downerRight);
        return downerHorizontal;
    }

    /**
     * The method returns the right line of a rectangle.
     *
     * @return the right vertical line
     */
    public Line getRightVertical() {
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point downerRight = new Point(upperRight.getX(), this.upperLeft.getY() + this.height);
        Line rightVertical = new Line(upperRight, downerRight);
        return rightVertical;
    }

    /**
     * The method returns the left line of a rectangle.
     *
     * @return the left vertical line
     */
    public Line getLeftVertical() {
        Point downerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Line leftVertical = new Line(this.upperLeft, downerLeft);
        return leftVertical;
    }

    /**
     * The method returns an array of points of intersection of the line with the rectangle.
     * Return a (possibly empty) List of intersection points with the specified line.
     * @param line the line
     * @return the list of points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> intersectionArray = new ArrayList<Point>();
        int countArray = 0;
        if (this.getUpperHorizontal().isIntersecting(line)) {
            intersectionArray.add(countArray, this.getUpperHorizontal().intersectionWith(line));
            countArray++;
        }
        if (this.getDownerHorizontal().isIntersecting(line)) {
            intersectionArray.add(countArray, this.getDownerHorizontal().intersectionWith(line));
            countArray++;
        }
        if (this.getRightVertical().isIntersecting(line)) {
            intersectionArray.add(countArray, this.getRightVertical().intersectionWith(line));
            countArray++;
        }
        if (this.getLeftVertical().isIntersecting(line)) {
            intersectionArray.add(countArray, this.getLeftVertical().intersectionWith(line));
            countArray++;
        }
        return intersectionArray;
    }

    /**
     * Return the width  of the rectangle.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the height of the rectangle.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
