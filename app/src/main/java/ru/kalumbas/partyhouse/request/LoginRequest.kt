package ru.kalumbas.partyhouse.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest (
    val login: String,
    val password: String
)