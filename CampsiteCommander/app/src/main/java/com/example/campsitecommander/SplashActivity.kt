package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/**
 * SplashActivity - First screen shown when the app launches.
 * Displays the Campsite Commander logo and title for 3 seconds,
 * then navigates to the Main Screen.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Wait 3000ms (3 seconds) then transition to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close splash so user can't go back to it
        }, 3000)
    }
}
