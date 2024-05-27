package com.junka.core.presentation.ui

import com.junka.core.domain.DataError

fun DataError.asUiText() : UiText {
    return when(this){
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(R.string.request_timeout)
        DataError.Network.TOO_MANY_REQUESTS -> UiText.StringResource(R.string.to_many_request)
        DataError.Network.NO_INTERNET_CONNECTION -> UiText.StringResource(R.string.no_internet_connection)
        DataError.Network.SERVER_ERROR -> UiText.StringResource(R.string.server_error)
        else -> UiText.StringResource(R.string.unknown_error)
    }
}