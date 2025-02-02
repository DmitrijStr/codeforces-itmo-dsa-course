package binarySearch.step2

/*
 * B - Веревочки [Ropes]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/B
 */

fun main() {
    fun isGood(ropes: List<Int>, k: Int, m: Double): Boolean {
        var cnt = 0

        for (rope in ropes) {
            cnt += (rope / m).toInt()
        }

        return cnt >= k
    }

    fun search(ropes: List<Int>, k: Int): Double {
        var l: Double = 0.0
        var r: Double = 100000000.0

        for (i in 0..100) {
            val mid = (l + r) / 2

            if (isGood(ropes, k, mid)) {
                l = mid
            } else {
                r = mid
            }
        }

        return l
    }

    val (n, k) = readln().split(" ").map { it.toInt() }
    val ropes = List<Int>(n) {
        readln().toInt()
    }

    println(search(ropes, k))
}