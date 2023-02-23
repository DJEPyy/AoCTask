import java.io.File

fun main() {
    println(part1Solution())

    println(part2Solution())

    println(part1SolutionInspired())
}

fun part1Solution(){
    val items = File("src/main/kotlin/inputDay12018.txt").readLines().map { it.toInt() }

    val results = items.reduce { a, b -> a + b }
    println(results)
}

fun part1SolutionInspired() {
    val items = File("src/main/kotlin/inputDay12018.txt").readLines().map { it.toInt() }
    val sum = items.sum()
    println(sum)
}

fun part2Solution() {
    var sum = 0
    var values = File("src/main/kotlin/inputDay12018.txt").readLines().map { it.toInt() }
    val seen: MutableSet<Int> = mutableSetOf()
    while (!seen.contains(sum)) {
        seen.add(sum)
        if (values.isEmpty()) {
            values = File("src/main/kotlin/inputDay12018.txt").readLines().map { it.toInt() }
        }
        sum = sum + values[0]
        values = values.drop(1)
    }
    println(sum)
}


//ALTERNATIV LÖSNING
//https://www.youtube.com/watch?v=YgNt6746q80&list=PLfzJKXh_D71SJkxZ_2eKHRUiVebhUPgZ4&index=1
//https://www.youtube.com/watch?v=9y8iCSu0KYQ&list=PLfzJKXh_D71SJkxZ_2eKHRUiVebhUPgZ4&index=2


//PART 1
//.reduce() är en högre ordning funktion som används för att reducera elementen i en samling till ett enda värde.
//I det här fallet, om vi har en lista med tal,
//kommer .reduce() att ta två element åt gången och kombinera dem på ett specifikt sätt som anges av en funktion som ges till .reduce() som en argument.
//Resultatet av denna kombination blir det första elementet i nästa par, och så fortsätter funktionen tills alla element har kombinerats till ett enda värde.
//
//Funktionen som anges till .reduce() som en argument, och som specificerar hur elementen ska kombineras,
//är en lambda-uttryck i det här fallet: {a, b -> a + b}. Detta lambda-uttryck säger att vi ska ta två element (a och b),
//lägga ihop dem med "+" -operatorn och returnera resultatet.
//
//Så i slutändan kommer .reduce() att returnera en enda summa av alla element i listan.


//PART 2
//Funktionen part2Solution() öppnar en fil inputDay12018.txt som innehåller frekvensändringarna,
//och lagrar dem i en lista av heltal som heter values.
//
//Variabeln sum inleds med värdet 0, eftersom vi börjar vid frekvensen 0.
//
//Vi skapar också en tom uppsättning seen, som vi kommer att använda för att hålla reda på vilka frekvenser vi redan har sett.
//
//Sedan har vi en loop som fortsätter tills vi har sett en frekvens två gånger.
//
//Inuti loopen kontrollerar vi om sum redan finns i seen-uppsättningen. Om den inte finns där lägger vi till sum till seen.
//
//Vi använder sedan values-listan för att uppdatera sum genom att lägga till första värdet i listan. Vi tar också bort det första elementet från values-listan,
//eftersom vi inte kommer att använda det igen.
//
//Om values-listan är tom, börjar vi om från början av filen och läser in frekvensändringarna igen. Detta gör vi genom att använda
//File("src/main/kotlin/inputDay12018.txt").readLines().map { it.toInt() }.
//
//När en frekvens upprepas avbryter loopen och vi skriver ut svaret, som är den första frekvensen som upprepas.


//Både sum() och reduce() är funktioner som används för att summera element i en lista. Skillnaden mellan dem är hur de summerar elementen.
//
//Funktionen sum() summerar elementen genom att helt enkelt lägga ihop dem. Det vill säga, om vi har en lista med tal [1, 2, 3],
//kommer sum() att returnera 6 eftersom det är summan av dessa tal.
//Funktionen reduce() däremot,
//kan summera elementen på olika sätt beroende på hur du definierar summeringsregeln.
//reduce() tar två element åt gången och tillämpar en funktion på dem för att producera ett enda värde.
//Detta värde används sedan tillsammans med nästa element i listan för att producera ett nytt värde, och så vidare tills alla element har sammanfogats.