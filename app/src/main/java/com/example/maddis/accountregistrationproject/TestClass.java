package com.example.maddis.accountregistrationproject;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;

/**
 * Created by Maddis on 2017-12-16.
 */

public class TestClass extends RegistrationField {

    public TestClass(Context context, String fieldName, boolean isRequired, String inputType) {
        super(context, fieldName, isRequired, inputType);

        setValidColor(Color.CYAN);
        setInvalidColor(Color.BLUE);
    }
}
