package io.vavr.kotlin.issues

import io.vavr.control.Try
import org.junit.Assert.fail
import org.junit.Test

/**
 * Try overload resolution ambiguity
 * https://github.com/vavr-io/vavr-kotlin/issues/17
 */
class Issue17Test {

    @Test
    fun getOrElseThrow_function() {
        try {
            Try.of { name() }.getOrElseThrow { _ -> RuntimeException("missing") }
            fail("Exception should be thrown")
        } catch (e: RuntimeException) {
            assert(e.message == "missing")
        }
    }

    @Test
    fun getOrElseThrow_supplier() {
        try {
            Try.of { name() }.getOrElseThrow { -> RuntimeException("missing") }
            fail("Exception should be thrown")
        } catch (e: RuntimeException) {
            assert(e.message == "missing")
        }
    }

    // Overload resolution ambiguity. All these functions match.
    // public final fun <X : Throwable!> getOrElseThrow(supplier: (() → TypeVariable(X)!)!): String! defined in io.vavr.control.Try
    // public final fun <X : Throwable!> getOrElseThrow(exceptionProvider: ((t: Throwable!) → TypeVariable(X)!)!): String! defined in io.vavr.control.Try
//    @Test
//    fun getOrElseThrow_ambiguity() {
//        try {
//            Try.of { name() }.getOrElseThrow { RuntimeException("missing") }
//            fail("Exception should be thrown")
//        } catch (e: RuntimeException) {
//            assert(e.message == "missing")
//        }
//    }

    private fun name(): String = throw RuntimeException("oops")

}
