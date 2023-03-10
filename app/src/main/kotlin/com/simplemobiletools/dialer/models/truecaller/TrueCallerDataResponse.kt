package com.simplemobiletools.dialer.models.truecaller

data class TrueCallerDataResponse (
    val name: String?,
    val image : String?,
    val addresses: List<TrueCallerAddress>?,
    val phones: List<TrueCallerPhones>?,
)
