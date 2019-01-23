package io.vavr.kotlin

import io.vavr.collection.Seq
import io.vavr.control.Either
import io.vavr.control.Option
import io.vavr.control.Try
import io.vavr.control.Validation
import org.junit.Test

class ControlKtTest {

    // -- Option

    @Test
    fun createFromNull() {
        val opt = null.option()
        assert(opt.isEmpty)
    }

    @Test
    fun createFromNonNull() {
        val opt = 1.option()
        assert(opt.get() == 1)
    }

    @Test
    fun createSomeNull() {
        val some = some(null)
        assert(some.isDefined)
    }

    @Test
    fun createSomeNonNull() {
        val some = some(1)
        assert(some.isDefined)
        assert(some.get() != null)
    }

    @Test
    fun createNone() {
        val none: Option<Any> = none()
        assert(none.isEmpty)
    }

    @Test
    fun createOptionFromFalse() {
        assert(false.option(1).isEmpty)
        assert(false.option{1}.isEmpty)
    }

    @Test
    fun createOptionFromTrue() {
        assert(true.option(1).isDefined)
        assert(true.option{1}.isDefined)
    }

    @Test
    fun createOptionFromSequence() {
        val first: Option<Int?> = some(4)
        val second: Option<Int?> = some(null)
        val third: Option<Int?> = none()

        val x1: Option<Seq<Int?>> = list(first, third).sequence()
        assert(x1.isEmpty)

        val x2: Option<Seq<Int?>> = list(first).sequence()
        assert(x2.isDefined)
        assert(x2.get().get(0) == 4)

        val x3: Option<Seq<Int?>> = list(first, second).sequence()
        assert(x3.isDefined)
        assert(x3.get().size() == 2)
    }

    // -- Try

    @Test
    fun createSuccess() {
        val success = success(1)
        assert(success.get() == 1)
        assert(success.isSuccess)
    }

    @Test
    fun createFailure() {
        val failure: Try<Any> = failure(RuntimeException())
        assert(failure.isFailure)
    }

    @Test
    fun trySequence() {
        val x: Try<Seq<Int>> = list(`try`{1}, `try`{1}).sequence()
        assert(x.get().size() == 2)
    }

    @Test
    fun createTry() {
        assert(`try` { throw RuntimeException() }.isFailure)
        assert(`try` { "ok" }.isSuccess)
    }

    // -- Validation & Either

    @Test
    fun createValid() {
        val v: Validation<Int, Float> = valid(4.0f)
        assert(v.isValid)
        assert(v.get() == 4.0f)
    }

    @Test
    fun createInvalid() {
        val v: Validation<Int, Float> = invalid(4)
        assert(v.isInvalid)
        assert(v.error == 4)
    }

    @Test
    fun createValidationFromRightEither() {
        val e: Either<Int, Float> = right(4.0f)
        val v = e.validation()
        assert(v.isValid)
        assert(v.get() == 4.0f)
    }

    @Test
    fun createValidationFromLeftEither() {
        val e: Either<Int, Float> = left(4)
        val v = e.validation()
        assert(v.isInvalid)
        assert(v.error == 4)
    }

    @Test
    fun createValidationFromSequence() {
        val first: Validation<Seq<String>, Int> = valid(4)
        val second: Validation<Seq<String>, Int> = invalid(list("ooops"))

        val x1 = list(first, second).sequence()
        assert(x1.isInvalid)
        assert(x1.error.head() == "ooops")

        val x2 = list(first).sequence()
        assert(x2.isValid)
        assert(x2.get().get(0) == 4)
    }
}