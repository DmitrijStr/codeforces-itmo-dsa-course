package binarySearch.step2

/*
 * D - Детский праздник  [Children Holiday]
 * https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/D
 */

fun main() {
    // a -> speed, b -> count, c -> restTime
    fun cnt(time: Int, worker: Triple<Int, Int, Int>): Int {
        val cycle = worker.first * worker.second + worker.third
        val a = time / cycle * worker.second
        val b = Math.min((time % cycle) / worker.first, worker.second)

        return a + b
    }

    fun isGood(workers: List<Triple<Int, Int, Int>>, mid: Int, m: Int): Boolean {
        var c = 0

        for (worker in workers) {
            c += cnt(mid, worker)
        }

        return c >= m
    }

    fun solve(cnt: Int, time: Int, workers: List<Triple<Int, Int, Int>>) {
        val ans = MutableList<Int>(workers.size) { 0 }
        var tmp = cnt

        println(time)

        for (i in 0..workers.size - 1) {

            if (tmp <= 0) {
                break
            }

            val x = cnt(time, workers[i])
            ans[i] = Math.min(tmp, x)
            tmp -= x
        }

        println(ans.joinToString(" "))
    }

    fun search(m: Int, workers: List<Triple<Int, Int, Int>>): Int {
        var l = -1
        var r = 10000000

        while (r > l + 1) {
            val mid = (l + r) / 2

            if (isGood(workers, mid, m)) {
                r = mid
            } else {
                l = mid
            }
        }

        solve(m, r, workers)
        return r
    }


    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val workers = List<Triple<Int, Int, Int>>(n) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        Triple(a, b, c)
    }

    search(m, workers)
}