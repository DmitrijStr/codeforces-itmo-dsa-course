package binarySearch.step2

/*
 * H - Гамбургеры [Hamburgers]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/H
 */

fun isGood(recipe: IntArray, counts: List<Int>, prices: List<Int>, money: Long, m: Long): Boolean {
    val bread = prices[0] * Math.min(counts[0] - recipe[0] * m, 0)
    val sausage = prices[1] * Math.min(counts[1] - recipe[1] * m, 0)
    val cheese = prices[2] * Math.min(counts[2] - recipe[2] * m, 0)

    return money + bread + sausage + cheese >= 0
}

fun search(rec: String, counts: List<Int>, prices: List<Int>, money: Long): Long {
    val ingredients = IntArray(3) { 0 }
    for (ch in rec) {
        when (ch) {
            'B' -> ingredients[0]++
            'S' -> ingredients[1]++
            'C' -> ingredients[2]++
        }
    }
    var l = 0L
    var r = money + 301

    while (r > l + 1) {

        val mid = (l + r) / 2

        if (isGood(ingredients, counts, prices, money, mid)) {
            l = mid
        } else {
            r = mid
        }
    }

    return l
}

fun main() {
    val recipe = readln()
    val counts = readln().split(" ").map { it.toInt() }
    val prices = readln().split(" ").map { it.toInt() }
    val r = readln().toLong()

    val ans = search(recipe, counts, prices, r)
    println(ans)
}