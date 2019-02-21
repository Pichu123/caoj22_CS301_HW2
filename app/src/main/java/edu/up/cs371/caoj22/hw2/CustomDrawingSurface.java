package edu.up.cs371.caoj22.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * <!-- class CustomDrawingSurface-->
 *
 * This class initializes
 * six custom elements that re-draws when needed.
 * @author <Justin Cao>
 */
public class CustomDrawingSurface extends SurfaceView
{
    //These constants will be used to instantiate the CustomShape objects
    //and are properties of those elements
    private static final int DRAWING_BACKGROUND_COLOR = 0Xffffffff;

    private CustomCircle smallCircle;
    private static final int SMALL_CIRCLE_RED = 255;
    private static final int SMALL_CIRCLE_GREEN = 0;
    private static final int SMALL_CIRCLE_BLUE = 0;
    private static final int SMALL_CIRCLE_X = 200;
    private static final int SMALL_CIRCLE_Y = 200;
    private static final int SMALL_CIRCLE_RADIUS = 50;

    private CustomCircle mediumCircle;
    private static final int MEDIUM_CIRCLE_RED = 255;
    private static final int MEDIUM_CIRCLE_GREEN = 255;
    private static final int MEDIUM_CIRCLE_BLUE = 0;
    private static final int MEDIUM_CIRCLE_X = 1250;
    private static final int MEDIUM_CIRCLE_Y = 200;
    private static final int MEDIUM_CIRCLE_RADIUS = 150;

    private CustomCircle largeCircle;
    private static final int LARGE_CIRCLE_RED = 241;
    private static final int LARGE_CIRCLE_GREEN = 125;
    private static final int LARGE_CIRCLE_BLUE = 0;
    private static final int LARGE_CIRCLE_X = 300;
    private static final int LARGE_CIRCLE_Y = 600;
    private static final int LARGE_CIRCLE_RADIUS = 300;

    private CustomRect square;
    private static final int SQUARE_RED = 255;
    private static final int SQUARE_GREEN = 0;
    private static final int SQUARE_BLUE = 255;
    private static final int SQUARE_LEFT = 600;
    private static final int SQUARE_TOP = 100;
    private static final int SQUARE_RIGHT = 800;
    private static final int SQUARE_BOTTOM = 300;


    private CustomRect tallRectangle;
    private static final int TALL_RECT_RED = 123;
    private static final int TALL_RECT_GREEN = 123;
    private static final int TALL_RECT_BLUE = 255;
    private static final int TALL_RECT_LEFT = 700;
    private static final int TALL_RECT_TOP = 400;
    private static final int TALL_RECT_RIGHT = 900;
    private static final int TALL_RECT_BOTTOM = 800;

    private CustomRect wideRectangle;
    private static final int WIDE_RECT_RED = 123;
    private static final int WIDE_RECT_GREEN = 0;
    private static final int WIDE_RECT_BLUE = 115;
    private static final int WIDE_RECT_LEFT = 1000;
    private static final int WIDE_RECT_TOP = 700;
    private static final int WIDE_RECT_RIGHT = 1400;
    private static final int WIDE_RECT_BOTTOM = 900;

    private ArrayList<CustomShape> shapeList = new ArrayList<>();

    public CustomDrawingSurface(Context context)
    {
        super(context);
        initializeDrawing();
    }
    public CustomDrawingSurface(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeDrawing();
    }

    public CustomDrawingSurface(Context context,
                                AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initializeDrawing();
    }
    /**
     External Citation
     Date: 20 February 2019
     Problem: Couldn't figure out how to set the surface view background
                color
     Resource:
     https://stackoverflow.com/questions/15277140/set-background-color-of-surface-view
     Solution: I used the example code from this post
     */

    /**
     * initializeDrawing
     *
     * Adds six shapes to the drawing surface and
     * stores them in a list to be accessed within the
     * Controller class
     *
     * @return null
     */
    private void initializeDrawing()
    {
        //Defines properties of each shape then is stored
        //for future reference in the Controller class
        setWillNotDraw(false);
        setBackgroundColor(DRAWING_BACKGROUND_COLOR);
        smallCircle = new CustomCircle("Small Circle",
                SMALL_CIRCLE_RED, SMALL_CIRCLE_GREEN, SMALL_CIRCLE_BLUE
                ,SMALL_CIRCLE_X, SMALL_CIRCLE_Y, SMALL_CIRCLE_RADIUS);
        mediumCircle = new CustomCircle("Medium Circle",
                MEDIUM_CIRCLE_RED,MEDIUM_CIRCLE_GREEN,MEDIUM_CIRCLE_BLUE
                ,MEDIUM_CIRCLE_X, MEDIUM_CIRCLE_Y, MEDIUM_CIRCLE_RADIUS);
        largeCircle = new CustomCircle("Large Circle",
                LARGE_CIRCLE_RED, LARGE_CIRCLE_GREEN, LARGE_CIRCLE_BLUE
                ,LARGE_CIRCLE_X, LARGE_CIRCLE_Y, LARGE_CIRCLE_RADIUS);
        square = new CustomRect("Square",
               SQUARE_RED, SQUARE_GREEN, SQUARE_BLUE,
                SQUARE_LEFT,SQUARE_TOP,SQUARE_RIGHT,SQUARE_BOTTOM);
        tallRectangle = new CustomRect("Tall Rectangle",
                TALL_RECT_RED,TALL_RECT_GREEN,TALL_RECT_BLUE,
                TALL_RECT_LEFT,TALL_RECT_TOP,TALL_RECT_RIGHT,
                TALL_RECT_BOTTOM);
        wideRectangle = new CustomRect("Wide Rectangle",
                WIDE_RECT_RED,WIDE_RECT_GREEN,WIDE_RECT_BLUE,
                WIDE_RECT_LEFT,WIDE_RECT_TOP,WIDE_RECT_RIGHT,
                WIDE_RECT_BOTTOM);

        shapeList.add(smallCircle);
        shapeList.add(mediumCircle);
        shapeList.add(largeCircle);
        shapeList.add(square);
        shapeList.add(tallRectangle);
        shapeList.add(wideRectangle);

    }

    public ArrayList<CustomShape> getShapeList()
    {
        return shapeList;
    }

    /**
     * onDraw
     *
     * Adds six shapes to the drawing surface and
     * stores them in a list to be accessed within the
     * Controller class
     *
     * CAVEAT: This method can be simplified with a for each loop (see onTouch()
     *          in the Controller class)
     *
     * @param canvas the canvas on which the background will be drawn
     *
     * @return null
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        smallCircle.drawMe(canvas);
        mediumCircle.drawMe(canvas);
        largeCircle.drawMe(canvas);
        square.drawMe(canvas);
        tallRectangle.drawMe(canvas);
        wideRectangle.drawMe(canvas);
    }

}
