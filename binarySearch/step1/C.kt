package binarySearch.step1

/*
 * C - Ближайшее справа [Closest to the Right]
 * https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/C
 */

fun main() {
    fun binSearch(arr: List<Int>, target: Int): Int {
        var l = -1
        var r = arr.size

        // arr[l] < target
        // arr[r] >= target

        while (r > l + 1) {
            val mid = (l + r) / 2

            if (arr[mid] < target) {
                l = mid
            } else {
                r = mid
            }
        }

        return r
    }

    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    val queries = readln().split(" ").map { it.toInt() }

    for (q in queries) {
        val ans = binSearch(arr, q)

        println(ans + 1)



    }
}