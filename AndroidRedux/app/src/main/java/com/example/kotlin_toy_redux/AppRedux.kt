package com.example.kotlin_toy_redux

import com.example.toyreduxframework.Action
import com.example.toyreduxframework.Store

class AppRedux private constructor() {
    // Singleton definition
    companion object {

        @Volatile
        private var instance: AppRedux? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: AppRedux().also { instance = it }
            }
    }

    var store: Store<AppState>

    init {
        val initialState = AppState(currentValue = 0)
        this.store = Store(initialState = initialState, reducer = ::counterReducer)
    }

    fun counterReducer(action: Action, appState: AppState): AppState {
        val countAction = (action as? AppAction) ?: return appState
        return when (countAction) {
            is AppAction.Increment -> AppState(appState.currentValue + 1)
            is AppAction.Decrement -> AppState(appState.currentValue - 1)
        }
    }
}
