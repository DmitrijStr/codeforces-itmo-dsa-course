package twoPointers.step1

/*
 * B - Число меньших [Number of Smaller]
 * https://codeforces.com/edu/course/2/lesson/9/1/practice/contest/307092/problem/B
 */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    val res = mutableListOf<Int>()

    var i = 0
    for (j in 0..b.size - 1) {

        while (i < a.size && a[i] < b[j]) {
            i++
        }

        res.add(i)
    }

    println(res.joinToString(" "))
}