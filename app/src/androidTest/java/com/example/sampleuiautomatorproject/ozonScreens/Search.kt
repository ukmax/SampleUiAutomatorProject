package com.example.sampleuiautomatorproject.ozonScreens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import org.junit.Assert

class Search {

    companion object {
        private val searchSelector = byStringRes("ru.ozon.app.android:id/searchTv")
        private val searchInputSelector = byStringRes("ru.ozon.app.android:id/search_src_text")
        private val searchResultTitleSelector = byText("Философия Java")
        private val searchResultPriceSelector = byStringRes("ru.ozon.app.android:id/priceTv")
        fun clickSearch() {
            searchSelector.waitFindObject().click()
        }

        fun typeToSearch(text: String) {
            searchInputSelector.waitFindObject().text = text
        }

        fun checkPrice(price: String) {
            Assert.assertEquals(
                "сумма не прошла проверку",
                price,
                searchResultPriceSelector.waitFindObject().text
            )
        }

        fun checkTitle(title: String) {
            Assert.assertEquals(
                "название товара не прошло проверку",
                title,
                searchResultTitleSelector.waitFindObject().text
            )
        }
    }


}