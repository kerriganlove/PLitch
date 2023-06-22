package com.kerriganlove.core.network

interface SongService {
    suspend fun getTopSongs() : List<SongsResponse>
}