package twoPointers.step3

/*
 * F - Подстроки из карточек [Card Substrings]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/F
 */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s1 = readln()
    val s2 = readln()

    val count = IntArray(26) { 0 }
    val currCount = IntArray(26) { 0 }

    for (ch in s2) {
        count[ch - 'a']++
    }

    var ans = 0L
    var l = 0

    for (r in 0..s1.length - 1) {

        currCount[s1[r] - 'a']++

        while (currCount[s1[r] - 'a'] > count[s1[r] - 'a']) {
            currCount[s1[l] - 'a']--

            l++
        }

        ans += r - l + 1
    }

    println(ans)
}