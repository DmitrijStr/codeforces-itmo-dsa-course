package twoPointers.step2

/*
 * B - Отрезок с большой суммой [Segment with Big Sum]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/B
 */

import kotlin.math.min

fun main() {
    val (n, s) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toInt() }

    var x = 0L
    var res = Int.MAX_VALUE
    var l = 0

    for (r in 0..a.size - 1) {
        x += a[r]

        while (x - a[l] >= s) {
            x -= a[l]
            l++
        }

        if (x >= s) {
            res = min(res, r - l + 1)
        }
    }

    println(if (res == Int.MAX_VALUE) -1 else res)

}
