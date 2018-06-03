package com.example.preston.kotlindice

fun rollsToString(a : List<Int>): String {
    val rest = a.drop(1)
    return rest.fold(a.first().toString()) {str: String, cur: Int -> str + " + " + cur.toString()} +
            " = " + a.sum().toString()
}