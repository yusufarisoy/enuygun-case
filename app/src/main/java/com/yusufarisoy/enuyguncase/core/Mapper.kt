package com.yusufarisoy.enuyguncase.core

interface Mapper<in Input, out Output> {

    fun map(input: Input): Output
}
