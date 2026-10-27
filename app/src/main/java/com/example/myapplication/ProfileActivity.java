package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView profileName = findViewById(R.id.profile_name);
        TextView tvProfileEmail = findViewById(R.id.tvProfileEmail);
        TextView valName = findViewById(R.id.val_name);

        Button btnEditProfile = findViewById(R.id.btnEditProfile);
        Button btnBackLanding = findViewById(R.id.btnBackLanding);

        // Read Username Passed via Intent Extras
        if (getIntent() != null && getIntent().hasExtra("USER_NAME")) {
            String userName = getIntent().getStringExtra("USER_NAME");
            if (userName != null && !userName.isEmpty()) {
                profileName.setText(userName);
                if (valName != null) {
                    valName.setText(userName);
                }
                tvProfileEmail.setText(getString(R.string.profile_email_label, userName.toLowerCase().replaceAll("\\s+", "") + "@example.com"));
            }
        }

        btnEditProfile.setOnClickListener(v ->
                Toast.makeText(ProfileActivity.this, "Opening Edit Profile...", Toast.LENGTH_SHORT).show()
        );

        btnBackLanding.setOnClickListener(v -> finish());
    }

    // Click handler for Skill items in GridLayout
    public void onSkillClick(View view) {
        String skill = "";
        int id = view.getId();

        if (id == R.id.skill_android) {
            skill = "Android";
        } else if (id == R.id.skill_java) {
            skill = "Java";
        } else if (id == R.id.skill_kotlin) {
            skill = "Kotlin";
        } else if (id == R.id.skill_flutter) {
            skill = "Flutter";
        } else if (id == R.id.skill_react) {
            skill = "React Native";
        }

        Toast.makeText(this, "Skill selected: " + skill, Toast.LENGTH_SHORT).show();
    }
}