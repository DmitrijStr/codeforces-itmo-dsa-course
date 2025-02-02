package twoPointers.step2

/*
 * E - Отрезки с небольшим множеством [Segments with Small Set]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/E
 */

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val count = mutableMapOf<Int, Int>().withDefault { 0 }
    var l = 0
    var res = 0L

    fun good() = count.size <= k

    fun add(x: Int) {
        count[x] = count.getValue(x) + 1
    }

    fun remove(x: Int) {
        count[x] = count.getValue(x) - 1

        if (count.getValue(x) <= 0) {
            count.remove(x)
        }
    }

    for (r in 0..a.size - 1) {
        add(a[r])

        while (!good()) {
            remove(a[l])
            l++
        }

        res += r - l + 1
    }

    println(res)
}




