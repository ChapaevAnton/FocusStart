package com.w4eret1ckrtb1tch.focusstart.utils

fun <T> unsafeLazy(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)