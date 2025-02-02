package twoPointers.step1

/*
 * A - Слияние массивов [Merging Arrays]
 * https://codeforces.com/edu/course/2/lesson/9/1/practice/contest/307092/problem/A
 */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a1 = readln().split(" ").map { it.toInt() }
    val a2 = readln().split(" ").map { it.toInt() }

    val ans = mutableListOf<Int>()
    var i = 0
    var j = 0

    while (i < a1.size || j < a2.size) {
        if (j == a2.size || (i < a1.size && a1[i] < a2[j])) {
            ans.add(a1[i])
            i++
        } else {
            ans.add(a2[j])
            j++
        }
    }

    println(ans.joinToString(" "))
}