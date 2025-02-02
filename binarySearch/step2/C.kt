package binarySearch.step2

/*
 * C - Очень Легкая Задача [Very Easy Task]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/C
 */

fun main() {

    fun isGood(x: Int, y: Int, n: Int, m: Int): Boolean {
        return (m / x) + ((m - x) / y) >= n
    }

    // x is always fastest printer
    fun search(x: Int, y: Int, n: Int): Int {

        var l = 0
        var r = Int.MAX_VALUE


        while (r > l + 1) {
            val mid = (l + r) / 2

            if (isGood(x, y, n, mid)) {
                r = mid
            } else {
                l = mid
            }
        }

        return r
    }

    val (n, x, y) = readln().split(" ").map { it.toInt() }
    println(search(Math.min(x, y), Math.max(x, y), n))
}