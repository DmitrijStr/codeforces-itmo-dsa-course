package twoPointers.step2

/*
 * A - Отрезок с небольшой суммой [Segment with Small Sum]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/A
 */

import kotlin.math.max

fun main() {
    val (n, s) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toInt() }

    var sum = 0L
    var l = 0
    var max = 0

    for (r in 0..a.size - 1) {
        sum += a[r]

        while (sum > s) {
            sum -= a[l]
            l++
        }

        max = max(max, r - l + 1)
    }

    println(max)
}