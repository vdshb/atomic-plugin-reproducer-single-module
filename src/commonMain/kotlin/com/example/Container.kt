package com.example

import kotlinx.atomicfu.atomic

class Container {

    private val _value = atomic(Foo(""))

    var value: Foo
        get() = _value.value
        set(valueToSet) { _value.value = valueToSet }

}