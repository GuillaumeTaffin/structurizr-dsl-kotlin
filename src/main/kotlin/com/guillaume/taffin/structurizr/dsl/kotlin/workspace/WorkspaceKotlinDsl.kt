package com.guillaume.taffin.structurizr.dsl.kotlin.workspace

import com.structurizr.Workspace
import com.structurizr.model.Model


fun workspace(
    name: String = "",
    description: String = "",
    model: Workspace.() -> Unit = {},
): Workspace = Workspace(name, description).apply(model)

fun Workspace.properties(vararg properties: Pair<String, String>) = properties.forEach {
    this.addProperty(it.first, it.second)
}

fun Workspace.model(bloc: Model.() -> Unit) {
}