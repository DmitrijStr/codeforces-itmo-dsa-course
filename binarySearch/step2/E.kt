package binarySearch.step2

/*
 * E - Уравнение  [Equation]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/E
 */

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {

    fun solve(m: Double): Double {
        return m.pow(2.0) + sqrt(m)
    }

    fun search(c: Double) {

        var l: Double = 0.0
        var r: Double = 1e8

        for (k in 0..100) {
            val mid = (l + r) / 2

            val ans = solve(mid)

            if (ans <= c) {
                l = mid
            } else {
                r = mid
            }
        }

        println(String.format("%.7f",r))
    }

    val c = readln().toDouble()

    search(c)
}