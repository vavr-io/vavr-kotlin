/*     / \____  _    _  ____   ______  / \ ____  __    _______
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  //  /\__\   JΛVΛSLΛNG
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/ \ /__\ \   Copyright 2014-2017 Javaslang, http://javaslang.io
 * /___/\_/  \_/\____/\_/  \_/\__\/__/\__\_/  \_//  \__/\_____/   Licensed under the Apache License, Version 2.0
 */

package javaslang.kotlin

import javaslang.Value
import javaslang.collection.List
import javaslang.collection.Stream

/**
 * Constructors and Kotlin collection converters for the JΛVΛSLΛNG collection values
 *
 * @author Alex Zuzin (github.com/zvozin)
 */

/**
 * @see List.of
 */
fun <T> list(vararg t: T):
        List<T> = List.of(*t)

/**
 * Converts a Value (that is, _any_ JΛVΛSLΛNG data class) into a Kotlin MutableList
 */
fun <T> Value<T>.toMutableList():
        MutableList<T> = this.toJavaList().toMutableList()

/**
 * Converts a Kotlin Iterable into a List
 */
fun <T> Iterable<T>.toJsList():
        List<T> = List.ofAll(this)

/**
 * Converts a Kotlin Array into a List
 */
fun <T> Array<T>.toJsList():
        List<T> = this.asIterable().toJsList()

/**
 * @see Stream.of
 */
fun <T> stream(vararg t: T):
        Stream<T> = Stream.of(*t)

/**
 * @see Stream.ofAll
 */
fun <T> Iterable<T>.toJsStream():
        Stream<T> = Stream.ofAll(this)

/**
 * Converts a Kotlin Array into a Stream
 */
fun <T> Array<T>.toJsStream():
        Stream<T> = this.asIterable().toJsStream()

/**
 * Converts a Kotlin Map into a Javaslang Map
 */
fun <K, V> kotlin.collections.Map<K, V>.toJsMap():
        javaslang.collection.Map<K, V> = javaslang.collection.HashMap.ofAll(this)

/**
 * Converts a Javaslang Map to a Kotlin MutableMap
 */
fun <K, V> javaslang.collection.Map<K, V>.toMutableMap():
        kotlin.collections.MutableMap<K, V> = this.toJavaMap().toMutableMap()

/**
 * Creates a Javaslang HashMap from a series of Kotlin Pairs
 */
fun <K, V> hashMap(vararg p: Pair<K, V>):
        javaslang.collection.HashMap<K, V> =
        javaslang.collection.HashMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Creates a Javaslang LinkedHashMap from a series of Kotlin Pairs
 */
fun <K, V> linkedHashMap(vararg p: Pair<K, V>):
        javaslang.collection.LinkedHashMap<K, V> =
        javaslang.collection.LinkedHashMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Creates a Javaslang TreeMap from a series of Kotlin Pairs.
 * Notice that the keys of a TreeMap must be Comparable
 */
fun <K : Comparable<K>, V> treeMap(vararg p: Pair<K, V>):
        javaslang.collection.TreeMap<K, V> =
        javaslang.collection.TreeMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Converts a Kotlin Set into a Javaslang Set
 */
fun <T> kotlin.collections.Set<T>.toJsSet():
        javaslang.collection.Set<T> = javaslang.collection.HashSet.ofAll(this)

/**
 * Converts a Javaslang Set into a Kotlin MutableSet
 */
fun <T> javaslang.collection.Set<T>.toMutableSet():
        kotlin.collections.MutableSet<T> = this.toJavaSet().toMutableSet()

/**
 * Creates a Javaslang HashSet
 */
fun <T> hashSet(vararg t: T):
        javaslang.collection.HashSet<T> = javaslang.collection.HashSet.ofAll(t.asIterable())

/**
 * Creates a Javaslang LinkedHashSet
 */
fun <T> linkedHashSet(vararg t: T):
        javaslang.collection.LinkedHashSet<T> = javaslang.collection.LinkedHashSet.ofAll(t.asIterable())

/**
 * Creates a Javaslang TreeSet.
 * Notice that the elements of a TreeSet must be Comparable
 */
fun <T : Comparable<T>> treeSet(vararg t: T):
        javaslang.collection.TreeSet<T> =
        javaslang.collection.TreeSet.ofAll(t.asIterable())