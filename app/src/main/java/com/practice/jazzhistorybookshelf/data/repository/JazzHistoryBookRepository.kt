package com.practice.jazzhistorybookshelf.data.repository

import com.practice.jazzhistorybookshelf.data.network.JazzHistoryBookApiService
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import javax.inject.Inject

interface JazzHistoryBookRepository {

    suspend fun getJazzHistoryBooks(): List<JazzHistoryBook>
    suspend fun getJazzHistoryBook(id: String): JazzHistoryBook
}

class DefaultJazzHistoryBookRepository @Inject constructor(
    private val jazzHistoryBookApiService: JazzHistoryBookApiService
) : JazzHistoryBookRepository {

    override suspend fun getJazzHistoryBooks(): List<JazzHistoryBook> {
        val books = jazzHistoryBookApiService.fetchJazzHistoryBooks()
        return books.items
    }

    override suspend fun getJazzHistoryBook(id: String): JazzHistoryBook {
        return jazzHistoryBookApiService.fetchJazzHistoryBook(id)
    }
}