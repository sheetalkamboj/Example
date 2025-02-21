package com.example.week2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPassword;
    private Button buttonSignup;
    private CheckBox checkBoxAgree;
    private Switch switchSubscribe;
    private RadioGroup radioGroupGender;
    private ImageButton imageButton;
    private ImageView imageViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignup = findViewById(R.id.buttonSignup);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        switchSubscribe = findViewById(R.id.switchSubscribe);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        imageButton = findViewById(R.id.imageButton);
        imageViewProfile = findViewById(R.id.imageViewProfile);

        // Sign Up Button Click Listener
        buttonSignup.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            // Check if terms are accepted
            if (!checkBoxAgree.isChecked()) {
                Toast.makeText(MainActivity.this, "Please agree to the terms", Toast.LENGTH_SHORT).show();
                return;
            }

            // Get selected gender
            int selectedId = radioGroupGender.getCheckedRadioButtonId();
            String gender = (selectedId == R.id.radioMale) ? "Male" : "Female";

            // Get subscription status
            boolean isSubscribed = switchSubscribe.isChecked();

            // Show SignUp info
            String message = "Name: " + name + "\nEmail: " + email + "\nGender: " + gender +
                    "\nSubscribed: " + (isSubscribed ? "Yes" : "No");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });

        // ImageButton Click - Show Image Width & Height
        imageButton.setOnClickListener(v -> {
            int width = imageViewProfile.getWidth();
            int height = imageViewProfile.getHeight();
            Toast.makeText(MainActivity.this, "Image Size: " + width + "x" + height, Toast.LENGTH_SHORT).show();
        });
    }
}
