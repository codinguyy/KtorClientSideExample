package app.codinguyy.ktorclientsideexample.repository

import androidx.lifecycle.liveData
import app.codinguyy.ktorclientsideexample.service.KtorBuilder
import app.codinguyy.ktorclientsideexample.util.Resource
import kotlinx.coroutines.Dispatchers

class Repository(private val jokesService: KtorBuilder){
    fun getRandomJoke() = liveData(Dispatchers.IO) {
        try {
            emit(Resource.NetworkCallLoading())
            val jokes = jokesService.provideKtorApi().getRandomJoke()
            emit(Resource.NetworkCallSuccess(jokes))
        } catch (exception: Exception) {
            emit(Resource.NetworkCallError(exception))
        }
    }
}
