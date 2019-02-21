package edu.up.cs371.caoj22.hw2;

import android.graphics.Canvas;

/**
 * <!-- class CustomCircle -->
 *
 * This class defines a custom drawing element that is a circle.
 *
 * @author Andrew Nuxoll
 * @version Spring 2015
 *
 * @author Justin Cao
 * @version Spring 2019
 */

public class CustomCircle extends CustomShape
{

    /** these variables define the location and radius of a circle */
    private int x;
    private int y;
    private int radius;

    /** the circle's dimensions must be defined at construction
     * As of the Spring 2019 version, the circle additionally requires individual red, green, blue values*/
    public CustomCircle(String name, int r, int g, int b, int x, int y, int radius)
    {
        super(name, r, g, b);

        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    @Override
    public void drawMe(Canvas canvas)
    {
        canvas.drawCircle(x, y, radius, myPaint);  //main circle
    }


    /** for ease of calculation, just draw a box around the circle and see if the point is in that */
    @Override
    public boolean containsPoint(int x, int y)
    {
        //Calculate the distance between this point and the center
        int xDist = Math.abs(x - this.x);
        int yDist = Math.abs(y - this.y);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

        return (dist < this.radius + TAP_MARGIN);
    }//contaisPoint


    /** I knew that middle school geometry class would pay off someday */
    @Override
    public int getSize() {
        return (int)(Math.PI * this.radius * this.radius);
    }

}//class CustomCircle

