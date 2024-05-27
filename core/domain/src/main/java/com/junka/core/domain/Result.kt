package com.junka.core.domain

sealed interface Result<out D, out E : Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>

    data class Failure<out E : Error>(val error: E) : Result<Nothing, E>
}

inline fun <T, E : Error, R> Result<T, E>.map(transform: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Failure -> Result.Failure(error)
    }
}

fun <T, E : Error> Result<T, E>.asEmptyDataResult() : EmptyResult<E> {
    return map {  }
}

typealias EmptyResult<E> = Result<Unit, E>