package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.ozonScreens.Search
import com.example.sampleuiautomatorproject.application.Ozon
import com.example.sampleuiautomatorproject.ozonScreens.Main
import com.example.sampleuiautomatorproject.ozonScreens.Profile
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class OzonTests : AbstractApplicationTest<Ozon>(Ozon()) {

    @Test
    fun checkSearchHint() = with(app) {
        open()
        Search.clickSearch()
        Search.typeToSearch("философия java")
        Search.checkTitle("Философия Java")
        Search.checkPrice("1 499 \u20BD")
    }

    @Test
    fun checkInvalidEmailMessage() = with(app) {
        open()
        Main.clickProfileButton()
        Profile.clickEnterByEmail()
        Profile.typeEmail("q")
        Profile.clickSubmitButton()
        Profile.checkIfErrorPresent()
        Profile.typeEmail("q@q.q")
        Profile.clickSubmitButton()
        Profile.checkIfNotErrorPresent()
    }
}
