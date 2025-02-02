package binarySearch.step2

/*
 * G - Студенческие советы [Student Councils]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/G
 */

fun main() {
    fun isGood(m: Long, k: Long, students: List<Int>): Boolean {
        var sum = 0L

        for (student in students) {

            if (student <= m) {
                sum += student
            } else {
                sum += m
            }
        }

        return sum >= m * k
    }

    fun search(k: Long, students: List<Int>): Long {
        // l <= x
        // r > x
        var l = 0L
        var r: Long = students.max() * k * students.size

        while (r > l + 1) {
            val mid = (l + r) / 2

            if (isGood(mid, k, students)) {
                l = mid
            } else {
                r = mid
            }
        }

        return l
    }

    val k = readln().toLong()
    val n = readln().toInt()
    val students = List<Int>(n) {
        readln().toInt()
    }

    println(search(k, students))
}