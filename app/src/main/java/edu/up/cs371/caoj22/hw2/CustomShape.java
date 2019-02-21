package edu.up.cs371.caoj22.hw2;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * <!-- class CustomShape -->
 *
 * This class defines a shape of a drawing. All such elements must have
 * certain methods and variables to work with this app.
 *
 * @author Andrew Nuxoll
 * @version Spring 2015
 *
 * @author Justin Cao
 * @version Spring 2019
 *
 */
public abstract class CustomShape {

    /**
     * this is the "fudge factor" for determining whether a tap falls within a
     * given shape. The value is specified in display pixels (dp)
     */
    public static final int TAP_MARGIN = 10;

    /** This defines the main color that the element will be drawn with */
    protected Paint myPaint = new Paint();

    /** a random number generator for changing to a random color */
    protected Random myRand = new Random();

    protected int red, green, blue;
    /**
     * This gives the element a name for identification. This need not be unique
     * but it's helpful
     */
    protected String myName = "$NO NAME$";

    /** the ctor requires that you give the object a name and a color */
    public CustomShape(String name, int r, int g, int b) {
        // init instance variables
        red = r;
        green = g;
        blue = b;
        int color = Color.rgb(red,green,blue);
        setColor(color);
        this.myName = name;

    }

    /** get the element's given name */
    public String getName() {
        return this.myName;
    }

    /** change the color */
    public void setColor(int color) {

        // ignore request if it's not a new color (this keeps the undo queue
        // clean)
        if (color == myPaint.getColor())
            return;

        // make the change
        this.myPaint.setColor(color);
    }

    /** get the color */
    public int getColor() {
        return this.myPaint.getColor();
    }

    /** switch to a random color */
    public void setRandomColor() {
        int randColor = Color.rgb(myRand.nextInt(256), myRand.nextInt(256),
                myRand.nextInt(256));
        setColor(randColor);
    }

    /*
     * ===================================================================
     * Abstract Methods
     * -------------------------------------------------------------------
     */

    /** an element must be able to paint itself */
    public abstract void drawMe(Canvas canvas);

    /**
     * an element must be able to tell whether a given x,y coordinate falls
     * within the bounds of its shape. This is used for tap purposes so a tap
     * that is close to being inside should still count. Use the TAP_MARGIN
     * constant as a guide for fudge factor.
     */
    public abstract boolean containsPoint(int x, int y);

    /** an element must be able to determine its approximate area */
    public abstract int getSize();


}// class CustomElement

