package io.vavr.kotlin

import org.junit.Assert.assertTrue
import org.junit.Test

class ControlKtTest {
    @Test
    fun option() {
    }

    @Test
    fun some() {
    }

    @Test
    fun none() {
    }

    @Test
    fun option1() {
    }

    @Test
    fun option2() {
    }

    @Test
    fun sequence() {
    }

    @Test
    fun invalid() {
    }

    @Test
    fun valid() {
    }

    @Test
    fun left() {
    }

    @Test
    fun right() {
    }

    @Test
    fun validation() {
    }

    @Test
    fun sequence1() {
    }

    init {
    }

    @Test
    fun success() {
    }

    @Test
    fun failure() {
    }

    @Test
    fun sequence2() {
    }

    @Test
    fun trying() {
        assertTrue(`try` { throw RuntimeException() }.isFailure)
        assertTrue(`try` { "ok" }.isSuccess)
    }
}