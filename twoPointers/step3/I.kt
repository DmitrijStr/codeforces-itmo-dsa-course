package twoPointers.step3

/*
 * I - Отрезок с нужным подмножеством [Segment with the Required Subset]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/I
 */

import java.util.Stack

class SubsetsStack(private val s: Int) {
    private val s1 = Stack<IntArray>()
    private val s2 = Stack<Int>()

    fun add(x: Int) {
        s2.push(x)

        if (s1.isEmpty()) {
            push(initArray(x))
        } else {
            val top = s1.peek()
            val copy = top.copyOf()

            for (i in 0..s) {
                if (top[i] == 1 && i + x <= s) {
                    copy[i + x] = 1
                }
            }

            push(copy)
        }
    }

    fun top(): Int {
        if (s1.isEmpty()) return -1

        return s1.peek()[s]
    }

    fun peek(): IntArray {
        return s1.peek()
    }

    fun push(i: IntArray) {
        s1.push(i)
    }

    fun pop(): Int {
        val x = s2.last()
        s1.pop()
        s2.pop()

        return x
    }


    fun isEmpty(): Boolean {
        return s1.isEmpty()
    }


    private fun initArray(x: Int): IntArray {
        val u = IntArray(s + 1) { 0 }
        u[0] = 1
        u[x] = 1

        return u
    }
}

fun main() {
    var min = Int.MAX_VALUE
    val (n, s) = readln().split(" ").map { it.toInt() }
    val rightStack = SubsetsStack(s)
    val leftStack = SubsetsStack(s)
    val a = readln().split(" ").map { it.toInt() }

    fun good(): Boolean {
        if (!rightStack.isEmpty() && !leftStack.isEmpty()) {
            val topLeft = leftStack.peek()
            val topRight = rightStack.peek()

            for (i in 0..s) {
                if (topLeft[i] == 1 && topRight[s - i] == 1) {
                    return true
                }
            }
        }

        return leftStack.top() == 1 || rightStack.top() == 1
    }

    fun remove() {
        if (leftStack.isEmpty()) {
            while (!rightStack.isEmpty()) {
                leftStack.add(rightStack.pop())
            }
        }

        leftStack.pop()
    }

    var l = 0

    for (r in 0..a.size - 1) {
        rightStack.add(a[r])

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