import java.io.File
import java.util.*


fun main() {
    val scanner = Scanner(File("src/main/kotlin/input.txt"))
    val sequence = scanner.nextLine()
    scanner.close()

    val sum = calculateSum(sequence)

    println("Sum: $sum")


    val halfwaySum = getHalfwaySum(sequence)

    println("Halfway sum: $halfwaySum")


}

/*  Funktionen heter calculateSum och tar en parameter som är en sträng.
    Funktionen returnerar en heltalsvariabel (Int).
    Skapar en variabel "sum" och sätter den till 0.
    Skapar en for-loop som går igenom alla tecken i strängen.
    En if-sats som kollar om tecknet vid index "i" i strängen "sequence" är lika med tecknet vid index "(i + 1) % sequence.
    length".
    "%" betyder att det är resten av divisionen.
    Så "(i + 1) % sequence.length" gör att när den sista positionen i strängen "sequence" nås,
    går den tillbaka till början av strängen för att jämföra tecken med den första positionen i strängen.
    Om if-satsen är sann, konverterar funktionen tecknet vid index "i" till en sträng, och sedan till ett heltal,
    och adderar detta till "sum".
    Funktionen returnerar sedan "sum".
*/
fun calculateSum(sequence: String): Int {
    var sum = 0
    for (i in sequence.indices) {
        if (sequence[i] == sequence[(i + 1) % sequence.length]) {
            sum += sequence[i].toString().toInt()
        }
    }
    return sum
}


/*Skapar en variabel "halfway" och sätter den till hälften av längden på strängen "input".
Skapar en variabel "sum" och sätter den till 0.
Skapar en for-loop som går igenom alla tecken i strängen "input".
Skapar en variabel "current" och sätter den till tecknet vid index "i" i strängen "input".
Skapar en variabel "opposite" och sätter den till tecknet vid index "i + halfway" i strängen "input".
Om "current" är lika med "opposite", konverterar funktionen "current" till en sträng, och sedan till ett heltal,
och multiplicerar detta med 2, och adderar detta till "sum".
Funktionen returnerar sedan "sum".*/
fun getHalfwaySum(input: String): Int {
    var sum = 0
    val halfway = input.length / 2
    for (i in 0 until halfway) {
        val current = input[i]
        val opposite = input[i + halfway]
        if (current == opposite) {
            sum += 2 * current.toString().toInt()
        }
    }
    return sum
}
/*I det här fallet används until eftersom loopen ska gå igenom alla index från 0 till halfway-1 (dvs.
alla index i första halvan av strängen). Om man istället hade använt ..
istället för until, skulle loopen gått igenom alla index från 0 till halfway
(dvs. inklusive indexet för mittenpositionen i strängen) vilket inte är vad som behövs i detta fall.

indices är en egenskap som finns tillgänglig på alla typer av sekvenser i Kotlin,
inklusive strängar.
Egenskapen returnerar ett intervall av heltalsvärden som motsvarar indexen i sekvensen.
Till exempel har en sträng med fem tecken ("hello") giltiga indexvärden från 0 till 4.
Genom att använda indices-egenskapen kan man enkelt iterera genom alla giltiga index i
strängen genom att skriva for (i in sequence.indices).

Detta är en bekväm och säker metod för att iterera genom en sträng eftersom det garanterar att loopen
bara kommer att köra för giltiga indexvärden. Om man istället använder en vanlig for-loop som itererar från 0
till sequence.length, finns det en risk för att man råkar använda ett ogiltigt indexvärde som kan orsaka en
IndexOutOfBoundsException-fel.*/

/*ALTERNATIV LÖSNING MED KOTLIN:
https://github.com/tginsberg/advent-2017-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2017/Day01.kt
  Vi definierar en klass Day01 med en egenskap input som är en sträng med siffror.
  Vi definierar också en funktion solvePart1 som returnerar en Int.
  Vi omvandlar input till en array av tecken med toCharArray().
  Vi skapar en range från 0 till antalet tecken i arrayen med 0 until chars.size.
  Vi filtrerar range med filter.
  För varje position it i range jämför vi tecknet på den positionen med tecknet på nästa position i arrayen
  (med modulo för att hantera den cirkulära egenskapen hos listan).
  Om de två tecknen matchar behåller vi positionen i listan med filter { chars[it] == chars[(it + 1) % chars.size] }.
  Vi omvandlar kvarvarande positioner i listan till numeriska värden med map { Character.getNumericValue(chars[it]) }.
  Vi summerar de numeriska värdena med sum() och returnerar resultatet.*/


/*INSPERAD LÖSNING:
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
    .map { it.first.asDigit() }
    .sum()

   I main-funktionen läser vi indata från en fil och kallar på solvePart1 med indata som parameter.
   solvePart1 gör samma sak som min tidigare lösning,
   förutom att vi lägger till circularInput som skapar en cirkulär lista.
    */