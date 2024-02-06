package Interface;

import Point.Point2d;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Transform implements Rotate, Translate{
    /** TODO
     * Rotate all points of collections given in parameters
     * with the angle given
     * @param coords collections of Point2d
     * @param angle
     * @return rotated collection
     * */
    public Collection<Point2d> rotate(Collection<Point2d> coords, Double angle) {
        Collection<Point2d> collectionRotated = new ArrayList<>();

        for(Point2d point : coords ){
            Point2d pointRotated = point.rotate(angle);
            collectionRotated.add(pointRotated);
        }

        return collectionRotated;
    }

    /** TODO
     * Translate all points of a collection by a given vector
     * @param coords Collection of Point2d
     * @param translateVector Vector of translation
     * @return translated coords
     * */
    public Collection<Point2d> translate(Collection<Point2d> coords, Point2d translateVector) {
        List<Point2d> collectionTranslated = new ArrayList<>();
        for(Point2d point : coords){
            Point2d pointTranslated = point.translate(translateVector);
            collectionTranslated.add(translateVector);
        }
        return collectionTranslated;
    }
}
