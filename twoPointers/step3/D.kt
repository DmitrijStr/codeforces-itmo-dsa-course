package twoPointers.step3

/*
 * D - Стильная одежда [Stylish clothes]
 * https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/D
 */

fun main() {
    val arr = mutableListOf<Pair<Int, Int>>()

    for (i in 0..3) {
        val x = readln().toInt()

        val a = readln().split(" ").map { it.toInt() }

        for (j in 0..x - 1) {
            arr.add(Pair(a[j], i))
        }
    }

    arr.sortBy { it.first }

    var total = 0
    val count = intArrayOf(0, 0, 0, 0)

    val ansArr = intArrayOf(0, 0, 0, 0)
    var ans = Int.MAX_VALUE
    var ll = 0
    var rr = 0

    var l = 0
    for (r in 0..arr.size - 1) {

        if (count[arr[r].second] == 0) {
            total++
        }

        count[arr[r].second]++

        while (count[arr[l].second] > 1) {
            count[arr[l].second]--
            l++
        }

        if (total > 3 && arr[r].first - arr[l].first < ans) {
            ll = l
            rr = r

            ans = arr[r].first - arr[l].first
        }
    }

    ansArr[arr[ll].second] = arr[ll].first
    ansArr[arr[rr].second] = arr[rr].first

    for (j in ll + 1..rr - 1) {
        if (ansArr[arr[j].second] == 0) {
            ansArr[arr[j].second] = arr[j].first
        }
    }

    println(ansArr.joinToString(" "))
}