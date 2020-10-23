/*  __    __  __  __    __  ___
 * \  \  /  /    \  \  /  /  __/
 *  \  \/  /  /\  \  \/  /  /
 *   \____/__/  \__\____/__/
 *
 * Copyright 2014-2017 Vavr, http://vavr.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vavr.kotlin

import io.vavr.Value
import io.vavr.collection.HashMap
import io.vavr.collection.HashSet
import io.vavr.collection.LinkedHashMap
import io.vavr.collection.LinkedHashSet
import io.vavr.collection.List
import io.vavr.collection.Map
import io.vavr.collection.Set
import io.vavr.collection.Stream
import io.vavr.collection.TreeMap
import io.vavr.collection.TreeSet

/**
 * Constructors and Kotlin collection converters for the Vavr collection values
 *
 * @author Alex Zuzin (github.com/zvozin)
 */

/**
 * Creates a [List] of the given elements.
 *
 * @see List.of
 */
fun <T> list(vararg t: T):
    List<T> = List.of(*t)

/**
 * Converts a Vavr [Value] (that is, _any_ Vavr data class) into a Kotlin [MutableList].
 */
fun <T> Value<T>.toMutableList():
    MutableList<T> = this.toJavaList().toMutableList()

/**
 * Converts a Kotlin [Iterable] into a Vavr [List].
 *
 * @see List.ofAll
 */
fun <T> Iterable<T>.toVavrList():
    List<T> = List.ofAll(this)

/**
 * Converts a Kotlin [Array] into a Vavr [List].
 *
 * @see List.ofAll
 */
fun <T> Array<T>.toVavrList():
    List<T> = List.ofAll(this.asIterable())

/**
 * Converts a Kotlin [Sequence] into a Vavr [List].
 *
 * @see List.ofAll
 */
fun <T> Sequence<T>.toVavrList():
    List<T> = List.ofAll(this.asIterable())

/**
 * Creates a Vavr [Stream] of the given elements.
 *
 * @see Stream.of
 */
fun <T> stream(vararg t: T):
    Stream<T> = Stream.of(*t)

/**
 * Converts a Kotlin [Iterable] into a Vavr [Stream].
 *
 * @see Stream.ofAll
 */
fun <T> Iterable<T>.toVavrStream():
    Stream<T> = Stream.ofAll(this)

/**
 * Converts a Kotlin [Array] into a Vavr [Stream].
 *
 * @see Stream.ofAll
 */
fun <T> Array<T>.toVavrStream():
    Stream<T> = Stream.ofAll(this.asIterable())

/**
 * Converts a Kotlin [Sequence] into a Vavr [Stream].
 *
 * @see Stream.ofAll
 */
fun <T> Sequence<T>.toVavrStream():
    Stream<T> = Stream.ofAll(this.asIterable())

/**
 * Converts a Kotlin [kotlin.collections.Map] into a Vavr [Map].
 *
 * @see HashMap.ofAll
 */
fun <K, V> kotlin.collections.Map<K, V>.toVavrMap():
    Map<K, V> = HashMap.ofAll(this)

/**
 * Converts a Vavr [Map] to a Kotlin [MutableMap].
 */
fun <K, V> Map<K, V>.toMutableMap():
    MutableMap<K, V> = this.toJavaMap().toMutableMap()

/**
 * Creates a Vavr [HashMap] from a series of Kotlin [Pair]s.
 */
fun <K, V> hashMap(vararg p: Pair<K, V>):
    HashMap<K, V> = HashMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Creates a Vavr [LinkedHashMap] from a series of Kotlin [Pair]s.
 */
fun <K, V> linkedHashMap(vararg p: Pair<K, V>):
    LinkedHashMap<K, V> = LinkedHashMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Creates a Vavr [TreeMap] from a series of Kotlin [Pair]s.
 *
 * Note that the keys of a [TreeMap] must be [Comparable].
 *
 * @param K a [Comparable] key
 * @see TreeMap.ofEntries
 */
fun <K : Comparable<K>, V> treeMap(vararg p: Pair<K, V>):
    TreeMap<K, V> = TreeMap.ofEntries(p.asIterable().map { it.tuple() })

/**
 * Returns the value associated with a key, or null if the key is not contained in the [Map].
 *
 * @see Map.getOrElse
 */
fun <K, V> Map<K, V>.getOrNull(key: K):
    V? = this.getOrElse(key, null)

/**
 * Creates a Vavr [HashSet] of the given elements.
 *
 * @see HashSet.ofAll
 */
fun <T> hashSet(vararg t: T):
    HashSet<T> = HashSet.ofAll(t.asIterable())

/**
 * Converts a Kotlin [Iterable] into a Vavr [Set]
 *
 * @see HashSet.ofAll
 */
fun <T> Iterable<T>.toVavrSet():
    Set<T> = HashSet.ofAll(this)

/**
 * Converts a Kotlin [Array] into a Vavr [Set].
 *
 * @see HashSet.ofAll
 */
fun <T> Array<T>.toVavrSet():
    HashSet<T> = HashSet.ofAll(this.asIterable())

/**
 * Converts a Kotlin [Sequence] into a Vavr [Set].
 *
 * @see HashSet.ofAll
 */
fun <T> Sequence<T>.toVavrSet():
    HashSet<T> = HashSet.ofAll(this.asIterable())

/**
 * Converts a Vavr [Set] into a Kotlin [MutableSet]
 */
fun <T> Set<T>.toMutableSet():
    MutableSet<T> = this.toJavaSet().toMutableSet()

/**
 * Creates a Vavr [LinkedHashSet] of the given elements.
 *
 * @see LinkedHashSet.ofAll
 */
fun <T> linkedHashSet(vararg t: T):
    LinkedHashSet<T> = LinkedHashSet.ofAll(t.asIterable())

/**
 * Converts a Kotlin [Iterable] into a Vavr [LinkedHashSet]
 *
 * @see LinkedHashSet.ofAll
 */
fun <T> Iterable<T>.toVavrLinkedHashSet():
    LinkedHashSet<T> = LinkedHashSet.ofAll(this)

/**
 * Converts a Kotlin [Array] into a Vavr [LinkedHashSet].
 *
 * @see LinkedHashSet.ofAll
 */
fun <T> Array<T>.toVavrLinkedHashSet():
    LinkedHashSet<T> = LinkedHashSet.ofAll(this.asIterable())

/**
 * Converts a Kotlin [Sequence] into a Vavr [LinkedHashSet].
 *
 * @see LinkedHashSet.ofAll
 */
fun <T> Sequence<T>.toVavrLinkedHashSet():
    LinkedHashSet<T> = LinkedHashSet.ofAll(this.asIterable())

/**
 * Creates a Vavr [TreeSet] of the given elements.
 *
 * Note that the elements of a [TreeSet] must be [Comparable].
 *
 * @param t a [Comparable] element
 * @see TreeSet.ofAll
 */
fun <T : Comparable<T>> treeSet(vararg t: T):
    TreeSet<T> = TreeSet.ofAll(t.asIterable())
