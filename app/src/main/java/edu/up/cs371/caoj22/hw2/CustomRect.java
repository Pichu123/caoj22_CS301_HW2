package edu.up.cs371.caoj22.hw2;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * <!-- class CustomRect -->
 *
 * This class defines a custom drawing element that is a rectangle.
 *
 * @author Andrew Nuxoll
 * @version Spring 2015
 *
 * @author Justin Cao
 * @version Spring 2019
 */

public class CustomRect extends CustomShape
{


    /** the position and size of the rectangle is stored here */
    protected Rect myRect;

    /** the rectangles dimensions must be defined at construction
     * As of the Spring 2019 version, the rectangle additionally requires individual red, green, blue values*/
    public CustomRect(String name, int r, int g, int b,
                      int left, int top, int right, int bottom)
    {
        super(name, r, g, b);

        this.myRect = new Rect(left, top, right, bottom);
    }


    @Override
    public void drawMe(Canvas canvas)
    {
        canvas.drawRect(myRect, myPaint);  //main rectangle
    }

    @Override
    public boolean containsPoint(int x, int y)
    {

        //Want to check for a tap within a slightly larger rectangle
        int left = this.myRect.left - TAP_MARGIN;
        int top = this.myRect.top - TAP_MARGIN;
        int right = this.myRect.right + TAP_MARGIN;
        int bottom = this.myRect.bottom + TAP_MARGIN;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);
    }//contaisPoint


    @Override
    public int getSize() {
        return this.myRect.width() * this.myRect.height();
    }





}//class CustomRect
