package com.example.preston.kotlindice

fun rollsToString(a : List<Int>): String {
    val rest = a.drop(1)
    return rest.fold(a.first().toString()) {str: String, cur: Int -> str + " + " + cur.toString()} +
            " = " + a.sum().toString()
}

val MESSAGE = "com.example.preston.kotlindice.counts"
val rollProportions = hashMapOf(2 to 1,
        3 to 2,
        4 to 3,
        5 to 4,
        6 to 5,
        7 to 6,
        8 to 5,
        9 to 4,
        10 to 3,
        11 to 2,
        12 to 1)

fun idealNumRolls(numRolls: Int): Map<Int, Float> =
        rollProportions.map { v -> v.key to v.value.toFloat() / 36 * numRolls }.toMap()

fun mapsToReport(rolls: Map<Int, Int>, ideal: Map<Int, Float>): String =
        (2..12).map { n -> n.toString() + ": " + (rolls.get(n) ?: 0).toString() + "/" + (ideal.get(n) ?: 0).toString() }
                .reduce({acc, cur -> acc + "\n" + cur})