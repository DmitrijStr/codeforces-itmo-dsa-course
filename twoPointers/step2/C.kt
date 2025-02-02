package twoPointers.step2

/*
 * C - Число отрезков с небольшой суммой [Number of Segments with Small Sum]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/C
 */

fun main() {
    val (n, s) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toInt() }

    var sum = 0L
    var count = 0L
    var l = 0

    for (r in 0..a.size - 1) {
        sum += a[r]

        while (sum > s) {
            sum -= a[l]
            l++
        }

        count += r - l + 1
    }

    print(count)
}