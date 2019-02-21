package edu.up.cs371.caoj22.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * <!-- class MainActivity-->
 *
 * This class initializes a user interface that contains
 * three SeekBars to edit the red, green, blue values
 * of any currently selected element.
 * It also initializes the Controller and SurfaceView
 * with event listeners
 * @author <Justin Cao>
 */
public class MainActivity extends AppCompatActivity
{
    /**
     * onCreate
     *Sets up graphical user interface to respond
     * to user inputs such as drag and touch
     *which will modify red, green, and blue
     *values of selected elements
     *
     * @param savedInstanceState contains the activity's previously
     *                           saved state
     *
     * @return null
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Locates the widgets from the XML layout to be modified later on
        TextView elementName = findViewById(R.id.curElementName);

        TextView elementRedValue = findViewById(R.id.elementRedValue);
        SeekBar redSeekBar = findViewById(R.id.elementRedModifier);

        TextView elementGreenValue = findViewById(R.id.elementGreenValue);
        SeekBar greenSeekBar = findViewById(R.id.elementGreenModifier);

        TextView elementBlueValue = findViewById(R.id.elementBlueValue);
        SeekBar blueSeekBar = findViewById(R.id.elementBlueModifier);

        CustomDrawingSurface drawingSurface = findViewById(R.id.customSurface);

        //Creates a controller that will use previously define widgets
        // and listen to all types of user inputs and respond accordingly
        Controller widgetController = new Controller(elementName,
                redSeekBar, greenSeekBar,
                blueSeekBar, elementRedValue,
                elementGreenValue, elementBlueValue, drawingSurface);
        /**
         External Citation
         Date: 19 February 2019
         Problem: Couldn't figure out how to set SeekBar listeners for this class
         Resource:
         Week 5: Populating a Spinner and Controller class example File
         Solution: I used the example code from the Controller.java file
         */
        drawingSurface.setOnTouchListener(widgetController);
        redSeekBar.setOnSeekBarChangeListener(widgetController);
        greenSeekBar.setOnSeekBarChangeListener(widgetController);
        blueSeekBar.setOnSeekBarChangeListener(widgetController);
    }
}
