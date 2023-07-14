package com.practice.jazzhistorybookshelf.data.network

import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import com.practice.jazzhistorybookshelf.models.JazzHistoryBooks
import retrofit2.http.GET
import retrofit2.http.Path

interface JazzHistoryBookApiService {

    @GET("volumes?q=jazz+history")
    suspend fun fetchJazzHistoryBooks(): JazzHistoryBooks
    @GET("volumes/{id}")
    suspend fun fetchJazzHistoryBook(@Path("id") id: String): JazzHistoryBook
}