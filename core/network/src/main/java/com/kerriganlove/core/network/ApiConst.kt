package com.kerriganlove.core.network

object ApiConst {

    private const val API_URL = "https://ws.audioscrobbler.com/2.0"

    const val TOP_SONG_LIST_URL = "${API_URL}/?method=chart.gettoptracks&page=100&api_key=${BuildConfig.LAST_FM_API_KEY}&format=json"
}