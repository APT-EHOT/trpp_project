package ru.kalumbas.partyhouse

import ru.kalumbas.partyhouse.model.User

class Repository {

    companion object {
        lateinit var currentUser: User
        val url = "http://192.168.0.100:5000"
        var sessionKey = ""
    }
}