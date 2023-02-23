import java.io.File
import java.util.*

fun main() {
    val scanner = Scanner(File("src/main/kotlin/input.txt"))
    val input = scanner.nextLine()
    scanner.close()

    val sum = solvePart1(input)

    println("Sum: $sum")
}
fun solvePart1(input: String): Int {
    val circularInput = input + input[0]
    return circularInput
        .zipWithNext()
        .filter { it.first == it.second }
        .filter { it.first.isDigit() }
        .map { it.first.toString().toInt() }
        .sum()
}
   /*INSPERAD LÖSNING:
   I main-funktionen läser vi indata från en fil och kallar på solvePart1 med indata som parameter.
   solvePart1 gör samma sak som min tidigare lösning,
   förutom att vi lägger till circularInput som skapar en cirkulär lista.
    */