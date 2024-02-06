package Shape;

import Point.Point2d;

import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter)
    {
        super();
        for(Double i = heightDiameter / -divider; i <= heightDiameter / divider; i += step)
            for(Double j = widthDiameter / -divider; j <= widthDiameter / divider; j += step)
                if((Math.pow(j, 2.0) / Math.pow(widthDiameter / 2.0, 2.0)) +
                        (Math.pow(i, 2.0) / Math.pow(heightDiameter / 2.0, 2.0)) <= 1.0)
                    this.add(new Point2d(j, i));
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions)
    {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords)
    {
        super(coords);
    }


    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone()
    {
        return new Ellipse(super.cloneCoords());
    }
}
