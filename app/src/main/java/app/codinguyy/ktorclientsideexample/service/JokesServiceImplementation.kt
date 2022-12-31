package app.codinguyy.ktorclientsideexample.service

import app.codinguyy.ktorclientsideexample.data.Jokes
import app.codinguyy.ktorclientsideexample.util.Constants
import io.ktor.client.*
import io.ktor.client.request.*

class JokesServiceImplementation(private val client: HttpClient):JokesService {

    override suspend fun getRandomJoke(): Jokes {
        return try {
            client.get {
                url(Constants.JOKES)
                // parameter()...
            }
        } catch (exception: Exception) {
            Jokes(exception.toString())
        }
    }
}