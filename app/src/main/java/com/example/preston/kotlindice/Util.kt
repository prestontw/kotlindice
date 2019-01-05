package com.example.preston.kotlindice

fun rollsToString(previous: Pair<Int, Int>?, current: Pair<Int, Int>?): String {
    if (previous == null) {
        return rollToString(current)
    }
    else {
        return rollToString(previous) + "\n" + rollToString(current)
    }
}

fun rollToString(r: Pair<Int, Int>?): String {
    if (r == null) {
        return ""
    }
    else {
        return r.first.toString() + " + " + r.second.toString() + " = " + (r.first + r.second).toString()
    }
}

fun getNewRoll(previous: Pair<Int, Int>?, current: Pair<Int, Int>): Pair<Int, Int> {
    if (previous == null) {
        return current
    }
    else {
        if (previous.first == current.first && previous.second == current.second) {
            return Pair(current.first - 1, current.second + 1)
        }
        else {
            return current
        }
    }
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