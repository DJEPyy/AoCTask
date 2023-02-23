import java.io.File

//SIGRUNS LÖSNING
fun findSumThatsAddsUpTo2020(input: List<Int>, equalsTo: Int): Int {
    for (i in input.indices) {
        for (j in i + 1 until input.size) {
            if (input[i] + input[j] == 2020) {
                return input[i] * input[j]

            }
        }
    }
    return 0
}


fun main() {
    val inputFile = File("src/main/kotlin/inputDay12020.txt")
    val numbers = inputFile.readLines().map { it.toInt() }
    val equalsTo = 2020

    val answer = numbers.find { number -> numbers.contains(equalsTo - number) }

    if (answer != null) {
        println("Svaret är ${answer * (equalsTo - answer)}")
    } else {
        println("Det finns inga två tal som summerar till $equalsTo")
    }

    //inspo
    InspoLösningHybrid()
}


fun InspoLösningHybrid() {
    val inputFile = File("src/main/kotlin/inputDay12020.txt")
    val numbers = inputFile.readLines().map { it.toInt() }
    val equalsTo = 2020

    val result = findSumThatsAddsUpTo2020(numbers, equalsTo)

    if (result != 0) {
        println("InspoSvaret är $result")
    } else {
        println("Det finns inga två tal som summerar till $equalsTo")
    }
}

