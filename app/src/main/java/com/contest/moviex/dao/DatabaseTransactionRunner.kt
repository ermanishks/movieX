package com.contest.moviex.dao

/**
 * Created by Manish Kumar
 */
interface DatabaseTransactionRunner {
    suspend operator fun <T> invoke(block: suspend () -> T): T
}
