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

import io.vavr.CheckedFunction0
import io.vavr.collection.Seq
import io.vavr.control.Either
import io.vavr.control.Option
import io.vavr.control.Option.none
import io.vavr.control.Option.some
import io.vavr.control.Try
import io.vavr.control.Validation

/**
 * Constructors and Kotlin collection extensions for Option, Try, Validation and Either
 *
 * @author Alex Zuzin (github.com/zvozin)
 */

/**
 * Creates an Option of a nullable.
 * @return None() for null, Some(this) for a present value
 */
fun <A> A?.option():
    Option<A> = if (this == null) none() else some(this)

/**
 * @see Option.some
 */
fun <A> some(a: A):
    Option<A> = Option.some(a)

/**
 * @see Option.none
 */
fun <A> none():
    Option<A> = Option.none()

/**
 * Creates an Option predicated on a Boolean, using the supplied value.
 * @return Some(a) if this is true, None() otherwise
 */
fun <A> Boolean.option(a: A):
    Option<A> = if (this) some(a) else none()

/**
 * Creates an Option predicated on a Boolean, using the supplier of value.
 * @return Some(a.invoke()) if this is true, None() otherwise
 */
fun <A> Boolean.option(a: () -> A):
    Option<A> = if (this) some(a.invoke()) else none()

/**
 * @see Option.sequence
 */
fun <T> Iterable<Option<T>>.sequence():
    Option<Seq<T>> = Option.sequence(this)

/**
 * @see Validation.invalid
 */
fun <A, B> invalid(a: A):
    Validation<A, B> = Validation.invalid(a)

/**
 * @see Validation.valid
 */
fun <A, B> valid(b: B):
    Validation<A, B> = Validation.valid(b)

/**
 * @see Either.left
 */
fun <A, B> left(a: A):
    Either<A, B> = Either.left(a)

/**
 * @see Either.right
 */
fun <A, B> right(b: B):
    Either<A, B> = Either.right(b)

/**
 * @see Validation.fromEither
 */
fun <A, B> Either<A, B>.validation():
    Validation<A, B> = Validation.fromEither(this)

/**
 * @see Validation.sequence
 */
fun <T1, T2> Iterable<Validation<Seq<T1>, T2>>.sequence():
    Validation<Seq<T1>, Seq<T2>> = Validation.sequence(this)

/**
 * @see Try.of
 */
fun <A> `try`(f: () -> A):
    Try<A> = Try(f)

/**
 * @see Try.of
 */
fun <A> Try(f: () -> A):
    Try<A> = Try.of(object : CheckedFunction0<A> {
        override fun apply(): A = f()
    })

/**
 * @see Try.success
 */
fun <A> success(a: A):
    Try<A> = Try.success(a)

/**
 * @see Try.failure
 */
fun <A> failure(t: Exception):
    Try<A> = Try.failure(t)

/**
 * @see Try.sequence
 */
fun <T> Iterable<Try<T>>.sequence():
    Try<Seq<T>> = Try.sequence(this)
