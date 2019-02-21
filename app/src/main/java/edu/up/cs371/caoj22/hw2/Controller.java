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
 * This class keeps track of user input changing the values of
 * a currently selected element's red, green, blue values and
 * sends this data to the CustomDrawingSurface class for the
 * view to be updated.
 * @author <Justin Cao>
 */
public class Controller implements
        SeekBar.OnSeekBarChangeListener,
        View.OnTouchListener
{
    private TextView elementName;

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    private TextView elementRedValue;
    private TextView elementGreenValue;
    private TextView elementBlueValue;

    private CustomDrawingSurface drawingSurface;
    private CustomShape currentElement;
    private ArrayList<CustomShape> shapeList;
    /**
     External Citation
     Date: 19 February 2019
     Problem: Couldn't figure out how to set SeekBar listeners for this class
     Resource:
        Week 5: Populating a Spinner and Controller class example File
     Solution: I used the example code from the Controller.java file
     */
    public Controller(TextView curName, SeekBar redSB, SeekBar greenSB, SeekBar blueSB,
                      TextView redText, TextView greenText, TextView blueText, CustomDrawingSurface drawing)
    {
        elementName = curName;

        redSeekBar = redSB;
        greenSeekBar = greenSB;
        blueSeekBar = blueSB;

        elementRedValue = redText;
        elementGreenValue = greenText;
        elementBlueValue = blueText;

        drawingSurface = drawing;
        init();

    }
    private void init()
    {
        elementName.setText("Select an object");
        elementRedValue.setText("Red: ");
        elementGreenValue.setText("Green: ");
        elementBlueValue.setText("Blue: ");
        redSeekBar.setProgress(0);
        greenSeekBar.setProgress(0);
        blueSeekBar.setProgress(0);

        shapeList = drawingSurface.getShapeList();

    }
    /**
     External Citation
     Date: 20 February 2019
     Problem: Couldn't figure out how to set the touch listeners
     and allow the user to use onDraw() for each constructor.
     Resource:
     Week 5: Touch Events Code
     Solution: I used the example code from the BeefJerky.java file
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int xTouch = (int) event.getX();
        int yTouch = (int) event.getY();
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
    @Override
    public void onProgressChanged(SeekBar seekBar,
                                  int progress, boolean fromUser)
    {
        if(currentElement != null) {
            if (seekBar == redSeekBar) {
                elementRedValue.setText("Red: " + progress);
                currentElement.red = progress;
            } else if (seekBar == greenSeekBar) {
                elementGreenValue.setText("Green: " + progress);
                currentElement.green = progress;
            } else if (seekBar == blueSeekBar) {
                elementBlueValue.setText("Blue: " + progress);
                currentElement.blue = progress;
            }
            currentElement.setColor(Color.rgb(currentElement.red, currentElement.green, currentElement.blue));
            drawingSurface.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }

}
