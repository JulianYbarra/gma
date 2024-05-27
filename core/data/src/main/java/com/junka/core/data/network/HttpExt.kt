package com.junka.core.data.network

import com.junka.core.domain.DataError
import com.junka.core.domain.Result
import retrofit2.HttpException
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.cancellation.CancellationException

suspend inline fun <reified T> safeCall(execute: () -> T): Result<T, DataError.Network> {
    val response = try {
        Result.Success(execute())
    } catch (e : UnknownHostException) {
        e.printStackTrace()
        return Result.Failure(DataError.Network.NO_INTERNET_CONNECTION)
    } catch (e: HttpException) {
        e.printStackTrace()
        return responseToResult(e.code())
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        e.printStackTrace()
        return Result.Failure(DataError.Network.UNKNOWN)
    }
    return response
}

suspend inline fun <reified T> responseToResult(statusCode: Int): Result<T, DataError.Network> {
    return when (statusCode) {
        408 -> Result.Failure(DataError.Network.REQUEST_TIMEOUT)
        429 -> Result.Failure(DataError.Network.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Failure(DataError.Network.SERVER_ERROR)
        else -> Result.Failure(DataError.Network.UNKNOWN)
    }
}