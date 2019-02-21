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
 * of any currently selected element
 * @author <Justin Cao>
 */
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView elementName = findViewById(R.id.curElementName);

        TextView elementRedValue = findViewById(R.id.elementRedValue);
        SeekBar redSeekBar = findViewById(R.id.elementRedModifier);

        TextView elementGreenValue = findViewById(R.id.elementGreenValue);
        SeekBar greenSeekBar = findViewById(R.id.elementGreenModifier);

        TextView elementBlueValue = findViewById(R.id.elementBlueValue);
        SeekBar blueSeekBar = findViewById(R.id.elementBlueModifier);

        CustomDrawingSurface drawingSurface = findViewById(R.id.customSurface);
        Controller widgetController = new Controller(elementName, redSeekBar, greenSeekBar,
                blueSeekBar, elementRedValue, elementGreenValue, elementBlueValue, drawingSurface);

        drawingSurface.setOnTouchListener(widgetController);
        redSeekBar.setOnSeekBarChangeListener(widgetController);
        greenSeekBar.setOnSeekBarChangeListener(widgetController);
        blueSeekBar.setOnSeekBarChangeListener(widgetController);
    }
}
