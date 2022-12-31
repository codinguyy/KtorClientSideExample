package app.codinguyy.ktorclientsideexample

import android.app.Application
import app.codinguyy.ktorclientsideexample.di.repositories
import app.codinguyy.ktorclientsideexample.di.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KtorClientApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KtorClientApplication)
            modules(repositories, viewModules)
        }
    }
}
