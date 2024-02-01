package com.guillaume.taffin.structurizr.dsl.kotlin

import org.junit.jupiter.api.DynamicTest

fun <T> Iterable<T>.test(bloc: (T) -> Unit): List<DynamicTest> = this.map {
    DynamicTest.dynamicTest(it.toString()) { bloc(it) }
}