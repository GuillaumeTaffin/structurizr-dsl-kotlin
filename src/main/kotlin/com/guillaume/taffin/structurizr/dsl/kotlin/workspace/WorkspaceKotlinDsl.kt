package com.guillaume.taffin.structurizr.dsl.kotlin.workspace

import com.structurizr.Workspace


fun workspace(
    name: String = "",
    description: String = "",
    model: Workspace.() -> Unit = {},
): Workspace = Workspace(name, description).apply(model)