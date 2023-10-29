package com.example

import kotlin.test.Test
import kotlin.test.assertTrue

class ContainerTest {

    @Test
    fun test() {
        // GIVEN
        val container = Container()

        // WHEN
        container.value = Foo("test")

        // THEN
        assertTrue { container.value.value == "test" }
    }

}