package ru.kalumbas.partyhouse.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    var success: Boolean,
    var sessionKey: String?
)