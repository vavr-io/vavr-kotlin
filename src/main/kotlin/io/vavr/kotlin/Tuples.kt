/*                        __    __  __  __    __  ___
 *                       \  \  /  /    \  \  /  /  __/
 *                        \  \/  /  /\  \  \/  /  /
 *                         \____/__/  \__\____/__/.ɪᴏ
 * ᶜᵒᵖʸʳᶦᵍʰᵗ ᵇʸ ᵛᵃᵛʳ ⁻ ˡᶦᶜᵉⁿˢᵉᵈ ᵘⁿᵈᵉʳ ᵗʰᵉ ᵃᵖᵃᶜʰᵉ ˡᶦᶜᵉⁿˢᵉ ᵛᵉʳˢᶦᵒⁿ ᵗʷᵒ ᵈᵒᵗ ᶻᵉʳᵒ
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

/**
 * @see Tuple.sequence1
 */
fun <T1> Iterable<Tuple1<T1>>.sequence():
        Tuple1<Seq<T1>> = Tuple.sequence1(this)

/**
 * @see Tuple.sequence2
 */
fun <T1, T2> Iterable<Tuple2<T1, T2>>.sequence():
        Tuple2<Seq<T1>, Seq<T2>> = Tuple.sequence2(this)

/**
 * @see Tuple.sequence3
 */
fun <T1, T2, T3> Iterable<Tuple3<T1, T2, T3>>.sequence():
        Tuple3<Seq<T1>, Seq<T2>, Seq<T3>> = Tuple.sequence3(this)

/**
 * @see Tuple.sequence4
 */
fun <T1, T2, T3, T4> Iterable<Tuple4<T1, T2, T3, T4>>.sequence():
        Tuple4<Seq<T1>, Seq<T2>, Seq<T3>, Seq<T4>> = Tuple.sequence4(this)

/**
 * @see Tuple.sequence5
 */
fun <T1, T2, T3, T4, T5> Iterable<Tuple5<T1, T2, T3, T4, T5>>.sequence():
        Tuple5<Seq<T1>, Seq<T2>, Seq<T3>, Seq<T4>, Seq<T5>> = Tuple.sequence5(this)

/**
 * @see Tuple.sequence6
 */
fun <T1, T2, T3, T4, T5, T6> Iterable<Tuple6<T1, T2, T3, T4, T5, T6>>.sequence():
        Tuple6<Seq<T1>, Seq<T2>, Seq<T3>, Seq<T4>, Seq<T5>, Seq<T6>> = Tuple.sequence6(this)

/**
 * @see Tuple.sequence7
 */
fun <T1, T2, T3, T4, T5, T6, T7> Iterable<Tuple7<T1, T2, T3, T4, T5, T6, T7>>.sequence():
        Tuple7<Seq<T1>, Seq<T2>, Seq<T3>, Seq<T4>, Seq<T5>, Seq<T6>, Seq<T7>> = Tuple.sequence7(this)

/**
 * @see Tuple.sequence8
 */
fun <T1, T2, T3, T4, T5, T6, T7, T8> Iterable<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>>.sequence():
        Tuple8<Seq<T1>, Seq<T2>, Seq<T3>, Seq<T4>, Seq<T5>, Seq<T6>, Seq<T7>, Seq<T8>> = Tuple.sequence8(this)