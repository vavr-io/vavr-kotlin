@file:Suppress("unused")

package io.javaslang.kotlin

import javaslang.collection.List
import javaslang.collection.Seq
import javaslang.control.Either
import javaslang.control.Option
import javaslang.control.Option.none
import javaslang.control.Option.some
import javaslang.control.Try
import javaslang.control.Validation

/**
 * Option
 */

fun <A> A?.option():
        Option<A> = if (this == null) none() else some(this)

fun <A> Boolean.option(a: A):
        Option<A> = if (this) some(a) else none()

fun <A> Boolean.option(a: () -> A):
        Option<A> = if (this) some(a.invoke()) else none()

fun <T> Iterable<Option<T>>.sequence():
        Option<Seq<T>> = Option.sequence(this)

/**
 * Validation
 */

fun <A, B> Either<A, B>.validation():
        Validation<A, B> = Validation.fromEither(this)

fun <T1, T2> Iterable<Validation<List<T1>, T2>>.sequence():
        Validation<List<T1>, Seq<T2>> = Validation.sequence(this)


/**
 * Try
 */
fun <T> Iterable<Try<T>>.sequence():
        Try<Seq<T>> = Try.sequence(this)