package twoPointers.step3

/*
 * G - Не очень грубая подстрока [Not Very Rude Substring]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/G
 */

fun main() {
    val (n, c) = readln().split(" ").map { it.toLong() }
    val s = readln()

    var countA = 0L
    var countB = 0L
    var sum = 0L


    var ans = 0
    var l = 0

    for (r in 0..s.length - 1) {

        if (s[r] == 'a') {
            countA++
        }
        if (s[r] == 'b') {
            countB++

            sum += countA
        }

        while (sum > c) {
            if (s[l] == 'a') {
                sum -= countB
                countA--
            }
            if (s[l] == 'b') {
                countB--
            }

            l++
        }

        if (r - l + 1 > ans) {
            ans = r - l + 1
        }
    }

    println(ans)
}