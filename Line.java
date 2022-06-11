/**
 * The type Line.
 *
 * @author Daniel Levy ID:208150433
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start
     * @param end   the end
     */
    public Line(Point start, Point end) {
        this.end = end;
        this.start = start;
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x of the start point
     * @param y1 the of the start point
     * @param x2 the of the start point
     * @param y2 the of the start point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return the length of this line.
     */
    public double length() {
        return start.distance(this.end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the middle point
     */
    public Point middle() {
        double xMiddle = (this.end.getX() + this.start.getX()) / 2;
        double yMiddle = (this.end.getY() + this.start.getY()) / 2;
        Point middle = new Point(xMiddle, yMiddle);
        return middle;
    }

    /**
     * Returns the start point of the line.
     *
     * @return the start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return the end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * The method checks whether the line is parallel to the X-axis.
     *
     * @return true is parallel, false otherwise.
     */
    public boolean parallelToX() {
        if (this.start.getY() == this.end.getY()) {
            return true;
        }
        return false;
    }

    /**
     * The method checks whether the line is parallel to the Y-axis.
     *
     * @return true is parallel, false otherwise.
     */
    public boolean parallelToY() {
        if (this.start.getX() == this.end.getX()) {
            return true;
        }
        return false;
    }

    /**
     * The method returns the minimum X in line.
     *
     * @return the minX.
     */
    public double minX() {
        if (this.start.getX() >= this.end.getX()) {
            return this.end.getX();
        }
        return this.start.getX();
    }

    /**
     * The method returns the maximum X in line.
     *
     * @return the maxX.
     */
    public double maxX() {
        if (this.start.getX() >= this.end.getX()) {
            return this.start.getX();
        }
        return this.end.getX();
    }

    /**
     * The method returns the minimum Y in line.
     *
     * @return the minY.
     */
    public double minY() {
        if (this.start.getY() >= this.end.getY()) {
            return this.end.getY();
        }
        return this.start.getY();
    }

    /**
     * The method returns the maximum Y in line.
     *
     * @return the maxY.
     */
    public double maxY() {
        if (this.start.getY() >= this.end.getY()) {
            return this.start.getY();
        }
        return this.end.getY();
    }

    /**
     * The method returns the slope of the line.
     *
     * @return the slope.
     */
    public double slopeOfLine() {
        double resultX = this.start().getX() - this.end().getX();
        double resultY = this.start().getY() - this.end().getY();
        return (resultY / resultX);
    }

    /**
     * The method returns the point of intersection of the line with the Y-axis.
     *
     * @param slope the slope of the line.
     * @param point point of the line.
     * @return the intersection point with Y axis.
     */
    public double intersectionPointWithY(double slope, Point point) {
        return (point.getY() - (slope * point.getX()));

    }

    /**
     * The method checks if 2 lines contain each other.
     *The lines have the same slope.
     *If they contain each other the method returns null.
     * Otherwise, the method returns the point of intersection.
     * @param other the other line
     * @return the  intersection point
     */
    public Point isContainLine(Line other) {
        double maxX1 = this.maxX();
        double minX1 = this.minX();
        double maxY1 = this.maxX();
        double minY1 = this.minY();
        double maxX2 = other.maxX();
        double minX2 = other.minX();
        double maxY2 = other.maxY();
        double minY2 = other.minY();
        double xMin = Math.max(minX1, minX2);
        double yMin = Math.max(minY1, minY2);
        double xMax = Math.min(maxX1, maxX2);
        double yMax = Math.min(maxY1, maxY2);
        if (yMin == yMax) {
            return new Point(xMin, yMin);

        }
        return null;
    }

    /**
     * The method checks whether the line is a point.
     *
     * @return true if this point. false otherwise.
     */
    public boolean ifThisAPoint() {
        if (this.start.equals(this.end)) {
            return true;
        }
        return false;
    }

    /**
     * The method checks if there is a point of intersection between 2 lines.
     *The method is based on the equation of the line: y=ax+b
     *
     * @param other the other line
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point checkIntersection(Line other) {
        double sOther, sThis, bOther, bThis, yIntersection, xIntersection;
        if (this.equals(other)) {
            return null;
        }
        if (this.ifThisAPoint()) {                           //if this a point.
            if (other.ifThisAPoint()) {                     //if other a point.
                if (this.equals(other)) {                  //if other &&this equals points.
                    return this.start;
                } else {
                    return null;
                }
            }
            if (other.parallelToY()) {                      //if other is parallel to Y.
                if (other.isContain(this.start)) {          // if other contain this.
                    return this.start;
                }
                return null;
            }
            if (other.parallelToX()) {                      //if other is parallel to X.
                if (other.isContainL(this.start)) {        // if other contain this.
                    return this.start;
                }
                return null;
            }
            sOther = other.slopeOfLine();                // if other is a line with a slope
            bOther = other.intersectionPointWithY(sOther, other.start);
            yIntersection = sOther * this.start.getX() + bOther;
            if (yIntersection == this.start().getY()) {
                return this.start;
            }
            return null;
        }
        if (other.ifThisAPoint()) {                       //if other a point.
            if (this.parallelToY()) {                     //if this is parallel to Y.
                if (this.isContain(other.start)) {        // if this contain other.
                    return other.start;
                }
                return null;
            }
            if (this.parallelToX()) {                      //if this is parallel to X.
                if (this.isContain(other.start)) {         // if this contain other.
                    return other.start;
                }
                return null;
            }
            sThis = this.slopeOfLine();                  // if this is a line with a slope
            bThis = other.intersectionPointWithY(sThis, this.start);
            yIntersection = sThis * other.start.getX() + bThis;
            if (yIntersection == other.start().getY()) {
                return other.start;
            }
            return null;
        }
        if (this.parallelToX()) {                       //if this is parallel to X.
            if (other.parallelToY()) {                  //if other is parallel to Y.
                return new Point(other.start.getX(), this.start.getY());
            }
            if (other.parallelToX()) {                  //if other is parallel to X.
                if (this.isContainLine(other) != null) { // if this contain other.
                    return this.isContainLine(other);
                }
                return null;
            }
            sOther = other.slopeOfLine();               // if other is a line with a slope
            bOther = other.intersectionPointWithY(sOther, other.start);
            xIntersection = (this.start.getY() - bOther) / sOther;
            return new Point(xIntersection, this.start.getY());
        }
        if (other.parallelToX()) {                      //if other is parallel to X.
            if (this.parallelToY()) {                   //if this is parallel to Y.
                return new Point(this.start.getX(), other.start.getY());
            } else if (this.parallelToX()) {           //if this is parallel to X.
                if (other.isContainLine(this) != null) {    // if other contain this
                    return this.isContainLine(other);
                }
                return null;
            }
            sThis = this.slopeOfLine();                   // if this is a line with a slope
            bThis = this.intersectionPointWithY(sThis, this.start);
            xIntersection = (other.start.getY() - bThis) / sThis;
            return new Point(xIntersection, other.start.getY());
        }
        if (this.parallelToY()) {                       //if this is parallel to Y.
            if (other.parallelToY()) {                  //if other is parallel to Y.
                if (other.isContainLine(this) != null) {    // if other contain this
                    return this.isContainLine(other);
                }
                return null;
            }
            sOther = other.slopeOfLine();                 // if other is a line with a slope
            bOther = other.intersectionPointWithY(sOther, other.start);
            yIntersection = sOther * this.start.getX() + bOther;
            return new Point(this.start.getX(), yIntersection);
        }
        if (other.parallelToY()) {                      //if other is parallel to Y.
            if (this.parallelToY()) {                   //if this is parallel to Y.
                if (other.isContainLine(this) != null) {    // if other contain this
                    return this.isContainLine(other);
                }
                return null;
            }
            sThis = this.slopeOfLine();                 // if other is a line with a slope
            bThis = this.intersectionPointWithY(sThis, this.start);
            yIntersection = sThis * other.start.getX() + bThis;
            return new Point(other.start.getX(), yIntersection);
        }
        // if other && this are lines with a slope
        sOther = other.slopeOfLine();
        sThis = this.slopeOfLine();
        bOther = other.intersectionPointWithY(sOther, other.start);
        bThis = this.intersectionPointWithY(sThis, this.start);
        // if the slopes are even
        if (sOther == sThis) {
            return this.isContainLine(other);
        }
        xIntersection = (bOther - bThis) / (sThis - sOther);
        yIntersection = sThis * xIntersection + bThis;
        return new Point(xIntersection, yIntersection);

    }

    /**
     * The method sends the lines to find the point of intersection and checks whether it is contained in both lines.
     *The method returns the point of intersection if it is contained in the two lines
     * The method returns null if the dot is not contained in both lines
     * @param other the other line
     * @return the intersection point or null
     */
    public Point intersectionWith(Line other) {
        Point intersectionPoint = (checkIntersection(other));
        if (intersectionPoint != null) {
            double xIntersection = intersectionPoint.getX();
            double y = intersectionPoint.getY();
            double maxX1 = this.maxX();
            double minX1 = this.minX();
            double maxY1 = this.maxY();
            double minY1 = this.minY();
            double maxX2 = other.maxX();
            double minX2 = other.minX();
            double maxY2 = other.maxY();
            double minY2 = other.minY();
            if (xIntersection <= maxX1 && xIntersection >= minX1 && y <= maxY1 && y >= minY1 && xIntersection <= maxX2
                    && xIntersection >= minX2 && y <= maxY2 && y >= minY2) {
                return intersectionPoint;
            }
        }
        return null;
    }

    /**
     * The function receives a point and checks whether the line contains the point or not.
     * The function assumes that the line is parallel to the X or Y axis.
     * @param a the point
     * @return true If the line contains the point, false otherwise.
     */
    public boolean isContain(Point a) {
        if (this.start.getX() == this.end.getX() && this.start.getX() == a.getX()) {
            if ((a.getY() >= this.start.getY()) && (a.getY() <= this.end.getY())) {
                return true;
            }
            if ((a.getY() >= this.end.getY()) && (a.getY() <= this.start.getY())) {
                return true;
            }
        }
        if (this.start.getY() == this.end.getY() && this.start.getY() == a.getY()) {
            if ((a.getX() >= this.start.getX()) && (a.getX() <= this.end.getX())) {
                return true;
            }
            if ((a.getX() >= this.end.getX()) && (a.getX() <= this.start.getX())) {
                return true;
            }
        }

        return false;
    }

    /**
     * The function receives a point and checks whether the line contains the point or not.
     *
     * @param a the point
     * @return true If the line contains the point, false otherwise.
     */
    public boolean isContainL(Point a) {
        double epsilon = Math.pow(10, -5);
        double disStart = a.distance(this.start);
        double disEnd = a.distance(this.end);
        return Math.abs(this.length() - (disStart + disEnd)) <= epsilon;
    }

    /**
     * The function receives a line and checks whether the two lines are intersected.
     *
     * @param other the other line
     * @return true if the lines intersect, and false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) != null) {
            return true;
        }
        return false;
    }

    /**
     * The function receives a line and checks whether the lines are equal.
     *
     * @param other the other line
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if ((this.start.equals(other.start)) && (this.end.equals(other.end))) {
            return true;
        }
        if ((this.end.equals(other.start)) && (this.start.equals(other.end))) {
            return true;
        }
        return false;
    }

    /**
     * The function receives a line and checks whether this line contains the other.
     *
     * @param other the other line
     * @return True if this line contains the other, false otherwise.
     */
    public boolean containLine(Line other) {
        if (this.length() > other.length()) {
            if (this.isContain(other.start()) && this.isContain(other.end())) {
                return true;
            }
        }
        if (other.length() > this.length()) {
            if (other.isContain(this.start()) && other.isContain(this.end())) {
                return true;
            }
        }
        return false;
    }

    /**
     *  The method return the Closest intersection to start of line point.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect the rectangle.
     * @return the intersection point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this).isEmpty()) {
            return null;
        } else {
            if (rect.intersectionPoints(this).size() == 1) {
                return rect.intersectionPoints(this).get(0);
            }
            double distanceOne = rect.intersectionPoints(this).get(0).distance(this.start);
            double distanceTwo = rect.intersectionPoints(this).get(1).distance(this.start);
            if (distanceOne < distanceTwo) {
                return rect.intersectionPoints(this).get(0);
            } else {
                return rect.intersectionPoints(this).get(1);
            }
        }

    }


}
