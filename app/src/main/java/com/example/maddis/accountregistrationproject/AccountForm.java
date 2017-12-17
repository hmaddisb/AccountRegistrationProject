package com.example.maddis.accountregistrationproject;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Maddis on 2017-12-16.
 */

/**
 * The class for the complete account registration form
 */
public class AccountForm extends LinearLayout {

    Context context;

    /*
    used to check if all the required fields are correctly filled after
     clicking the register button
     */
    boolean validRegistration;

    /*
    an arraylist with all the fields
     */
    private ArrayList<RegistrationField> registrationFields;

    /*
    short commands to tell which kind of input the user wants to have when initializing
    a new registration field
     */
    String textType = "text";
    String passwordType = "password";
    String emailType = "email";
    String numberType = "number";
    String dateType = "date";

    /*
    toast messages that shows when the register button is clicked
     */
    String validRegistrationMessage = "Registration complete!";
    String invalidRegistrationMessage = "Something went wrong with your registration.\n" +
                                        "Please check fields marked with a *";

    public AccountForm(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;

        setOrientation(VERTICAL);
        validRegistration = false;
        registrationFields = new ArrayList<>();
    }

    /**
     * iterates over all the fields in the list of registration fields
     * and checks if the field is correctly filled/not required
     */
    public void checkRegistration()
    {
        for(RegistrationField field: registrationFields)
        {
            if(field.isRequired && !field.isValidField())
            {
                showRegistrationMessage(invalidRegistrationMessage);
                validRegistration = false;
                break;
            }
            else
                validRegistration = true;
        }

        if(validRegistration)
        {
            showRegistrationMessage(validRegistrationMessage);
            setCompleteRegistration();
        }
    }

    /**
     * if a registration is okay, it iterates over all the fields and empties
     * all the input and sets the background color to the default color
     */
    public void setCompleteRegistration()
    {
        for(RegistrationField field: registrationFields)
        {
            field.resetField();
            field.editText.setBackgroundColor(field.getDefaultColor());

        }
    }

    /**
     * adds a new field to the account registration form
     * @param field the registration field to be added to the registration form
     */
    public void addRegistrationField(RegistrationField field)
    {
        addView(field);
        registrationFields.add(field);
    }

    /**
     * shows a toast message whether a registration was successful or not
     * @param msg the message to be shown
     */
    public void showRegistrationMessage(String msg)
    {
        Toast t = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 0, -200);
        ViewGroup group = (ViewGroup) t.getView();
        TextView view = (TextView) group.getChildAt(0);
        view.setTextSize(20);
        t.show();

    }

    /**
     * if a user wants to add a view/field to the form that is not
     * of the same kind as the registration field
     * @param customField the view to be added to the form
     */
    public void addCustomField(View customField)
    {
        addView(customField);
    }

    public boolean isValidRegistration() {
        return validRegistration;
    }

    public void setValidRegistration(boolean validRegistration) {
        this.validRegistration = validRegistration;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    public String getPasswordType() {
        return passwordType;
    }

    public void setPasswordType(String passwordType) {
        this.passwordType = passwordType;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getValidRegistrationMessage() {
        return validRegistrationMessage;
    }

    public void setValidRegistrationMessage(String validRegistrationMessage) {
        this.validRegistrationMessage = validRegistrationMessage;
    }

    public String getInvalidRegistrationMessage() {
        return invalidRegistrationMessage;
    }

    public void setInvalidRegistrationMessage(String invalidRegistrationMessage) {
        this.invalidRegistrationMessage = invalidRegistrationMessage;
    }
}
