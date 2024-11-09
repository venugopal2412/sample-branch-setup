package com.example.kotlin_toy_redux

import com.example.toyreduxframework.Action

sealed class AppAction: Action {
    object Increment : AppAction()
    object Decrement : AppAction()
}