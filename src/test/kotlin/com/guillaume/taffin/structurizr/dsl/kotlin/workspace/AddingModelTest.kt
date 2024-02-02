package com.guillaume.taffin.structurizr.dsl.kotlin.workspace

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AddingModelTest {

    @Test
    fun `Should have empty model by default`() {
        val workspace = workspace { }

        workspace.model.isEmpty shouldBe true
    }

    @Test
    fun `Should allow to modify empty model`() {
        val workspace = workspace {
            model {

            }
        }

        workspace.model.isEmpty shouldBe true
    }

}