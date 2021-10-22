package com.w4eret1ckrtb1tch.focusstart.kaspresso.screen

@Repeatable
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class TestCase(val name: String, val description: String = "")