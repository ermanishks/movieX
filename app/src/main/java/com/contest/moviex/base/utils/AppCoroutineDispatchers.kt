package com.contest.moviex.base.utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Manish Kumar
 */
data class AppCoroutineDispatchers(
    val io: CoroutineDispatcher,
    val computation: CoroutineDispatcher,
    val main: CoroutineDispatcher
)