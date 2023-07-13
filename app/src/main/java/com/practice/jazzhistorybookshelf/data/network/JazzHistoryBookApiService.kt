package com.practice.jazzhistorybookshelf.data.network

import com.practice.jazzhistorybookshelf.models.JazzHistoryBooks
import retrofit2.http.GET

fun interface JazzHistoryBookApiService {

    @GET("volumes?q=jazz+history")
    suspend fun fetchJazzHistoryBooks(): JazzHistoryBooks
}