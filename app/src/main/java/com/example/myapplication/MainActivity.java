package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String username = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.landing_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Read intent extras passed from LoginActivity
        if (getIntent() != null && getIntent().hasExtra("USER_NAME")) {
            username = getIntent().getStringExtra("USER_NAME");
        }

        TextView tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        tvWelcomeUser.setText(getString(R.string.welcome_user, username));

        // Card Clicks - Main Features
        CardView cardProfile = findViewById(R.id.cardProfile);
        CardView cardSettings = findViewById(R.id.cardSettings);
        CardView cardMessages = findViewById(R.id.cardMessages);
        CardView cardAnalytics = findViewById(R.id.cardAnalytics);
        CardView cardNotifications = findViewById(R.id.cardNotifications);
        CardView cardHelp = findViewById(R.id.cardHelp);
        Button btnLogout = findViewById(R.id.btnLogout);

        // Feature 1: Navigate to Profile Screen
        cardProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("USER_NAME", username);
            startActivity(intent);
        });

        // Feature 2: Settings
        cardSettings.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Settings feature selected", Toast.LENGTH_SHORT).show()
        );

        // Feature 3: Messages
        cardMessages.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Messages feature selected", Toast.LENGTH_SHORT).show()
        );

        // Feature 4: Analytics
        cardAnalytics.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Analytics feature selected", Toast.LENGTH_SHORT).show()
        );

        // Feature 5: Notifications
        cardNotifications.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Notifications feature selected", Toast.LENGTH_SHORT).show()
        );

        // Feature 6: Help
        cardHelp.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Help & Support selected", Toast.LENGTH_SHORT).show()
        );

        // Logout Action Event
        btnLogout.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}