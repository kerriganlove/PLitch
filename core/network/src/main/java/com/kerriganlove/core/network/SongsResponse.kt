package com.kerriganlove.core.network

import kotlinx.serialization.Serializable

@Serializable
data class SongsResponse(
    val name : String,
    val playCount : String,
    val listeners : String,
    val artists : List<ArtistResponse>,
)

@JvmInline
@Serializable
value class ArtistResponse(
    val name : String,
)
