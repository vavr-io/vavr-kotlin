package io.vavr.kotlin

import io.vavr.*
import io.vavr.collection.Seq
import org.junit.Test

class TuplesKtTest {
    @Test
    fun tuple() {
    }

    @Test
    fun tupleOf1() {
        val t: Tuple1<Int> = tuple(1)
        assert(t._1 == 1)
    }

    @Test
    fun tupleOf2() {
        val t: Tuple2<Int, Int> = tuple(1, 2)
        assert(t._1 == 1)
        assert(t._2 == 2)
    }

    @Test
    fun tupleOf3() {
        val t: Tuple3<Int, Int, Int> = tuple(1, 2, 3)
        assert(t._1 == 1)
        assert(t._2 == 2)
        assert(t._3 == 3)
    }

    @Test
    fun tupleOf4() {
        val t: Tuple4<Int, Int, Int, Int> = tuple(1, 2, 3, 4)
        assert(t._1 == 1)
        assert(t._2 == 2)
        assert(t._3 == 3)
        assert(t._4 == 4)
    }

    @Test
    fun tupleOf5() {
        val t: Tuple5<Int, Int, Int, Int, Int> = tuple(1, 2, 3, 4, 5)
        assert(t._1 == 1)
        assert(t._2 == 2)
        assert(t._3 == 3)
        assert(t._4 == 4)
        assert(t._5 == 5)
    }

    @Test
    fun tupleOf6() {
        val t: Tuple6<Int, Int, Int, Int, Int, Int> = tuple(1, 2, 3, 4, 5, 6)
        assert(t._1 == 1)
        assert(t._2 == 2)
        assert(t._3 == 3)
        assert(t._4 == 4)
        assert(t._5 == 5)
        assert(t._6 == 6)
    }

    @Test
    fun tupleOf7() {
        val t: Tuple7<Int, Int, Int, Int, Int, Int, Int> = tuple(1, 2, 3, 4, 5, 6, 7)
        assert(t._1 == 1)
        assert(t._2 == 2)
        assert(t._3 == 3)
        assert(t._4 == 4)
        assert(t._5 == 5)
        assert(t._6 == 6)
        assert(t._7 == 7)
    }

    @Test
    fun tupleOf8() {
        val t: Tuple8<Int, Int, Int, Int, Int, Int, Int, Int> = tuple(1, 2, 3, 4, 5, 6, 7, 8)
        assert(t._1 == 1)
        assert(t._2 == 2)
        assert(t._3 == 3)
        assert(t._4 == 4)
        assert(t._5 == 5)
        assert(t._6 == 6)
        assert(t._7 == 7)
        assert(t._8 == 8)
    }

    @Test
    fun pair() {
        val p = tuple(1, 2).pair()
        assert(p.first == 1)
        assert(p.second == 2)
    }

    @Test
    fun tupleOfPair() {
        val t = Pair(1, 2).tuple()
        assert(t._1 == 1)
        assert(t._2 == 2)
    }

    @Test
    fun tupleOfEntry() {
        val e: Map.Entry<Int, Int> = mapOf(Pair(1, 2)).entries.iterator().next()
        val t = e.tuple()
        assert(t._1 == 1)
        assert(t._2 == 2)
    }

    @Test
    fun sequence1() {
        val t1 = tuple(1)
        val t2 = tuple(2)
        val t: Tuple1<Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
    }

    @Test
    fun sequence2() {
        val t1 = tuple(1, 2)
        val t2 = tuple(2, 3)
        val t: Tuple2<Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
    }

    @Test
    fun sequence3() {
        val t1 = tuple(1, 2, 3)
        val t2 = tuple(2, 3, 4)
        val t: Tuple3<Seq<Int>, Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
        assert(t._3 == list(3, 4))
    }

    @Test
    fun sequence4() {
        val t1 = tuple(1, 2, 3, 4)
        val t2 = tuple(2, 3, 4, 5)
        val t: Tuple4<Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
        assert(t._3 == list(3, 4))
        assert(t._4 == list(4, 5))
    }

