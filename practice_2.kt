fun main() {

    println(isEven(4))
    println(multiplyByRule(4))
    println(toNegative(4))

    println(calculateAge(2022))

    println(minValue(listOf(4, 44, 444, 4444)))

    println(twoLargest(listOf(4, 44, 444, 4444, 44444)))

    println(sumPosCountNeg(listOf(4, -44, 444, -4444)))

    println(countVowels("four forty-four"))

    println(middleChar("four"))
    println(middleChar("forty"))

    println(multiplicationTable(4))
}

/* 1 */
fun isEven(n: Int): String =
    if (n % 2 == 0) "Even" else "Odd"

/* 2 */
fun multiplyByRule(n: Int): Int =
    if (n % 2 == 0) n * 4 else n * 5

/* 3 */
fun toNegative(n: Int): Int =
    if (n > 0) -n else n

/* 4 */
fun calculateAge(year: Int): Int =
    2025 - year + 1

/* 5 */
fun minValue(list: List<Int>): Int =
    list.minOrNull() ?: 0

/* 6 */
fun twoLargest(list: List<Int>): List<Int> =
    list.sorted().takeLast(2)

/* 7 */
fun sumPosCountNeg(list: List<Int>?): List<Int> {
    if (list.isNullOrEmpty()) return emptyList()

    val positives = list.count { it > 0 }
    val negativesSum = list.filter { it < 0 }.sum()

    return listOf(positives, negativesSum)
}

/* 8 */
fun countVowels(str: String): Int {
    val vowels = "aeiouy"
    return str.lowercase().count { it in vowels }
}

/* 9 */
fun middleChar(str: String): String {
    val mid = str.length / 2

    return if (str.length % 2 == 0)
        str.substring(mid - 1, mid + 1)
    else
        str[mid].toString()
}

/* 10 */
fun multiplicationTable(n: Int): List<List<Int>> {
    return List(n) { i ->
        List(n) { j ->
            (i + 1) * (j + 1)
        }
    }
}
