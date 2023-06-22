package com.kerriganlove.core.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.request
import javax.inject.Inject

class SongServiceImpl @Inject constructor(
    private val client : HttpClient
) : SongService {
    override suspend fun getTopSongs(): List<SongsResponse> {
        return try {
            client.get { url(ApiConst.TOP_SONG_LIST_URL) }.body()
        }
        catch (e : RedirectResponseException) {
            emptyList()
        }
        catch (e : ClientRequestException) {
            emptyList()
        }
        catch (e : ServerResponseException) {
            emptyList()
        }
    }

}