package app.codinguyy.ktorclientsideexample.service

import app.codinguyy.ktorclientsideexample.data.Jokes

interface JokesService {
    suspend fun getRandomJoke(): Jokes
}