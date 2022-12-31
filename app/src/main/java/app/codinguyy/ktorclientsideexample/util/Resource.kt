package app.codinguyy.ktorclientsideexample.util

import app.codinguyy.ktorclientsideexample.data.Jokes

sealed class Resource {
    class NetworkCallSuccess(val data: Jokes) : Resource()
    class NetworkCallError(val exception: Exception) : Resource()
    class NetworkCallLoading() : Resource()
}