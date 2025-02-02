package twoPointers.step3

/*
 * C - Город Че [Che city]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/C
 */

fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val a = readln().split(" ").map(String::toInt)

    var ans = 0L
    var l = 0

    for (r in 0..a.size - 1) {

        while (a[r] - a[l] > k) {
            val x = n - r
            ans += x

            l++
        }
    }

    println(ans)
}