package twoPointers.step3

/*
 * H - A-B Рюкзак [A-B Knapsack]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/H
 */

fun main() {
    val (n, m, s, A, B) = readln().split(" ").map { it.toInt() }
    val arrA = readln().split(" ").map { it.toInt() }.sortedDescending()
    val arrB = readln().split(" ").map { it.toInt() }.sortedDescending()

    var currWeight = 0L
    var ans = 0L
    var rA = minOf(n, s / A) - 1

    for (i in 0..rA) {
        ans += arrA[i]
        currWeight += A
    }

    var currSum = ans

    for (r in 0..minOf(m, s / B) - 1) {

        currSum += arrB[r]
        currWeight += B

        while (currWeight > s) {
            currWeight -= A
            currSum -= arrA[rA]

            rA--
        }

        ans = maxOf(ans, currSum)
    }

    println(ans)
}