    @Test
    fun sequence5() {
        val t1 = tuple(1, 2, 3, 4, 5)
        val t2 = tuple(2, 3, 4, 5, 6)
        val t: Tuple5<Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
        assert(t._3 == list(3, 4))
        assert(t._4 == list(4, 5))
        assert(t._5 == list(5, 6))
    }

    @Test
    fun sequence6() {
        val t1 = tuple(1, 2, 3, 4, 5, 6)
        val t2 = tuple(2, 3, 4, 5, 6, 7)
        val t: Tuple6<Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
        assert(t._3 == list(3, 4))
        assert(t._4 == list(4, 5))
        assert(t._5 == list(5, 6))
        assert(t._6 == list(6, 7))
    }

    @Test
    fun sequence7() {
        val t1 = tuple(1, 2, 3, 4, 5, 6, 7)
        val t2 = tuple(2, 3, 4, 5, 6, 7, 8)
        val t: Tuple7<Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
        assert(t._3 == list(3, 4))
        assert(t._4 == list(4, 5))
        assert(t._5 == list(5, 6))
        assert(t._6 == list(6, 7))
        assert(t._7 == list(7, 8))
    }

    @Test
    fun sequence8() {
        val t1 = tuple(1, 2, 3, 4, 5, 6, 7, 8)
        val t2 = tuple(2, 3, 4, 5, 6, 7, 8, 9)
        val t: Tuple8<Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>, Seq<Int>> = list(t1, t2).sequence()
        assert(t._1 == list(1, 2))
        assert(t._2 == list(2, 3))
        assert(t._3 == list(3, 4))
        assert(t._4 == list(4, 5))
        assert(t._5 == list(5, 6))
        assert(t._6 == list(6, 7))
        assert(t._7 == list(7, 8))
        assert(t._8 == list(8, 9))
    }

    @Test
    fun components2() {
        val (v1, v2) = tuple(1, 2)
        assert(v1 == 1)
        assert(v2 == 2)
    }

    @Test
    fun components3() {
        val (v1, v2, v3) = tuple(1, 2, 3)
        assert(v1 == 1)
        assert(v2 == 2)
        assert(v3 == 3)
    }

    @Test
    fun components4() {
        val (v1, v2, v3, v4) = tuple(1, 2, 3, 4)
        assert(v1 == 1)
        assert(v2 == 2)
        assert(v3 == 3)
        assert(v4 == 4)
    }

    @Test
    fun components5() {
        val (v1, v2, v3, v4, v5) = tuple(1, 2, 3, 4, 5)
        assert(v1 == 1)
        assert(v2 == 2)
        assert(v3 == 3)
        assert(v4 == 4)
        assert(v5 == 5)
    }

    @Test
    fun components6() {
        val (v1, v2, v3, v4, v5, v6) = tuple(1, 2, 3, 4, 5, 6)
        assert(v1 == 1)
        assert(v2 == 2)
        assert(v3 == 3)
        assert(v4 == 4)
        assert(v5 == 5)
        assert(v6 == 6)
    }

    @Test
    fun components7() {
        val (v1, v2, v3, v4, v5, v6, v7) = tuple(1, 2, 3, 4, 5, 6, 7)
        assert(v1 == 1)
        assert(v2 == 2)
        assert(v3 == 3)
        assert(v4 == 4)
        assert(v5 == 5)
        assert(v6 == 6)
        assert(v7 == 7)
    }

    @Test
    fun components8() {
        val (v1, v2, v3, v4, v5, v6, v7, v8) = tuple(1, 2, 3, 4, 5, 6, 7, 8)
        assert(v1 == 1)
        assert(v2 == 2)
        assert(v3 == 3)
        assert(v4 == 4)
        assert(v5 == 5)
        assert(v6 == 6)
        assert(v7 == 7)
        assert(v8 == 8)
    }
}