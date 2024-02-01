package com.guillaume.taffin.structurizr.dsl.kotlin.workspace

import io.kotest.matchers.maps.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AddingWorkspacePropertiesTest {

    @Test
    fun `Should not contain any properties by default`() {
        val workspace = workspace { }

        workspace.properties shouldBe emptyMap()
    }

    @Test
    fun `Should allow to set properties in workspace`() {
        val workspace = workspace {
            properties(
                "key1" to "value1",
                "key2" to "value2",
            )
        }

        workspace.properties shouldContainExactly mapOf(
            "key1" to "value1",
            "key2" to "value2",
        )
    }
}