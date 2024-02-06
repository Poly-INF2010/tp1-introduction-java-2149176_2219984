package Shape;

import Interface.Transform;
import Point.Point2d;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape extends Transform implements Cloneable
{
    static protected final double divider = 2.0;
    static protected final double step = 0.5;
    private final Collection<Point2d> coords;

    //helper function to clone a list of points
    public Collection<Point2d> cloneCoords(Collection<Point2d> coords) {
        return coords.stream().map(Point2d::clone).collect(Collectors.toList());
    }

    /** TODO
     * Create a BaseShape with empty coordinades
     */
    public BaseShape() { this(new ArrayList<Point2d>(0)); }

    /** TODO
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords)
    {
        this.coords = new ArrayList<>(coords.size());
        this.addAll(coords);
    }

    public BaseShape(BaseShape shape)
    {
        this(shape.cloneCoords());
    }

    /** TODO
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord)
    {
        this.coords.add(coord.clone());
        return this;
    }

    /** TODO
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape)
    {
        return this.addAll(shape.cloneCoords());
    }

    /** TODO
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords)
    {
        for(Point2d p : coords)
            this.add(p);
        return this;
    }

    /** TODO
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord)
    {
        this.coords.remove(coord);
        return this;
    }

    /** TODO
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape)
    {
        this.removeAll(shape.cloneCoords());
        return this;
    }

    /** TODO
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords)
    {
        for(Point2d p : coords)
            this.remove(p);
        return this;
    }

    /** TODO
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        this.removeAll(this.getCoords());
        this.addAll(newCoords);
        return null;
    }

    /** TODO
     * Return a shallow copy of the coordinates of the shape
     * @return Shallow copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> getCoords() { return new ArrayList<>(this.coords); }

    /** TODO
     * Create and return a deep copy of the coordinates of the shape
     * @return Deep copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> cloneCoords()
    {
        Collection<Point2d> clonedCoords = new ArrayList<Point2d>(this.coords.size());
        for(Point2d p : this.coords)
            clonedCoords.add(p.clone());
        return clonedCoords;
    }


    /** TODO
     * @return Maximum X coordinate of the shape
     */
    public Double getMaxX()
    {
        Double maxX = -Double.MAX_VALUE;
        if(!(this.coords.isEmpty()))
        {
            for(Point2d p : this.coords)
                if(maxX < p.X())
                    maxX = p.X();
        }
        return maxX;
    }

    /** TODO
     * @return Maximum Y coordinate of the shape
     */
    public Double getMaxY()
    {
        Double maxY = -Double.MAX_VALUE;
        if(!(this.coords.isEmpty()))
        {
            for(Point2d p : this.coords)
                if(maxY < p.Y())
                    maxY = p.Y();
        }
        return maxY;
    }

    /** TODO
     * @return 2D Point containing the maximum X and Y coordinates of the shape
     */
    public Point2d getMaxCoord() { return new Point2d(getMaxX(), getMaxY()); }

    /** TODO
     * @return Minimum X coordinate of the shape
     */
    public Double getMinX()
    {
        Double maxX = Double.MAX_VALUE;
        if(!(this.coords.isEmpty()))
        {
            for(Point2d p : this.coords)
                if(maxX > p.X())
                    maxX = p.X();
        }
        return maxX;
    }

    /** TODO
     * @return Minimum Y coordinate of the shape
     */
    public Double getMinY()
    {
        Double maxY = Double.MAX_VALUE;
        if(!(this.coords.isEmpty()))
        {
            for(Point2d p : this.coords)
                if(maxY > p.Y())
                    maxY = p.Y();
        }
        return maxY;
    }

    /** TODO
     * @return 2D point containing the minimum X and Y coordinate of the shape
     */
    public Point2d getMinCoord() { return new Point2d(getMinX(), getMinY()); }

    /** TODO
     * @return Deep copy of the current shape
     */
    public BaseShape clone() { return new BaseShape(this.cloneCoords()); }
}
