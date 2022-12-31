package app.codinguyy.ktorclientsideexample.di

import app.codinguyy.ktorclientsideexample.repository.Repository
import app.codinguyy.ktorclientsideexample.service.KtorBuilder
import app.codinguyy.ktorclientsideexample.ui.firstfragment.FirstFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {

    viewModel { FirstFragmentViewModel(get()) }
}

val repositories = module {
    single { Repository(get()) }
    single { KtorBuilder() }
}
