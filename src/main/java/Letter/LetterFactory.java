package Letter;

import Point.Point2d;
import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;
    final static Double differenceOfHalfMaxWidthAndHalfStripeThickness = maxWidth - halfStripeThickness;

    final static Double doubleStripeThickness = stripeThickness * 2.0;
    final static Double differenceOfMaxHeightAndDoubleStripeThickness = maxHeight - doubleStripeThickness;
    final static Double differenceOfMaxWidthAndDoubleStripeThickness = maxWidth - doubleStripeThickness;
    final static Double rotationAngle = 15.0;
    final static Double offset = 10.0;
    final static Double halfRevolutionAngle = 180.0;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()
    {
        BaseShape leftRectangle = new Rectangle(stripeThickness/2, maxHeight);
        BaseShape rightRectangle = new BaseShape(leftRectangle);

        rightRectangle.rotate(rightRectangle.getCoords(), Math.toRadians(-rotationAngle));
        rightRectangle.translate(rightRectangle.getCoords(), new Point2d((maxWidth/2)+offset, 0.0));

        leftRectangle.rotate(leftRectangle.getCoords(),Math.toRadians(rotationAngle));

        BaseShape centerSquare = new Square(stripeThickness+offset);
        centerSquare.translate(centerSquare.getCoords(), new Point2d(maxWidth/4, 0.0));

        BaseShape a = new BaseShape();
        a.add(leftRectangle);
        a.add(rightRectangle);
        a.add(centerSquare);
        return a;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B(){
        BaseShape verticalRectangle = new Rectangle(stripeThickness, maxHeight);
        BaseShape upperCircle = new Circle(maxHeight/4);

        BaseShape lowerCircle = new Circle(maxHeight/4);

        //move circles
        upperCircle.translate(upperCircle.getCoords(), new Point2d(2*stripeThickness, -maxHeight/4.0));
        lowerCircle.translate(lowerCircle.getCoords(), new Point2d(2*stripeThickness, maxHeight/4.0));
        BaseShape b = new BaseShape(verticalRectangle);
        b.add(upperCircle);
        b.add(lowerCircle);

        return b;

    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C()
    {
        BaseShape o = LetterFactory.create_O();
        BaseShape verticalRectangle = new Rectangle(stripeThickness*2, halfMaxHeight);
        verticalRectangle.translate(verticalRectangle.getCoords(), new Point2d(stripeThickness, 0.0));

        o.remove(verticalRectangle);

        return new BaseShape(o);
    }


    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E()
    {
        BaseShape firstHorizontalRectangle = new Rectangle(maxWidth, stripeThickness);
        BaseShape middleHorizontalRectangle = new BaseShape(firstHorizontalRectangle);
        BaseShape lastHorizontalRectangle = new BaseShape(firstHorizontalRectangle);
        BaseShape verticalRectangle = new Rectangle(stripeThickness, maxHeight);

        firstHorizontalRectangle.translate(firstHorizontalRectangle.getCoords(), new Point2d(2*stripeThickness, -(maxHeight - stripeThickness)/2));
        middleHorizontalRectangle.translate(middleHorizontalRectangle.getCoords(), new Point2d(2*stripeThickness, 0.0));
        lastHorizontalRectangle.translate(lastHorizontalRectangle.getCoords(), new Point2d(2*stripeThickness, (maxHeight - stripeThickness)/2));


        BaseShape e = new BaseShape(firstHorizontalRectangle);
        e.add(middleHorizontalRectangle);
        e.add(lastHorizontalRectangle);
        e.add(verticalRectangle);
        return e;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H(){
        BaseShape verticalRectangleLeft = new Rectangle(stripeThickness, maxHeight);
        BaseShape verticalRectangleRight = new Rectangle(stripeThickness, maxHeight);
        BaseShape horizontalRectangle = new Rectangle(maxWidth - stripeThickness, stripeThickness);

        //move rectangles
        verticalRectangleRight.translate(verticalRectangleRight.getCoords(), new Point2d(2*stripeThickness,0.0));
        horizontalRectangle.translate(horizontalRectangle.getCoords(), new Point2d(stripeThickness/2,0.0));


        BaseShape h = new BaseShape(verticalRectangleLeft);
        h.add(verticalRectangleRight);
        h.add(horizontalRectangle);
        return h;

    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        BaseShape leftRectangle = new Rectangle(stripeThickness, maxHeight);
        BaseShape rightRectangle = new BaseShape(leftRectangle);

        BaseShape diagonalRectangle = new Rectangle(stripeThickness, maxHeight + stripeThickness);


        leftRectangle.translate(leftRectangle.getCoords(), new Point2d(differenceOfHalfMaxWidthAndHalfStripeThickness * -1.0, 0.0));
        rightRectangle.translate(rightRectangle.getCoords(), new Point2d(maxWidth, 0.0));
        diagonalRectangle.rotate(diagonalRectangle.getCoords(), Math.toRadians(-35));

        BaseShape n = new BaseShape(leftRectangle);
        n.add(rightRectangle);
        n.add(diagonalRectangle);
        return n;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O()
    {
        BaseShape outerEllipse = new Ellipse(maxWidth, maxHeight);
        BaseShape innerEllipse = new Ellipse(differenceOfMaxWidthAndDoubleStripeThickness, differenceOfMaxHeightAndDoubleStripeThickness);

        outerEllipse.remove(innerEllipse);

        return new BaseShape(outerEllipse);
    }

}
