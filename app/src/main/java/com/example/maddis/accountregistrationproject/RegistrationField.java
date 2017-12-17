package com.example.maddis.accountregistrationproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Maddis on 2017-12-16.
 */

/**
 * class for a registration field that can be initialied
 */
public class RegistrationField extends LinearLayout {

    Context context;
    String fieldName;
    String inputType;

    /*
    isRequired is used to set if a user needs to fill out this field or not
     */
    boolean isRequired;

    /*
    used to check if all fields that are required are filled in correctly
     */
    boolean validField = false;

    LinearLayout layout;

    /*
    text view to the left of a registration field
     */
    TextView textView;

    /*
    the edit text field to the left where the user can write its input
     */
    EditText editText;

    /*
    the different colors to
     */
    int validColor = Color.GREEN;
    int invalidColor = Color.RED;
    int defaultColor = Color.GRAY;

    public RegistrationField(Context context, String fieldName, boolean isRequired, String inputType)
    {
        super(context);
        this.context = context;
        this.fieldName = fieldName;
        this.isRequired = isRequired;
        this.inputType = inputType;
        layout = (LinearLayout) inflate(context, R.layout.new_registration_field, null);
        initializeField();
    }

    public void initializeField()
    {
        textView = layout.findViewById(R.id.fieldName);
        editText = layout.findViewById(R.id.fieldText);

        if (!isRequired)
        {
            editText.setBackgroundColor(defaultColor);
            textView.setText(fieldName + ":");
            validField = true;
        }
        else
        {
            textView.setText("*" + fieldName + ":");
            editText.setBackgroundColor(defaultColor);
        }

        if (inputType.toLowerCase().equals("text"))
            editText.setInputType(InputType.TYPE_CLASS_TEXT);

        else if (inputType.toLowerCase().equals("password"))
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        else if (inputType.toLowerCase().equals("email"))
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        else if (inputType.toLowerCase().equals("number"))
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        else if (inputType.toLowerCase().equals("date"))
            editText.setInputType(InputType.TYPE_DATETIME_VARIATION_TIME);

        watchText();
    }

    public void watchText()
    {
       editText.addTextChangedListener(new TextWatcher()
       {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable)
            {
                String checkInput = editable.toString();

                if(isRequired)
                    checkIfValidInput(checkInput);

                if(validField)
                    editText.setBackgroundColor(validColor);

                else
                    editText.setBackgroundColor(invalidColor);
            }
        });
        addView(layout);
    }

    public void checkIfValidInput(String checkInput)
    {

        if(inputType.equals("text"))
        {
            if(checkInput.length() >= 2)validField = true;

            else validField = false;
        }
        else if(inputType.equals("password"))
        {
            if(checkInput.length() > 5) validField = true;

            else validField = false;
        }
        else if(inputType.equals("email"))
        {
            if(checkInput.contains("@")) validField = true;

            else validField = false;
        }
        else if(inputType.equals("number"))
        {
            if(checkInput.length() >= 1) validField = true;

            else validField = false;
        }
        else if(inputType.equals("date"))
        {
            if(checkInput.length() > 2) validField = true;

            else validField = false;
        }
    }

    public void resetField()
    {
        editText.setText("");
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public boolean isValidField() {
        return validField;
    }

    public void setValidField(boolean validField) {
        this.validField = validField;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public LinearLayout getLayout() {
        return layout;
    }

    public void setLayout(LinearLayout layout) {
        this.layout = layout;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public int getValidColor() {
        return validColor;
    }

    public void setValidColor(int validColor) {
        this.validColor = validColor;
    }

    public int getInvalidColor() {
        return invalidColor;
    }

    public void setInvalidColor(int invalidColor) {
        this.invalidColor = invalidColor;
    }

    public int getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
    }
}
