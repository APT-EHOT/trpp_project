package ru.kalumbas.partyhouse.model

import java.util.*

data class User(
    val id: Long,
    val name: String,
    val surname: String,
    val dateOfBirthday: Date,
    var rating: Double,
    var about: String,
    var vkLink: String
)