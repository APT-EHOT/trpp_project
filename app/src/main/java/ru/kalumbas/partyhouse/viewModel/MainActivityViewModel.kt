package ru.kalumbas.partyhouse.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kalumbas.partyhouse.model.Event

class MainActivityViewModel: ViewModel() {

    private var events = MutableLiveData<List<Event>>()

    fun getInfo(id: Int) {

    }

    fun getEvents(): MutableLiveData<List<Event>> {
        return this.events
    }
}