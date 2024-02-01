package com.guillaume.taffin.structurizr.dsl.kotlin

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DummyTest {

    @Test
    fun dummy() {
        Dummy().hello() shouldBe "hello"
    }
}