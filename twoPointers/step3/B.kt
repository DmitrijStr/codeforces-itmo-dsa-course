package twoPointers.step3

/*
 * B - Общая длина [Total Length]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/B
 */

fun main() {
    val (n, s) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }

    var currSum = 0L
    var l = 0
    var res = 0L

    for (r in 0..a.size - 1) {
        currSum += a[r]

        while (currSum > s) {
            currSum -= a[l]
            l++
        }

        res += 1L * (r - l + 2) * (r - l + 1) / 2
    }

    println(res)
}