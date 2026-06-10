package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - The main hub of the app.
 * Shows total items packed (calculated via loop) and provides
 * navigation to Add Gear and Detailed View screens.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var tvTotalItems: TextView
    private lateinit var btnAddGear: Button
    private lateinit var btnViewGear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        tvTotalItems = findViewById(R.id.tvTotalItems)
        btnAddGear = findViewById(R.id.btnAddGear)
        btnViewGear = findViewById(R.id.btnViewGear)

        // Navigate to Add Gear screen
        btnAddGear.setOnClickListener {
            val intent = Intent(this, AddGearActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Detailed View screen
        btnViewGear.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * onResume is called every time this screen becomes visible.
     * This ensures the total updates after adding new gear items.
     */
    override fun onResume() {
        super.onResume()
        updateTotalDisplay()
    }

    /**
     * Updates the total items packed text using GearData's loop function.
     */
    private fun updateTotalDisplay() {
        val total = GearData.getTotalItemsPacked()
        val count = GearData.getItemCount()
        tvTotalItems.text = "🎒 Total Items Packed: $total\n(across $count gear entries)"
    }
}
