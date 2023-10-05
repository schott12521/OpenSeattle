/**
 * Used to represent a contribution to the shelter.
 *
 * NOTE: Date is represented as a String because this value is not used.
 */
data class Donation(val donorName: String, val type: String, val quantity: Double, val date: String)