package binarySearch.step1

/*
 * D - Быстрый поиск в массиве [Fast search]
 * https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/D
 */

fun main() {

    fun findLower(a: List<Int>, x: Int): Int {
        var l = -1
        var r = a.size
        // l = a[l] <= x
        // r = a[r] > x

        while (r > l + 1) {
            val m = (l + r) / 2

            if (a[m] <= x) {
                l = m
            } else {
                r = m
            }
        }

        return l
    }

    fun findUpper(a: List<Int>, x: Int): Int {
        var l = -1
        var r = a.size
        // l = a[l] < x
        // r = a[r] >= x

        while (r > l + 1) {
            val m = (l + r) / 2

            if(a[m] < x) {
                l = m
            } else {
                r = m
            }
        }

        return r
    }

    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    val q = readln().toInt()
    val ans = mutableListOf<Int>()

    repeat(q) {
        val (l, r) = readln().split(" ").map { it.toInt() }

        val left = findUpper(arr, l)
        var right = findLower(arr, r)
        ans.add(right - left + 1)
    }

    println(ans.joinToString(" "))
}