package com.practice.jazzhistorybookshelf.data

import com.practice.jazzhistorybookshelf.models.*

object DataSource {

    val book1 = JazzHistoryBook(
        kind = "books#volume",
        id = "ubERDAAAQBAJ",
        etag = "ioRAwVN2x1k",
        selfLink = "https://www.googleapis.com/books/v1/volumes/ubERDAAAQBAJ",
        volumeInfo = VolumeInfo(
            title = "The History of Jazz",
            authors = listOf("Ted Gioia"),
            publisher = "Oxford University Press",
            publishedDate = "2011-05-09",
            description = "A panoramic history of the genre brings to life the diverse places in which jazz evolved, traces the origins of its various styles, and offers commentary on the music itself.",
            industryIdentifiers = listOf(
                IndustryIdentifier(
                    type = "ISBN_13",
                    identifier = "9780195399707"
                ),
                IndustryIdentifier(
                    type = "ISBN_10",
                    identifier = "0195399706"
                )
            ),
            readingModes = ReadingModes(text = false, image = true),
            pageCount = 453,
            printType = "BOOK",
            categories = listOf("Music"),
            maturityRating = "NOT_MATURE",
            allowAnonLogging = false,
            contentVersion = "1.1.1.0.preview.1",
            panelizationSummary = PanelizationSummary(
                containsEpubBubbles = false,
                containsImageBubbles = false
            ),
            imageLinks = ImageLinks(
                smallThumbnail = "http://books.google.com/books/content?id=ubERDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                thumbnail = "http://books.google.com/books/content?id=ubERDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            ),
            language = "en",
            previewLink = "http://books.google.com/books?id=ubERDAAAQBAJ&printsec=frontcover&dq=jazz+history&hl=&cd=1&source=gbs_api",
            infoLink = "http://books.google.com/books?id=ubERDAAAQBAJ&dq=jazz+history&hl=&source=gbs_api",
            canonicalVolumeLink = "https://books.google.com/books/about/The_History_of_Jazz.html?hl=&id=ubERDAAAQBAJ"
        ),
        saleInfo = SaleInfo(
            country = "PK",
            saleability = "NOT_FOR_SALE",
            isEbook = false
        ),
        accessInfo = AccessInfo(
            country = "PK",
            viewability = "PARTIAL",
            embeddable = true,
            publicDomain = false,
            textToSpeechPermission = "ALLOWED",
            epub = Epub(isAvailable = false),
            pdf = PDF(
                isAvailable = true,
                acsTokenLink = "http://books.google.com/books/download/The_History_of_Jazz-sample-pdf.acsm?id=ubERDAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
            ),
            webReaderLink = "http://play.google.com/books/reader?id=ubERDAAAQBAJ&hl=&source=gbs_api",
            accessViewStatus = "SAMPLE",
            quoteSharingAllowed = false
        ),
        searchInfo = SearchInfo(textSnippet = "A panoramic history of the genre brings to life the diverse places in which jazz evolved, traces the origins of its various styles, and offers commentary on the music itself.")
    )
    val book2 = book1.copy(id = "asbce3")
    val book3 = book1.copy(id = "rivn2")

    val books = listOf(book1, book2, book3)
}