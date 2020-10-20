package io.vavr.kotlin

import org.junit.Test

class CollectionsKtTest {
    @Test
    fun list() {
        val list: io.vavr.collection.List<Int> = list(1, 2, 3)
        assert(list.size() == 3)
    }

    @Test
    fun toMutableList() {
        val mutableList: List<Int> = list(1, 2, 3).toMutableList()
        assert(mutableList.size == 3)
    }

    @Test
    fun toVavrList1() {
        val vavrList: io.vavr.collection.List<Int> = listOf(1, 2, 3).toVavrList()
        assert(vavrList.size() == 3)
    }

    @Test
    fun toVavrList2() {
        val vavrList: io.vavr.collection.List<Int> = arrayOf(1, 2, 3).toVavrList()
        assert(vavrList.size() == 3)
    }

    @Test
    fun stream() {
        val stream: io.vavr.collection.Stream<Int> = stream(1, 2, 3)
        assert(stream.size() == 3)
    }

    @Test
    fun toVavrStream1() {
        val vavrStream: io.vavr.collection.Stream<Int> = listOf(1, 2, 3).toVavrStream()
        assert(vavrStream.size() == 3)
    }

    @Test
    fun toVavrStream2() {
        val vavrStream: io.vavr.collection.Stream<Int> = arrayOf(1, 2, 3).toVavrStream()
        assert(vavrStream.size() == 3)
    }

    @Test
    fun toVavrStream3() {
        val vavrStream: io.vavr.collection.Stream<Int> = generateSequence(1, { i -> i + 1 }).take(3).toVavrStream()
        assert(vavrStream.size() == 3)
    }

    @Test
    fun toVavrMap() {
        val vavrMap: io.vavr.collection.Map<Int, Int> = hashMapOf(Pair(1, 2)).toVavrMap()
        assert(vavrMap.get(1).get() == 2)
    }

    @Test
    fun toMutableMap() {
        val mutableMap: Map<Int, Int> = io.vavr.collection.HashMap.of(1, 2).toMutableMap()
        assert(mutableMap[1] == 2)
    }

    @Test
    fun hashMap() {
        val vavrMap: io.vavr.collection.HashMap<Int, Int> = hashMap(Pair(1, 2))
        assert(vavrMap.get(1).get() == 2)
    }

    @Test
    fun linkedHashMap() {
        val vavrMap: io.vavr.collection.LinkedHashMap<Int, Int> = linkedHashMap(Pair(1, 2))
        assert(vavrMap.get(1).get() == 2)
    }

    @Test
    fun treeMap() {
        val vavrMap: io.vavr.collection.Map<Int, Int> = treeMap(Pair(1, 2))
        assert(vavrMap.get(1).get() == 2)
    }

    @Test
    fun toVavrSet() {
        val vavrSet: io.vavr.collection.Set<Int> = hashSetOf(1, 2, 3).toVavrSet()
        assert(vavrSet.size() == 3)
    }

    @Test
    fun toMutableSet() {
        val mutableSet: Set<Int> = io.vavr.collection.HashSet.of(1, 2, 3).toMutableSet()
        assert(mutableSet.size == 3)
    }

    @Test
    fun hashSet() {
        val vavrSet: io.vavr.collection.HashSet<Int> = hashSet(1, 2, 3)
        assert(vavrSet.size() == 3)
    }

    @Test
    fun linkedHashSet() {
        val vavrSet: io.vavr.collection.LinkedHashSet<Int> = linkedHashSet(1, 2, 3)
        assert(vavrSet.size() == 3)
    }

    @Test
    fun treeSet() {
        val vavrSet: io.vavr.collection.TreeSet<Int> = treeSet(1, 2, 3)
        assert(vavrSet.size() == 3)
    }

    @Test
    fun getOrNull() {
        assert(hashMap(Pair(1, 2)).getOrNull(1) == 2)
        assert(hashMap(Pair(1, 2)).getOrNull(2) == null)
    }
}
