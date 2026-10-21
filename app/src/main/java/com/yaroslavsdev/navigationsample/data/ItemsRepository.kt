package com.yaroslavsdev.navigationsample.data

object ItemsRepository {
    val items = listOf<String>(
        "Это первый товар",
        "Вторая карточка",
        "А это третья ;)"
    )

    fun getProductName(id: Int): String {
        if (id in 0..<items.size) {
            return items[id]
        }
        return "Неизвестная карточка"
    }

    fun getSize(): Int {
        return items.size
    }
}