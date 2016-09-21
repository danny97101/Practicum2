/**
 *  File: MainActivity.java
 *  Author: Danny Akimchuk
 *  Last Modified: September 6, 2016
 *  Purpose: To experiment with Android applications, using event listeners and handlers and using
 *      string constants and drawables.
 *  Algorithm:
 *      a) Inflate the Main Activity with the two text views
 *          and the buttons to toggle them.
 *      b) When one button is pressed, the respective text
 *          view should toggle.
 */

package com.example.akimchukdaniel.tutorial1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //The text box displaying Hello/Goodbye at the top
    //of the screen
    private TextView greetingTextView;

    //The text box displaying Hi/John Barr at the bottom
    //of the screen
    private TextView johnTextView;

    //True if greetingTextView shows "Hello" and false if
    //it shows "Goodbye"
    private boolean isHello;

    //True if johnTextView shows "Hi" and false if it
    //shows "John Barr"
    private boolean isHi;

    /**
     * Description: This function is called when the application is first run.
     *      It will inflate the main activity (the background, the two text
     *      views, the two buttons, and the image. Also sets OnClickListeners
     *      to the two buttons to toggle the text views when pressed.
     *
     * @param savedInstanceState
     *
     * Output: none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingTextView = (TextView) findViewById(R.id.textView);
        johnTextView = (TextView) findViewById(R.id.johnTextView);

        initializeGreeting();

        Button exclaimBtn = (Button) findViewById(R.id.button);
        exclaimBtn.setOnClickListener(toggleGreeting);

        Button johnBtn = (Button) findViewById(R.id.johnButton);
        johnBtn.setOnClickListener(toggleJohnButton);
    }

    /**
     * Description: Whenever the button is pressed, greetingTextView is toggled.
     *
     * Global variables used:
     *      isHello: used to determine if greetingTextView displays "Hello"
     *          or "Goodbye"
     */
    private final View.OnClickListener toggleGreeting = new View.OnClickListener() {
        public void onClick(View btn) {
            if (isHello) {
                isHello = false;
                greetingTextView.setText(R.string.goodbye);
            } else {
                isHello = true;
                greetingTextView.setText(R.string.hello);
            }
        }
    };

    /**
     * Description: Whenever the button is pressed, johnTextView is toggled.
     *
     * Global variables used:
     *      isHi: used to determine if johnTextView displays "Hi' or
     *          "John Barr"
     */
    private final View.OnClickListener toggleJohnButton = new View.OnClickListener() {
        public void onClick(View btn) {
            if (isHi) {
                isHi = false;
                johnTextView.setText(R.string.john);
                johnTextView.setTextColor(getResources().getColor(R.color.bright_pink));
            } else {
                isHi = true;
                johnTextView.setText(R.string.hi);
                johnTextView.setTextColor(getResources().getColor(R.color.pale_pink));
            }
        }
    };

    /**
     * Description: Initializes isHello and isHi to true, as the text views should
     *      display "Hello" and "Hi" respectively on creation.
     *
     * Global variables used:
     *      isHello: initialized to "Hello"
     *      isHi: initialized to "Hi"
     */
    private void initializeGreeting() {
        isHello = true;
        isHi = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
