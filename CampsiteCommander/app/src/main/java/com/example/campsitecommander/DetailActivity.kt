package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * DetailActivity
 * Displays the full gear list with all details: Item, Category, Quantity, and Comments.
 * Reads data from the parallel arrays in DataManager using a loop.
 * Provides a "Back to Base" button to return to the Main Screen.
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var llGearContainer: LinearLayout
    private lateinit var btnBackToBase: Button
    private lateinit var tvGearCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Link UI components
        llGearContainer = findViewById(R.id.llGearContainer)
        btnBackToBase = findViewById(R.id.btnBackToBase)
        tvGearCount = findViewById(R.id.tvGearCount)

        // Display all gear items by reading from parallel arrays
        displayAllGearItems()

        // "Back to Base" navigation button returns to MainActivity
        btnBackToBase.setOnClickListener {
            finish()
        }
    }

    /**
     * Loops through all parallel arrays and dynamically creates a card-style
     * TextView for each gear item, displaying all its details.
     */
    private fun displayAllGearItems() {
        val itemCount = DataManager.getItemCount()

        // Show how many unique items are in the list
        tvGearCount.text = "📋 ${itemCount} Items in your pack"

        // Loop through each index of the parallel arrays
        for (i in 0 until itemCount) {

            // Retrieve data from each parallel array at the same index
            val name = DataManager.itemNames[i]
            val category = DataManager.itemCategories[i]
            val quantity = DataManager.itemQuantities[i]
            val comments = DataManager.itemComments[i]

            // Create a TextView card for this gear item
            val itemView = TextView(this)
            itemView.text = """
                🏕️ $name
                📂 Category: $category
                🔢 Quantity: $quantity
                📝 Notes: $comments
            """.trimIndent()

            // Style the item card
            itemView.textSize = 15f
            itemView.setTextColor(ContextCompat.getColor(this, R.color.text_primary))
            itemView.setBackgroundResource(R.drawable.item_card_background)
            itemView.setPadding(32, 24, 32, 24)

            // Add spacing between cards using layout params
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 20)
            itemView.layoutParams = params

            // Add the card to the scroll container
            llGearContainer.addView(itemView)
        }

        // Show a message if no items exist
        if (itemCount == 0) {
            val emptyView = TextView(this)
            emptyView.text = "No gear added yet. Go add some gear!"
            emptyView.textSize = 16f
            emptyView.setTextColor(ContextCompat.getColor(this, R.color.text_secondary))
            llGearContainer.addView(emptyView)
        }
    }
}
