package app.codinguyy.ktorclientsideexample.ui.firstfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import app.codinguyy.ktorclientsideexample.repository.Repository
import app.codinguyy.ktorclientsideexample.util.Resource

class FirstFragmentViewModel(private val repository: Repository): ViewModel() {

    fun getRandomJoke(): LiveData<Resource> {
        return repository.getRandomJoke()
    }

}