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

import io.vavr.*
import io.vavr.collection.Seq

/**
 * Constructors and sequence() extensions for the Vavr Tuple
 *
 * @author Alex Zuzin (github.com/zvozin)
 */

/**
 * @see Tuple.of
 */
fun <T1> tuple(t1: T1):
        Tuple1<T1> = Tuple.of(t1)

/**
 * @see Tuple.of
 */
fun <T1, T2> tuple(t1: T1, t2: T2):
        Tuple2<T1, T2> = Tuple.of(t1, t2)

/**
 * @see Tuple.of
 */
fun <T1, T2, T3> tuple(t1: T1, t2: T2, t3: T3):
        Tuple3<T1, T2, T3> = Tuple.of(t1, t2, t3)

/**
 * @see Tuple.of
 */
fun <T1, T2, T3, T4> tuple(t1: T1, t2: T2, t3: T3, t4: T4):
        Tuple4<T1, T2, T3, T4> = Tuple.of(t1, t2, t3, t4)

/**
 * @see Tuple.of
 */
fun <T1, T2, T3, T4, T5> tuple(t1: T1, t2: T2, t3: T3, t4: T4, t5: T5):
        Tuple5<T1, T2, T3, T4, T5> = Tuple.of(t1, t2, t3, t4, t5)

/**
 * @see Tuple.of
 */
fun <T1, T2, T3, T4, T5, T6> tuple(t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6):
        Tuple6<T1, T2, T3, T4, T5, T6> = Tuple.of(t1, t2, t3, t4, t5, t6)

/**
 * @see Tuple.of
 */
fun <T1, T2, T3, T4, T5, T6, T7> tuple(t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7):
        Tuple7<T1, T2, T3, T4, T5, T6, T7> = Tuple.of(t1, t2, t3, t4, t5, t6, t7)

/**
 * @see Tuple.of
 */
fun <T1, T2, T3, T4, T5, T6, T7, T8> tuple(t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8):
        Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> = Tuple.of(t1, t2, t3, t4, t5, t6, t7, t8)

/**
 * Creates a Tuple out of a Kotlin Pair
 */
fun <T1, T2> Pair<T1, T2>.tuple():
        Tuple2<T1, T2> = Tuple.of(this.first, this.second)

/**
 * Creates a Kotlin Pair out of a Tuple
 */
fun <T1, T2> Tuple2<T1, T2>.pair():
        Pair<T1, T2> = Pair(this._1, this._2)

/**
 * @see Tuple.of
 */
fun <T1, T2> Map.Entry<T1, T2>.tuple():
        Tuple2<T1, T2> = Tuple.of(this.key, this.value)

operator fun <T1, T2> Tuple2<T1, T2>.component1(): T1 = this._1
operator fun <T1, T2> Tuple2<T1, T2>.component2(): T2 = this._2

operator fun <T1, T2, T3> Tuple3<T1, T2, T3>.component1(): T1 = this._1
operator fun <T1, T2, T3> Tuple3<T1, T2, T3>.component2(): T2 = this._2
operator fun <T1, T2, T3> Tuple3<T1, T2, T3>.component3(): T3 = this._3

operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component1(): T1 = this._1
operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component2(): T2 = this._2
operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component3(): T3 = this._3
operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component4(): T4 = this._4

operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component1(): T1 = this._1
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component2(): T2 = this._2
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component3(): T3 = this._3
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component4(): T4 = this._4
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component5(): T5 = this._5

operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component1(): T1 = this._1
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component2(): T2 = this._2
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component3(): T3 = this._3
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component4(): T4 = this._4
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component5(): T5 = this._5
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component6(): T6 = this._6

operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component1(): T1 = this._1
operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component2(): T2 = this._2
operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component3(): T3 = this._3
operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component4(): T4 = this._4
operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component5(): T5 = this._5
operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component6(): T6 = this._6
operator fun <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7>.component7(): T7 = this._7

operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component1(): T1 = this._1
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component2(): T2 = this._2
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component3(): T3 = this._3
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component4(): T4 = this._4
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component5(): T5 = this._5
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component6(): T6 = this._6
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component7(): T7 = this._7
operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>.component8(): T8 = this._8
