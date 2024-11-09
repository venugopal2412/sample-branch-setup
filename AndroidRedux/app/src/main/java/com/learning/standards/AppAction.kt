package com.learning.standards

import com.learning.redux.Action

sealed class AppAction: Action {
    object Increment : AppAction()
    object Decrement : AppAction()
}