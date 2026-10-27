package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFullName;
    private EditText etEmail;
    private EditText etRegPassword;
    private RadioGroup rgGender;
    private CheckBox cbSkillAndroid;
    private CheckBox cbSkillJava;
    private CheckBox cbSkillKotlin;
    private CheckBox cbSkillFlutter;
    private CheckBox cbSkillReact;
    private EditText etCustomSkills;
    private CheckBox cbTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etRegPassword = findViewById(R.id.etRegPassword);
        rgGender = findViewById(R.id.rgGender);

        cbSkillAndroid = findViewById(R.id.cbSkillAndroid);
        cbSkillJava = findViewById(R.id.cbSkillJava);
        cbSkillKotlin = findViewById(R.id.cbSkillKotlin);
        cbSkillFlutter = findViewById(R.id.cbSkillFlutter);
        cbSkillReact = findViewById(R.id.cbSkillReact);
        etCustomSkills = findViewById(R.id.etCustomSkills);

        cbTerms = findViewById(R.id.cbTerms);

        Button btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit);
        TextView tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);

        // Form Validation and Registration Action Event
        btnRegisterSubmit.setOnClickListener(v -> {
            String fullName = etFullName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etRegPassword.getText().toString().trim();
            int selectedGenderId = rgGender.getCheckedRadioButtonId();

            // Collect Selected Skills
            List<String> selectedSkills = new ArrayList<>();
            if (cbSkillAndroid.isChecked()) selectedSkills.add("Android");
            if (cbSkillJava.isChecked()) selectedSkills.add("Java");
            if (cbSkillKotlin.isChecked()) selectedSkills.add("Kotlin");
            if (cbSkillFlutter.isChecked()) selectedSkills.add("Flutter");
            if (cbSkillReact.isChecked()) selectedSkills.add("React Native");

            String customSkills = etCustomSkills.getText().toString().trim();
            if (!customSkills.isEmpty()) {
                selectedSkills.add(customSkills);
            }

            if (fullName.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please enter your full name", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
            } else if (selectedGenderId == -1) {
                Toast.makeText(RegisterActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
            } else if (selectedSkills.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please select at least one technical skill", Toast.LENGTH_SHORT).show();
            } else if (!cbTerms.isChecked()) {
                Toast.makeText(RegisterActivity.this, "Please accept Terms & Conditions", Toast.LENGTH_SHORT).show();
            } else {
                String skillsString = String.join(", ", selectedSkills);
                Toast.makeText(RegisterActivity.this, "Registered with skills: " + skillsString, Toast.LENGTH_LONG).show();

                // Explicit Intent back to LoginActivity passing registered user details
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("REGISTERED_USER", email);
                intent.putExtra("USER_SKILLS", skillsString);
                startActivity(intent);
                finish();
            }
        });

        // Intent Navigation back to Login Screen
        tvAlreadyAccount.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}