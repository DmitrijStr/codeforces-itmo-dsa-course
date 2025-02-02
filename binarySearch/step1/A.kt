package binarySearch.step1

/*
 * A - Двоичный поиск [Binary Search]
 * https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A
 */

fun main() {
    fun binSearch(a: List<Int>, target: Int): Boolean {

        var l = 0
        var r = a.size - 1
        var mid = (l + r) / 2

        while (r >= l) {
            if (a[mid] == target) {
                return true
            }
            if (a[mid] < target) {
                l = mid + 1
            }
            if (a[mid] > target) {
                r = mid - 1
            }

            mid = (l + r) / 2
        }

        return false
    }

    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    val queries = readln().split(" ").map { it.toInt() }

    for (q in queries) {

        if (binSearch(arr,q)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}