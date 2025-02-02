package binarySearch.step2

/*
 * F - Игра со строкой [String Game]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/F
 */

fun main() {
    fun isGood(s1: List<String>, s2: List<String>, a: List<Int>, m: Int): Boolean {
        val removedIndex = mutableSetOf<Int>()

        for (i in 0..m - 1) {
            removedIndex.add(a[i] - 1)
        }

        var i = 0
        var j = 0

        while (i < s1.size && j < s2.size) {
            if (removedIndex.contains(i)) {
                i++
                continue
            }

            if (s2[j] == s1[i]) {
                j++
                i++
            } else {
                i++
            }
        }

        return j == s2.size
    }

    fun search(s1: List<String>, s2: List<String>, a: List<Int>): Int {
        var l = 0
        var r = s1.size - s2.size + 1

        while (r > l + 1) {
            val mid = (l + r) / 2

            if (isGood(s1,s2,a,mid)) {
                l = mid
            } else {
                r = mid
            }
        }

        println(l)

        return l
    }

    val s1 = readln().split("").drop(1).dropLast(1)
    val s2 = readln().split("").drop(1).dropLast(1)

    val a = readln().split(" ").map { it.toInt() }

    search(s1,s2,a)
}