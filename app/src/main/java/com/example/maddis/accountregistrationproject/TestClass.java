package com.example.maddis.accountregistrationproject;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by Maddis on 2017-12-16.
 */

/**
 * Test class to change how a registration field looks
 */
public class TestClass extends RegistrationField {

    public TestClass(Context context, String fieldName, boolean isRequired, String inputType) {
        super(context, fieldName, isRequired, inputType);

        TextView t = new TextView(context);
        t.setText("HEEEEEEEEEEEELLO");
        addView(t);
        setValidColor(Color.CYAN);
        setInvalidColor(Color.BLUE);
    }
}
