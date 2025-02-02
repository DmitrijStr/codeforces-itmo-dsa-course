package twoPointers.step2

/*
 * G - Взаимно простой отрезок [Coprime Segment]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/G
 */


fun gcd(m: Long, n: Long): Long {
    var a = m
    var b = n
    while (b > 0) {
        val r = a % b
        a = b
        b = r
    }

    return a
}

class GCDStack {
    private val s = mutableListOf<Long>()
    private val gcdS = mutableListOf<Long>(0L)

    fun push(x: Long) {
        s.add(x)
        gcdS.add(gcd(gcdS.last(), x))
    }

    fun pop(): Long {
        val x = s.last()
        s.removeLast()
        gcdS.removeLast()

        return x
    }

    fun isEmpty(): Boolean {
        return s.isEmpty()
    }

    fun gcd(): Long {
        return gcdS.last()
    }
}

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toLong() }

    val s1 = GCDStack()
    val s2 = GCDStack()

    var l = 0
    var min = Int.MAX_VALUE

    fun add(x: Long) {
        s2.push(x)
    }

    fun remove() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop())
            }
        }

        s1.pop()
    }

    fun good(): Boolean {
        var g = 0L

        if (!s1.isEmpty()) {
            g = gcd(g, s1.gcd())
        }

        if (!s2.isEmpty()) {
            g = gcd(g, s2.gcd())
        }

        return g == 1L
    }

    for (r in 0..a.size - 1) {
        add(a[r])

        while (good()) {
            remove()
            l++
        }

        if (l > 0) {
            min = minOf(min, r - l + 2)
        }
    }

    println(if (min == Int.MAX_VALUE) -1 else min)
}