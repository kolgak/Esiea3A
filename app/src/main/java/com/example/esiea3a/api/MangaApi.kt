package com.example.esiea3a.api

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Headers


interface MangaApi {
        @Headers(
                "x-rapidapi-key: 83839f1acbmshaa7449c863cc6eap188800jsn509f2462ab29",
                "x-rapidapi-host: jikan1.p.rapidapi.com"
        )
        @GET("anime/21/episodes")
        fun getMangaList(): Call<MangaResponse>
}