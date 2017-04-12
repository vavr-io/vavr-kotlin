/*     / \____  _    _  ____   ______  / \ ____  __    _______
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  //  /\__\   JΛVΛSLΛNG
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/ \ /__\ \   Copyright 2014-2017 Javaslang, http://javaslang.io
 * /___/\_/  \_/\____/\_/  \_/\__\/__/\__\_/  \_//  \__/\_____/   Licensed under the Apache License, Version 2.0
 */

@file:Suppress("unused")

package javaslang.kotlin

import javaslang.collection.List
import javaslang.collection.Seq
import javaslang.control.Either
import javaslang.control.Option
import javaslang.control.Option.none
import javaslang.control.Option.some
import javaslang.control.Try
import javaslang.control.Validation

/**
 *
 */
fun <A> A?.option():
        Option<A> = if (this == null) none() else some(this)

/**
 *
 */
fun <A> Boolean.option(a: A):
        Option<A> = if (this) some(a) else none()

/**
 *
 */
fun <A> Boolean.option(a: () -> A):
        Option<A> = if (this) some(a.invoke()) else none()

/**
 *
 */
fun <T> Iterable<Option<T>>.sequence():
        Option<Seq<T>> = Option.sequence(this)


/**
 *
 */
fun <A, B> invalid(a: A):
        Validation<A, B> = Validation.invalid(a)

/**
 *
 */
fun <A, B> valid(b: B):
        Validation<A, B> = Validation.valid(b)


/**
 *
 */
fun <A, B> left(a: A):
        Either<A, B> = Either.left(a)

/**
 *
 */
fun <A, B> right(b: B):
        Either<A, B> = Either.right(b)

/**
 *
 */
fun <A, B> Either<A, B>.validation():
        Validation<A, B> = Validation.fromEither(this)

/**
 *
 */
fun <T1, T2> Iterable<Validation<List<T1>, T2>>.sequence():
        Validation<List<T1>, Seq<T2>> = Validation.sequence(this)

/**
 *
 */
fun <A> `try`(f: () -> A):
        Try<A> = Try.of(f)

/**
 *
 */
fun <A> success(a: A):
        Try<A> = Try.success(a)

/**
 *
 */
fun <A> failure(t: Exception):
        Try<A> = Try.failure(t)

/**
 *
 */
fun <T> Iterable<Try<T>>.sequence():
        Try<Seq<T>> = Try.sequence(this)