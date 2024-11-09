package com.learning.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Store<State>(initialState: State, reducer: Reducer<State>) {
    var state: State
    val publisher: StateFlow<State>

    internal var reducer: Reducer<State>
    internal var dispatcher: Dispatch<Action>

    private val _publisher: MutableStateFlow<State>

    init {
        this.state = initialState
        this._publisher = MutableStateFlow(initialState)
        this.publisher = this._publisher.asStateFlow()
        this.reducer = reducer
        this.dispatcher = ::dispatcher
    }

    fun dispatch(action: Action) {
        this.dispatcher(action)
    }

    private fun dispatcher(action: Action) {
        state = reducer(action, state)
        _publisher.value = state
    }
}