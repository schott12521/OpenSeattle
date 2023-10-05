fun main() {
    val shelter = Shelter()

    println("Welcome to the Shelter Donation System!")
    println("Available commands: registerDonation, registerDistribution, generateInventoryReport, generateDonatorReport, exit.")

    loop@ while (true) {
        print("> ")
        val input = readlnOrNull() ?: continue
        val args = input.split(" ")

        when (args[0]) {
            "registerDonation" -> {
                if (args.size != 5) {
                    println("Usage: registerDonation <donorName> <type> <quantity> <date in YYYY-MM-DD format>")
                    continue
                }
                val donorName = args[1]
                val type = args[2]
                val quantity = args[3].toDoubleOrNull()
                val date = args[4]

                if (quantity == null) {
                    println("Invalid quantity provided.")
                    continue
                }

                shelter.registerDonation(donorName, type, quantity, date)
                println("Donation registered successfully!")
            }

            "registerDistribution" -> {
                if (args.size != 4) {
                    println("Usage: registerDistribution <type> <quantity> <date in YYYY-MM-DD format>")
                    continue
                }
                val type = args[1]
                val quantity = args[2].toDoubleOrNull()
                val date = args[3]

                if (quantity == null) {
                    println("Invalid quantity provided.")
                    continue
                }

                shelter.registerDistribution(type, quantity, date)
                println("Distribution registered successfully!")
            }

            "generateInventoryReport" -> {
                print(shelter.generateInventoryReport())
            }

            "generateDonatorReport" -> {
                print(shelter.generateDonatorReport())
            }

            "exit" -> {
                println("Exiting the system. Goodbye!")
                break@loop
            }

            else -> {
                println("Invalid command. Please use one of the following: registerDonation, registerDistribution, generateInventoryReport, generateDonatorReport, exit.")
            }
        }
    }
}