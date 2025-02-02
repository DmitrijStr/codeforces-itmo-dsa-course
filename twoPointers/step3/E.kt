package twoPointers.step3

/*
 * E - Рюкзак на отрезке [Knapsack on a Segment]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/E
 */

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val w = readln().split(" ").map { it.toInt() }
    val c = readln().split(" ").map { it.toInt() }

    var ans = 0L
    var currSum = 0L
    var currWeight = 0L

    var l = 0

    for (r in 0..n - 1) {
        currWeight += w[r]
        currSum += c[r]

        while (currWeight > s) {
            currWeight -= w[l]
            currSum -= c[l]

            l++
        }

        if (currSum > ans) {
            ans = currSum
        }
    }

    println(ans)
}