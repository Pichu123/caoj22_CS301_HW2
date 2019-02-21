package edu.up.cs371.caoj22.hw2;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * <!-- class Controller-->
 *
 * This class keeps track of user input that determines
 * what element is selected and changes its color values.
 * It sends this data to the CustomDrawingSurface class for the
 * drawing to be updated.
 * @author <Justin Cao>
 */
public class Controller implements
        SeekBar.OnSeekBarChangeListener,
        View.OnTouchListener
{
    //These instance variables store the widgets found from the MainActivity class
    private TextView elementName;

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    private TextView elementRedValue;
    private TextView elementGreenValue;
    private TextView elementBlueValue;

    //This variable is used to notify CustomDrawingSurface to repaint the canvas from within this class
    private CustomDrawingSurface drawingSurface;

    private CustomShape currentElement;
    private ArrayList<CustomShape> shapeList;

    public Controller(TextView curName, SeekBar redSB, SeekBar greenSB, SeekBar blueSB,
                      TextView redText, TextView greenText,
                      TextView blueText, CustomDrawingSurface drawing)
    {
        elementName = curName;

        redSeekBar = redSB;
        greenSeekBar = greenSB;
        blueSeekBar = blueSB;

        elementRedValue = redText;
        elementGreenValue = greenText;
        elementBlueValue = blueText;

        drawingSurface = drawing;
        shapeList = drawingSurface.getShapeList();
        initializeWidgets();
    }
    /**
     * initializeWidgets()
     *
     * Sets default values for the widgets since no
     * element is pre-selected when the app starts up
     *
     * @return null
     */
    private void initializeWidgets()
    {
        elementName.setText("Select an object");
        elementRedValue.setText("Red: ");
        elementGreenValue.setText("Green: ");
        elementBlueValue.setText("Blue: ");
        redSeekBar.setProgress(0);
        greenSeekBar.setProgress(0);
        blueSeekBar.setProgress(0);
    }
    /**
     External Citation
     Date: 20 February 2019
     Problem: Couldn't remember how to get the
            x & y coordinates of user touch input
     Resource:
     Week 5: Touch Events Code
     Solution: I used the example code from the BeefJerky.java file
     */

    /**
     * onTouch
     *
     * Checks if the user has touched an element
     * and proceeds to update the widgets to be able
     *to modify the selected element and show its current color values
     * @param v The view the touch event has been dispatched to.
     * @param event The MotionEvent object containing full information about the event.
     *
     * @return true if the listener has consumed the event, false otherwise.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int xTouch = (int) event.getX();
        int yTouch = (int) event.getY();

        //Updates the widgets to display the most recently
        //tapped element
        for(CustomShape c : shapeList)
        {
            if(c.containsPoint(xTouch,yTouch))
            {
                currentElement = c;
                elementName.setText(currentElement.myName);
                elementRedValue.setText("Red: " + currentElement.red);
                redSeekBar.setProgress(currentElement.red);
                elementGreenValue.setText("Green: " + currentElement.green);
                greenSeekBar.setProgress(currentElement.green);
                elementBlueValue.setText("Blue: " + currentElement.blue);
                blueSeekBar.setProgress(currentElement.blue);
            }
        }
        return true;
    }
    /**
     * onProgressChanged
     *
     * Whenever a seekbar is adjusted on a selected element,
     * the element's color will be updated and saved if
     * the element is tapped again at another time
     *
     * @param seekBar The SeekBar whose progress has changed
     * @param progress The current progress level.
     * @param  fromUser True if the progress change was initiated by the user.
     *
     * @return null
     */
    @Override
    public void onProgressChanged(SeekBar seekBar,
                                  int progress, boolean fromUser)
    {
        //Changes element color if at least one element has been selected after start up
        //The value displayed is also updated to match that of the current element
        if(currentElement != null)
        {
            if (seekBar == redSeekBar)
            {
                elementRedValue.setText("Red: " + progress);
                currentElement.red = progress;
            } else if (seekBar == greenSeekBar)
            {
                elementGreenValue.setText("Green: " + progress);
                currentElement.green = progress;
            } else if (seekBar == blueSeekBar)
            {
                elementBlueValue.setText("Blue: " + progress);
                currentElement.blue = progress;
            }
            currentElement.setColor(Color.rgb(currentElement.red,
                    currentElement.green, currentElement.blue));
            drawingSurface.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /* ignore */}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /* ignore */}

}
