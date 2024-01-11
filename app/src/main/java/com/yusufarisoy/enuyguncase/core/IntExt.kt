package com.yusufarisoy.enuyguncase.core

fun Int?.orZero(): Int {
    return this ?: 0
}