package com.example.maddis.accountregistrationproject;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //the complete account registration form
    AccountForm accountForm;

    //the button you use to try to register
    Button register;

    //the title of the account registration form
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        title.setText("Register your account");

        accountForm = findViewById(R.id.accoundForm);
        register = findViewById(R.id.registerButton);
        register.setText("Register!");

        /*
        This is two custom fields that we have used to show that you can change
        how the registration form looks
        */
        TextView customText = new TextView(this);
        customText.setText("My own custom field");
        customText.setTextSize(20);
        customText.setGravity(Gravity.CENTER);
        accountForm.addCustomField(customText);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.mh);
        accountForm.addCustomField(imageView);

        /*
        A test class to show that you can override methods and still add it as a registration field
        component to account registration
         */
        TestClass t = new TestClass(this, "Pet", true, accountForm.textType);
        accountForm.addRegistrationField(t);

        //The fields that have been initialized to the account form
        RegistrationField firstName = new RegistrationField(this, "Full name", true, accountForm.textType);
        //RegistrationField lastName = new RegistrationField(this, "Last name", true, accountForm.textType);
        RegistrationField password = new RegistrationField(this, "Password", true, accountForm.passwordType);
        RegistrationField email = new RegistrationField(this, "Email", true, accountForm.emailType);
        //RegistrationField telephone = new RegistrationField(this, "Telephone", false, accountForm.numberType);

        accountForm.addRegistrationField(firstName);
       // accountForm.addRegistrationField(lastName);
        accountForm.addRegistrationField(password);
        accountForm.addRegistrationField(email);
       // accountForm.addRegistrationField(telephone);

        //a click listener to check if the registration is correct
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                accountForm.checkRegistration();
            }
        });
    }
}
