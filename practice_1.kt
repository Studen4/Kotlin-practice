fun main() {

    // 1. Знайомство
    println("Hello! My name is DICT_Bot.")
    println("Please, remind me your name:")

    val name = readLine()
    println("What a great name you have, $name!")

    // 2. Вгадування віку
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")

    val rem3 = readLine()!!.toInt()
    val rem5 = readLine()!!.toInt()
    val rem7 = readLine()!!.toInt()

    val age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105

    println("Your age is $age; that's a good time to start programming!")

    // 3. Лічильник
    println("Now I will prove to you that I can count to any number you want.")
    val number = readLine()!!.toInt()

    var i = 0
    while (i <= number) {
        println("$i!")
        i++
    }

    // 4. Тест
    println("Let's test your programming knowledge.")

    while (true) {
        println("Why do we use methods?")
        println("1. To repeat a statement multiple times.")
        println("2. To decompose a program into several small subroutines.")
        println("3. To determine the execution time of a program.")
        println("4. To interrupt the execution of a program.")

        val answer = readLine()!!.toInt()

        if (answer == 2) {
            break
        } else {
            println("Please, try again.")
        }
    }

    // 5. Завершення
    println("Congratulations, have a nice day!")
}