package edu.up.cs371.caoj22.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * <!-- class CustomDrawingSurface-->
 *
 * This class initializes a user interface that contains
 * six custom elements that can be selected through
 * touch
 * @author <Justin Cao>
 */
public class CustomDrawingSurface extends SurfaceView
{
    private CustomCircle smallCircle;
    private CustomCircle mediumCircle;
    private CustomCircle largeCircle;
    private CustomRect square;
    private CustomRect tallRectangle;
    private CustomRect wideRectangle;
    private ArrayList<CustomShape> shapeList = new ArrayList<>();

    public CustomDrawingSurface(Context context)
    {
        super(context);
        init();
    }
    public CustomDrawingSurface(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public CustomDrawingSurface(Context context,
                                AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
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
    private void init()
    {
        setWillNotDraw(false);
        setBackgroundColor(0Xffffffff);
        smallCircle = new CustomCircle("Small Circle",
                255,0,0, 200, 200, 50);
        mediumCircle = new CustomCircle("Medium Circle",
                255,255,0, 1250, 200, 150);
        largeCircle = new CustomCircle("Large Circle",
                241,125,0, 300, 600, 300);
        square = new CustomRect("Square",
               255,0,255, 600, 100, 800, 300);
        tallRectangle = new CustomRect("Tall Rectangle",
                123,123,255, 700, 400, 900, 800);
        wideRectangle = new CustomRect("Wide Rectangle",
                123,0,115, 1000, 700, 1400, 900);
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

    @Override
    protected void onDraw(Canvas canvas) {
        smallCircle.drawMe(canvas);
        mediumCircle.drawMe(canvas);
        largeCircle.drawMe(canvas);
        square.drawMe(canvas);
        tallRectangle.drawMe(canvas);
        wideRectangle.drawMe(canvas);


    }

}
