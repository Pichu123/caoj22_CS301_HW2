package edu.up.cs371.caoj22.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * <!-- class MainActivity-->
 *
 * This class initializes a user interface that contains a
 * custom drawing with six modifiable elements
 *
 * @author <Justin Cao>
 */
public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
