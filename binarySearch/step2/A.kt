package binarySearch.step2

/*
 * A - Упаковка прямоугольников [Packing Rectangles]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/A
 */

fun main() {

    fun isFit(w: Int, h: Int, x: Long, n: Int): Boolean {
        return (x / w) * (x / h) >= n
    }

    fun findUpper(w: Int, h: Int, n: Int): Long {
        var l = 0L
        var r = 1L

        while (!isFit(w,h,r,n)) {
            r *= 2
        }

        while (r > l + 1) {

            val mid = (l + r) / 2

            if (isFit(w, h, mid, n)) {
                r = mid
            } else {
                l = mid
            }
        }

        return r
    }

    val (w, h, n) = readln().split(" ").map { it.toInt() }

    println(findUpper(w, h, n))
}