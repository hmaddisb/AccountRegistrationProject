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

    AccountForm accountForm;
    Button register;
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

        //kanske är något sånt här som de vill att man ska kunna göra
        TextView customText = new TextView(this);
        customText.setText("My own custom field");
        customText.setTextSize(20);
        customText.setGravity(Gravity.CENTER);
        accountForm.addCustomField(customText);

        ImageView view = new ImageView(this);
        view.setImageResource(R.drawable.mh);

        accountForm.addCustomField(view);


        TestClass t = new TestClass(this, "Pet", true, accountForm.textType);
        accountForm.addRegistrationField(t);
        /////////////////////////////////////////////////////////////


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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                accountForm.checkRegistration();
            }
        });
    }
}
