fun main() {

    // ================= OWNER MODE =================
    println("=== OWNER MODE ===")

    val rows = readInt("Enter the number of rows:")
    val seats = readInt("Enter the number of seats in each row:")
    val ticketPrice = readInt("Enter ticket price:")

    val cinema = Array(rows) { Array(seats) { "S" } }

    val totalSeats = rows * seats
    var purchasedTickets = 0
    var currentIncome = 0

    println("\n=== GLOBAL MODE ===")

    // ================= GLOBAL MODE =================
    while (true) {

        println("""
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent())

        when (readCommand()) {

            1 -> showSeats(cinema)

            2 -> buyTicket(
                cinema,
                rows,
                seats,
                ticketPrice
            ).also { price ->
                if (price > 0) {
                    purchasedTickets++
                    currentIncome += price
                }
            }

            3 -> showStatistics(
                purchasedTickets,
                totalSeats,
                currentIncome,
                ticketPrice
            )

            0 -> {
                println("Exiting program...")
                return
            }
        }
    }
}

fun readInt(message: String): Int {
    while (true) {
        println(message)
        try {
            return readln().toInt()
        } catch (e: Exception) {
            println("Wrong input! Enter a number.")
        }
    }
}

fun readCommand(): Int {
    return when (readln().lowercase()) {
        "1", "show", "show the seats" -> 1
        "2", "buy", "buy a ticket" -> 2
        "3", "stats", "statistics" -> 3
        "0", "exit" -> 0
        else -> {
            println("Unknown command!")
            readCommand()
        }
    }
}

fun buyTicket(
    cinema: Array<Array<String>>,
    rows: Int,
    seats: Int,
    price: Int
): Int {

    while (true) {
        try {
            println("Enter a row number:")
            val r = readln().toInt()

            println("Enter a seat number in that row:")
            val s = readln().toInt()

            if (r !in 1..rows || s !in 1..seats) {
                println("Wrong input!")
                continue
            }

            if (cinema[r - 1][s - 1] == "B") {
                println("That ticket has already been purchased!")
                continue
            }

            cinema[r - 1][s - 1] = "B"
            println("Ticket price: $$price")

            return price

        } catch (e: Exception) {
            println("Wrong input!")
        }
    }
}

fun showSeats(cinema: Array<Array<String>>) {
    println("Cinema:")

    print("  ")
    for (i in cinema[0].indices) print("${i + 1} ")
    println()

    for (i in cinema.indices) {
        print("${i + 1} ")
        for (seat in cinema[i]) print("$seat ")
        println()
    }
}

fun showStatistics(
    purchased: Int,
    total: Int,
    income: Int,
    price: Int
) {
    val percentage = if (total == 0) 0.0
    else (purchased.toDouble() / total) * 100

    val totalIncome = total * price

    println("Number of purchased tickets: $purchased")
    println("Percentage: %.2f%%".format(percentage))
    println("Current income: $$income")
    println("Total income: $$totalIncome")
}
