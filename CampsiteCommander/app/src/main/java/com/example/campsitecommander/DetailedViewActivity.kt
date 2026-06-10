package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * DetailedViewActivity - Shows the full gear list with all details.
 * Loops through all parallel arrays to display:
 * Item Name, Category, Quantity, and Comments for each item.
 * Includes a "Back to Base" button to return to MainActivity.
 */
class DetailedViewActivity : AppCompatActivity() {

    private lateinit var containerGearList: LinearLayout
    private lateinit var btnBackToBase: Button
    private lateinit var tvGearCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        // Bind views
        containerGearList = findViewById(R.id.containerGearList)
        btnBackToBase = findViewById(R.id.btnBackToBase)
        tvGearCount = findViewById(R.id.tvGearCount)

        // Display all gear items by looping through arrays
        displayAllGear()

        // "Back to Base" navigation button - returns to Main Screen
        btnBackToBase.setOnClickListener {
            finish() // Pops DetailedViewActivity off the stack, revealing MainActivity
        }
    }

    /**
     * Loops through all parallel arrays and dynamically creates a card-style
     * view for each gear item, then adds it to the scroll container.
     */
    private fun displayAllGear() {
        val itemCount = GearData.getItemCount()
        tvGearCount.text = "📦 ${itemCount} gear entries | ${GearData.getTotalItemsPacked()} total items"

        // Clear any existing views first
        containerGearList.removeAllViews()

        // Loop through all items using index to access each parallel array
        for (i in 0 until itemCount) {
            val cardView = createGearCard(
                index    = i + 1,
                name     = GearData.itemNames[i],
                category = GearData.itemCategories[i],
                quantity = GearData.itemQuantities[i],
                comment  = GearData.itemComments[i]
            )
            containerGearList.addView(cardView)
        }
    }

    /**
     * Creates a styled TextView card for a single gear item.
     * @return A TextView configured to display the item's details
     */
    private fun createGearCard(
        index: Int,
        name: String,
        category: String,
        quantity: Int,
        comment: String
    ): TextView {
        val card = TextView(this)

        // Build the display text with all item details
        card.text = """
            #$index  $name
            📂 Category: $category
            🔢 Quantity: $quantity
            📝 Notes: ${if (comment.isEmpty()) "No notes" else comment}
        """.trimIndent()

        // Styling for the card
        card.textSize = 14f
        card.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        card.setBackgroundColor(ContextCompat.getColor(this, R.color.card_background))

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 0, 0, 16)
        card.layoutParams = params
        card.setPadding(24, 24, 24, 24)

        return card
    }
}
