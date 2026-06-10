package com.example.campsitecommander

/**
 * GearData - Central data store for the app.
 * Uses parallel arrays to store gear item details:
 * - itemNames: names of each gear item
 * - itemCategories: category each item belongs to
 * - itemQuantities: how many of each item
 * - itemComments: notes/tips for each item
 *
 * Using an object makes this a singleton so all Activities share the same data.
 */
object GearData {

    // Parallel arrays - index 0 in each array refers to the same gear item
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
        "Hydration"
    )

    val itemQuantities = mutableListOf(
        1, 3, 2, 1, 2, 1, 4
    )

    val itemComments = mutableListOf(
        "4-person waterproof",
        "For S'mores (Mega size)",
        "Check batteries (AA)",
        "Include bandages and antiseptic",
        "Rated for -10°C",
        "Bring extra gas canister",
        "1 per person, insulated"
    )

    /**
     * Adds a new gear item to all parallel arrays simultaneously.
     * @param name Item name
     * @param category Item category
     * @param quantity Number of items
     * @param comment Notes/tips about the item
     */
    fun addItem(name: String, category: String, quantity: Int, comment: String) {
        itemNames.add(name)
        itemCategories.add(category)
        itemQuantities.add(quantity)
        itemComments.add(comment)
    }

    /**
     * Calculates the total number of individual items packed.
     * Uses a loop to sum all quantities.
     * @return Total quantity of all items combined
     */
    fun getTotalItemsPacked(): Int {
        var total = 0
        // Loop through quantities array to calculate total
        for (quantity in itemQuantities) {
            total += quantity
        }
        return total
    }

    /**
     * Returns the number of unique gear entries (rows in the list).
     */
    fun getItemCount(): Int {
        return itemNames.size
    }
}
