import kotlin.random.Random

fun main() {
    val options = listOf("rock", "paper", "scissors")

    while (true) {
        val computerChoice = options[Random.nextInt(options.size)]

        println("Enter your choice (rock, paper, scissors) or 'exit':")

        val userChoice = try {
            val input = readln().lowercase()

            if (input == "exit") {
                println("Game ended")
                break
            }

            if (input !in options) throw IllegalArgumentException()

            input
        } catch (e: Exception) {
            println("Invalid input! Try again.")
            continue
        }

        println("Computer: $computerChoice")
        println("You: $userChoice")

        val result = getResult(userChoice, computerChoice)
        println(result)

        println("-----")
    }
}

fun getResult(user: String, computer: String): String {
    if (user == computer) return "Draw"

    return when {
        user == "rock" && computer == "scissors" -> "You win"
        user == "scissors" && computer == "paper" -> "You win"
        user == "paper" && computer == "rock" -> "You win"
        else -> "Computer wins"
    }
}
