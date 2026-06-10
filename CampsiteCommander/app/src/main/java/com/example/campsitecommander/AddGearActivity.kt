package com.example.campsitecommander

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

/**
 * AddGearActivity - Screen for adding a new gear item.
 * Collects: Item Name, Category (Spinner), Quantity, and Comments.
 * Validates all inputs before saving to the parallel arrays via GearData.
 */
class AddGearActivity : AppCompatActivity() {

    private lateinit var etItemName: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var etQuantity: EditText
    private lateinit var etComments: EditText
    private lateinit var btnSaveGear: Button
    private lateinit var btnBack: Button

    // Available categories for the spinner
    private val categories = arrayOf(
        "Shelter", "Food", "Safety", "First Aid",
        "Cooking", "Hydration", "Navigation", "Other"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_gear)

        // Bind views
        etItemName = findViewById(R.id.etItemName)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        etQuantity = findViewById(R.id.etQuantity)
        etComments = findViewById(R.id.etComments)
        btnSaveGear = findViewById(R.id.btnSaveGear)
        btnBack = findViewById(R.id.btnBackFromAdd)

        // Set up the category spinner with the categories array
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        // Save gear item with validation
        btnSaveGear.setOnClickListener {
            saveGearItem()
        }

        // Go back to Main Screen
        btnBack.setOnClickListener {
            finish()
        }
    }

    /**
     * Validates input fields and saves the new item to GearData's parallel arrays.
     * Provides user feedback via Toast messages for errors.
     */
    private fun saveGearItem() {
        val name = etItemName.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()
        val quantityText = etQuantity.text.toString().trim()
        val comment = etComments.text.toString().trim()

        // --- Input Validation / Error Handling ---
        if (name.isEmpty()) {
            etItemName.error = "Please enter an item name"
            etItemName.requestFocus()
            return
        }

        if (quantityText.isEmpty()) {
            etQuantity.error = "Please enter a quantity"
            etQuantity.requestFocus()
            return
        }

        val quantity = quantityText.toIntOrNull()
        if (quantity == null || quantity <= 0) {
            etQuantity.error = "Quantity must be a positive number"
            etQuantity.requestFocus()
            return
        }

        // All validation passed — add to parallel arrays
        GearData.addItem(name, category, quantity, comment)

        Toast.makeText(this, "✅ $name added to your pack!", Toast.LENGTH_SHORT).show()

        // Return to Main Screen after saving
        finish()
    }
}
