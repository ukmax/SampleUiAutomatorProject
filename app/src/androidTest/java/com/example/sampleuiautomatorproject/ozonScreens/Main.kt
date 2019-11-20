package com.example.sampleuiautomatorproject.ozonScreens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject


class Main {

    companion object {
        private val profileButtonSelector = byStringRes("ru.ozon.app.android:id/menu_profile")

        fun clickProfileButton() {
            profileButtonSelector.waitFindObject().click()
        }

    }
}