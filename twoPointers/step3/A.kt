package twoPointers.step3

/*
 * A - Зацикленный плейлист [Looped Playlist]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/A
 */

fun main() {
    var (n, p) = readln().split(" ").map { it.toLong() }
    val arr = readln().split(" ").map { it.toLong() }
    val sum = arr.sum()
    var a = arr + arr

    var cnt = p / sum

    if (cnt * sum == p) {
        println("1 ${cnt * n}")
        return
    }

    val k = if (p > sum) {
        p - p / sum * sum
    } else {
        p
    }

    var l = 0
    var currSum = 0L
    var min = Int.MAX_VALUE
    var start = 0

    for (r in 0..a.size - 1) {
        currSum += a[r]

        while (currSum >= k) {
            currSum -= a[l]
            l++
        }

        if (l > 0 && r - l + 2 < min) {
            min = r - l + 2
            start = l - 1
        }
    }

    println(
        "${start + 1} ${(if (p > sum) p / sum * n else 0) + min}"
    )
}