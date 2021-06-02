package ru.kalumbas.partyhouse.model

import java.util.*


data class Event (
    var title: String,
    var location: String,
    var description: String,
    var date: Date,
    var price: Double,
    var guests: List<User>
)