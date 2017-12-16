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

public class AccountForm extends LinearLayout {

    Context context;

    boolean validRegistration;

    private ArrayList<RegistrationField> registrationFields;

    String textType = "text";
    String passwordType = "password";
    String emailType = "email";
    String numberType = "number";
    String dateType = "date";

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

    public void setCompleteRegistration()
    {
        for(RegistrationField field: registrationFields)
        {
            field.resetField();
            field.editText.setBackgroundColor(field.getDefaultColor());

        }
    }

    public void addRegistrationField(RegistrationField field)
    {
        addView(field);
        registrationFields.add(field);
    }

    public void showRegistrationMessage(String msg)
    {
        Toast t = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 0, -200);
        ViewGroup group = (ViewGroup) t.getView();
        TextView view = (TextView) group.getChildAt(0);
        view.setTextSize(20);
        t.show();

    }

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
