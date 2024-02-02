package com.guillaume.taffin.structurizr.dsl.kotlin.workspace

import com.guillaume.taffin.structurizr.dsl.kotlin.test
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class EmptyWorkspaceTest {

    @TestFactory
    fun `Should create a workspace`() = listOf(
        "" to "",
        "name" to "",
        "" to "description",
    ).test { (name, description) ->
        val workspace = workspace(name, description)

        workspace.isEmpty shouldBe true
        workspace.name shouldBe name
        workspace.description shouldBe description
    }

    @Test
    fun `Should allow to pass empty closure`() {
        val workspace = workspace {}

        workspace.isEmpty shouldBe true
        workspace.name shouldBe ""
        workspace.description shouldBe ""
    }

    @Test
    fun `Should allow to set name from the model`() {
        val workspace = workspace {
            name = "workspace"
        }

        workspace.name shouldBe "workspace"
    }

    @Test
    fun `Should allow to set description from model`() {
        val workspace = workspace {
            description = "A bootiful workspace"
        }

        workspace.description shouldBe "A bootiful workspace"
    }

}
