package twoPointers.step1

/*
 * C - Число пар равных [Number of Equal]
 * https://codeforces.com/edu/course/2/lesson/9/1/practice/contest/307092/problem/C
 */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    var ans = 0L
    var i = 0
    var j = 0

    while (i < a.size && j < b.size) {

        if (a[i] < b[j]) {
            i++
        } else if (b[j] < a[i]) {
            j++
        } else {
            var countA = 1L
            var countB = 1L

            while (i + 1 < a.size && a[i] == a[i + 1]) {
                countA++
                i++
            }

            while (j + 1 < b.size && b[j] == b[j + 1]) {
                countB++
                j++
            }
            ans += countA * countB
            i++
            j++
        }
    }

    println(ans)
}