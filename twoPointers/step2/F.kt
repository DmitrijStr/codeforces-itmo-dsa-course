package twoPointers.step2

/*
 * F - Отрезки с небольшим разбросом [Segments with Small Spread]
 * https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/F
 */


// Stack that support to get minimum and maximum for O(1)
class StackMinMax {
    val s = mutableListOf<Long>()
    val smin = mutableListOf<Long>()
    val smax = mutableListOf<Long>()

    fun push(x: Long) {
        s.add(x)
        smin.add(if (smin.isEmpty()) x else kotlin.math.min(smin.last(), x))
        smax.add(if (smax.isEmpty()) x else kotlin.math.max(smax.last(), x))
    }

    fun pop(): Long {
        val x = s.removeLast()
        smin.removeLast()
        smax.removeLast()

        return x
    }

    fun isEmpty(): Boolean {
        return s.isEmpty()
    }

    fun min(): Long {
        return if (smin.isEmpty()) Long.MAX_VALUE else smin.last()
    }

    fun max(): Long {
        return if (smax.isEmpty()) Long.MIN_VALUE else smax.last()
    }
}

fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }

    var l = 0
    var count = 0L

    // stack for remove item from left
    val stack1 = StackMinMax()

    // stack for push item from right
    val stack2 = StackMinMax()

    fun good(): Boolean {
        val max = maxOf(stack1.max(), stack2.max())
        val min = minOf(stack1.min(), stack2.min())

        return max - min <= k
    }

    fun add(x: Long) {
        stack2.push(x)
    }

    fun remove() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop())
            }
        }
        stack1.pop()
    }

    for (r in 0..a.size - 1) {
        add(a[r])

        while (!good()) {
            remove()
            l++
        }

        count += r - l + 1
    }

    println(count)
}