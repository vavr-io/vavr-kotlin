package io.vavr.kotlin

import org.junit.Test

class CollectionsKtTest {
    @Test
    fun list() {
        val list = list(1, 2, 3)
        assert(list.size() == 3)
    }

    @Test
    fun toMutableList() {
        val mutableList = list(1, 2, 3).toMutableList()
        assert(mutableList.size == 3)
    }

    @Test
    fun toVavrList() {
        val vavrList = listOf(1, 2, 3).toVavrList()
        assert(vavrList.size() == 3)
    }

    @Test
    fun stream() {
        val stream = stream(1, 2, 3)
        assert(stream.size() == 3)
    }

    @Test
    fun toJsStream() {
    }

    @Test
    fun toJsStream1() {
    }

    @Test
    fun toJsMap() {
    }

    @Test
    fun toMutableMap() {
    }

    @Test
    fun hashMap() {
    }

    @Test
    fun linkedHashMap() {
    }

    @Test
    fun treeMap() {
    }

    @Test
    fun toJsSet() {
    }

    @Test
    fun toMutableSet() {
    }

    @Test
    fun hashSet() {
    }

    @Test
    fun linkedHashSet() {
    }

    @Test
    fun treeSet() {
    }
}