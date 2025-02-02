package twoPointers.step2

/*
 * D - Число отрезков с большой суммой [Number of Segments with Big Sum]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/D
 */

fun main() {
    val (n, s) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toInt() }

    var l = 0
    var sum = 0L
    var count = 0L

    for (r in 0..a.size - 1) {
        sum += a[r]

        while (sum - a[l] >= s) {
            sum -= a[l]
            l++
        }

        if (sum >= s) {
            count += 1 + l
        }
    }

    println(count)
}