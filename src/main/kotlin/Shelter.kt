/**
 * Represents an animal shelter that maintains an inventory of donations minus distributions that have
 * been given out from the shelter.
 *
 * Public methods are:
 *
 * - registerDonation
 * - registerDistribution
 * - generateInventoryReport
 * - generateDonatorReport
 */
class Shelter {
    private val donations = mutableListOf<Donation>()
    private val distributions = mutableListOf<Distribution>()

    /**
     * Used when a contribution to the shelter is made, parameters are:
     *
     * @param donorName - The name of who made a contribution
     * @param type - The type of donation given (eg. money, food, etc)
     * @param quantity - The amount of item given to the shelter
     * @param date - The date when the contribution was made (represented as a string in YYYY-MM-DD format)
     */
    fun registerDonation(donorName: String, type: String, quantity: Double, date: String) {
        val donation = Donation(donorName, type, quantity, date)
        donations.add(donation)
    }

    /**
     * Used when an item from the shelter's inventory is given out.
     *
     * @param type - The type of donation being distributed (e.g., money, food, etc)
     * @param quantity - The amount of the item distributed
     * @param date - The date when the distribution was made (represented as a string in YYYY-MM-DD format)
     */
    fun registerDistribution(type: String, quantity: Double, date: String) {
        val distribution = Distribution(type, quantity, date)
        distributions.add(distribution)
    }

    /**
     * Generates a report showing the current status of donations in the shelter's inventory, grouped by type.
     *
     * @return A string representation of the inventory report.
     */
    fun generateInventoryReport(): String {

        // Calculate the net inventory report by:
        //   - grouping donations by similar type
        //   - adding up all donations of similar type
        //   - subtracting any distributions of similar type
        val netInventoryReport = donations.groupBy { it.type }
            .mapValues { entry -> entry.value.sumOf { it.quantity } }
            .mapValues { entry -> entry.value - distributions.filter { it.type == entry.key }.sumOf { it.quantity } }

        var report = "Inventory Report:\n"
        for ((type, quantity) in netInventoryReport) {
            report += "$type: $quantity\n"
        }
        return report
    }

    /**
     * Generates a report summarizing the total contributions received from each donor.
     *
     * @return A string representation of the donator report.
     */
    fun generateDonatorReport(): String {

        // Calculate the donator report by:
        //   - Grouping donations by type
        //   - Adding up the donations by donor
        val donatorReport = donations.groupBy { it.donorName }
            .mapValues { entry -> entry.value.sumOf { it.quantity } }

        var report = "Donator Report:\n"
        for ((donor, quantity) in donatorReport) {
            report += "$donor: $quantity\n"
        }
        return report
    }
}