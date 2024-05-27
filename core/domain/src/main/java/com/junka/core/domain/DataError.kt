package com.junka.core.domain

sealed interface DataError : Error {
    enum class Network : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET_CONNECTION,
        SERVER_ERROR,
        UNKNOWN
    }
}