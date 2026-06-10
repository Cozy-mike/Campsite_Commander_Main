package com.example.campsitecommander

/**
 * DataManager
 * Manages all gear data using parallel arrays as required by the assessment.
 * Stores item names, categories, quantities, and comments in separate arrays.
 * Provides functions to add items, retrieve items, and calculate totals.
 */
object DataManager {

    // --- Parallel Arrays for storing gear data ---
    // Each index represents one gear item across all arrays

    val itemNames = mutableListOf(
        "Tent",
        "Marshmallows",
        "Flashlight",
        "First Aid Kit",
        "Sleeping Bag",
        "Camp Stove",
        "Water Bottle"
    )

    val itemCategories = mutableListOf(
        "Shelter",
        "Food",
        "Safety",
        "First Aid",
        "Shelter",
        "Cooking",
        "Cooking"
    )

    val itemQuantities = mutableListOf(
        1,
        3,
        2,
        1,
        2,
        1,
        4
    )

    val itemComments = mutableListOf(
        "4-person waterproof",
        "For S'mores (Mega size)",
        "Check batteries (AA)",
        "Include bandages and antiseptic",
        "Rated for -5 degrees",
        "Includes fuel canister",
        "BPA-free, 1L each"
    )

    // Available categories for the spinner/dropdown
    val categories = arrayOf("Shelter", "Food", "Safety", "First Aid", "Cooking", "Other")

    /**
     * Adds a new gear item to all parallel arrays simultaneously.
     * @param name     The name of the item
     * @param category The category of the item
     * @param quantity The quantity being packed
     * @param comments Any notes or comments about the item
     */
    fun addItem(name: String, category: String, quantity: Int, comments: String) {
        itemNames.add(name)
        itemCategories.add(category)
        itemQuantities.add(quantity)
        itemComments.add(comments)
    }

    /**
     * Calculates the total number of individual items packed.
     * Uses a loop to sum all quantities as required by the assessment.
     * @return The total count of all items
     */
    fun getTotalItemCount(): Int {
        var total = 0
        // Loop through all quantities and sum them up
        for (quantity in itemQuantities) {
            total += quantity
        }
        return total
    }

    /**
     * Returns the total number of unique gear entries (rows).
     */
    fun getItemCount(): Int {
        return itemNames.size
    }
}
