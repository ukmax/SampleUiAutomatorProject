package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.*
import org.junit.Assert.assertTrue
import java.util.concurrent.TimeUnit

class PlayMarket : AbstractApplication("com.android.vending") {

    private val searchSelector = byStringRes("com.android.vending:id/search_bar_hint")
    private val searchInputSelector = byStringRes("com.android.vending:id/search_bar_text_input")
    private val installButton = byText("Установить")
    private val openInstalledAppButton = byText("Открыть")

    fun clickSearch() {
        searchSelector.waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        searchInputSelector.waitFindObject().text = text
    }

    fun clickResult(resultName: String) {
        byText(resultName).waitFindObject().click()
    }

    fun clickInstall() {
        installButton.waitFindObject().click()
    }

    fun waitForInstalled() {
        TimeUnit.SECONDS.sleep(5L)
        assertTrue(
            "Приложение не было установлено",
            openInstalledAppButton
                .waitFindObject(10)
                .waitIsClickable(true, 60.secondsToMillis())
        )
    }

    fun openInstalledApp() {
        openInstalledAppButton.findObject().clickAndWaitnewWindow()
    }
}
