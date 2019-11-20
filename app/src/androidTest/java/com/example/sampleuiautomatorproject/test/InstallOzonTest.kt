package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.PlayMarket
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstallOzonTest: AbstractApplicationTest<PlayMarket>(PlayMarket()) {

    @Test
    fun installOzon() = with(app) {
        open()
        clickSearch()
        typeToSearch("ozon - магазин c")
        clickResult("OZON – магазин с бесплатной доставкой")
        clickInstall()
        waitForInstalled()
        openInstalledApp()
    }
}
