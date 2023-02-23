import java.io.File

//Problemets syfte är att hitta den resulterande frekvensen av en enhet,
//givet en lista av förändringar i frekvens. Förändringarna i frekvens är representerade som ett antal heltal
//(positiva eller negativa) i en textfil.
//Problemet ber dig att ta varje förändring i frekvens
//och addera/subtrahera dem till en startfrekvens för att hitta den totala frekvensen.


//PART 1
fun main() {
    var finalFrequency = 0

    val input = File("src/main/kotlin/inputDay12018.txt").readLines()
    for (line in input) {
        val value = line.substring(1).toInt()
        if (line.startsWith("+")) {
            finalFrequency += value
        } else {
            finalFrequency -= value
        }
    }

    println("Final frequency: $finalFrequency")

   println(findFirstRepeatingFrequency("src/main/kotlin/inputDay12018.txt"))
}
//PART 2
fun findFirstRepeatingFrequency(inputPath: String): Int {
    val input = File(inputPath).readLines().map { it.toInt() }
    val seenFrequencies = mutableSetOf(0)
    var frequency = 0
    var index = 0

    while (true) {
        frequency += input[index]
        if (seenFrequencies.contains(frequency)) {
            return frequency
        }
        seenFrequencies.add(frequency)
        index = (index + 1) % input.size
    }
}

/*resultingFrequency sätts till 0 som startvärde för den resulterande frekvensen.
Filen läses in rad för rad med File("src/main/kotlin/inputDay12018.txt").readLines().
Loopar igenom varje rad i filen med for (line in input).
Ta bort det första tecknet i strängen med substring(1) för att få fram frekvensändringens numeriska värde.
Konvertera värdet till ett heltal med toInt().
Om raden börjar med "+" så läggs värdet till resultingFrequency.
Om raden börjar med "-" så subtraheras värdet från resultingFrequency.
När alla rader i filen har itererats igenom så skrivs den totala frekvensändringen ut*/



//PART 2
/*

* Funktionen findFirstRepeatingFrequency tar in en sökväg till en textfil som innehåller en lista av heltal.
Funktionen läser in dessa heltal från filen och sparar dem i en variabel input.
Sedan skapar den en tom seenFrequencies och lägger till 0 i den.
Därefter initierar den variabeln frequency till 0 och variabeln index till 0.

Så länge en återkommande frekvens inte har hittats,
loopar funktionen igenom alla heltal i input i tur och ordning.
Vid varje varv adderar funktionen värdet av det aktuella talet i input till variabeln frequency.
Om frequency finns i mängden seenFrequencies så returneras frequency.

Annars läggs frequency till i seenFrequencies och index ökar med 1 och räknas om modulo storleken på input så
att det kan fortsätta att loopa genom input-listan.
Om funktionen aldrig hittar en återkommande frekvens, kommer den att köra i en oändlig loop och programmet kommer att fastna i loopen
*/