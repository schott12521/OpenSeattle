import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ShelterTest {

    private lateinit var shelter: Shelter

    @BeforeEach
    fun setup() {
        shelter = Shelter()
    }

    @Test
    fun testRegisterDonation() {
        shelter.registerDonation("Amy", "money", 100.0, "2023-10-01")
        val report = shelter.generateDonatorReport()
        assertEquals("Donator Report:\nAmy: 100.0\n", report)
    }

    @Test
    fun testRegisterDistribution() {
        shelter.registerDonation("Amy", "money", 100.0, "2023-10-01")
        shelter.registerDistribution("money", 50.0, "2023-10-02")
        val report = shelter.generateInventoryReport()
        assertEquals("Inventory Report:\nmoney: 50.0\n", report)
    }

    @Test
    fun testGenerateInventoryReport() {
        shelter.registerDonation("Amy", "money", 100.0, "2023-10-01")
        shelter.registerDonation("Bob", "food", 50.0, "2023-10-02")
        shelter.registerDistribution("food", 20.0, "2023-10-03")

        val report = shelter.generateInventoryReport()
        val expectedReport = """
            Inventory Report:
            money: 100.0
            food: 30.0
        """.trimIndent() + "\n"
        assertEquals(expectedReport, report)
    }

    @Test
    fun testGenerateDonatorReport() {
        shelter.registerDonation("Amy", "money", 100.0, "2023-10-01")
        shelter.registerDonation("Amy", "food", 50.0, "2023-10-02")
        shelter.registerDonation("Bob", "food", 50.0, "2023-10-03")

        val report = shelter.generateDonatorReport()
        val expectedReport = """
            Donator Report:
            Amy: 150.0
            Bob: 50.0
        """.trimIndent() + "\n"
        assertEquals(expectedReport, report)
    }
}
