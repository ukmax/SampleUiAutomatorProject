package com.example.sampleuiautomatorproject.ozonScreens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitHasObject
import com.example.sampleuiautomatorproject.util.ext.waitUntillGone
import org.junit.Assert

class Profile {

    companion object {
        private val enterByEmailSelector = byText("Войти по почте")
        private val emailInputSelector = byStringRes("ru.ozon.app.android:id/emailEt")
        private val emailInputErrorSelector = byText("Некорректный формат почты")
        private val submitButtonSelector = byStringRes("ru.ozon.app.android:id/submitBtn")


        fun clickEnterByEmail() {
            enterByEmailSelector.waitFindObject().click()
        }

        fun typeEmail(text: String) {
            emailInputSelector.waitFindObject().text = text
        }

        fun clickSubmitButton() {
            submitButtonSelector.waitFindObject().click()
        }

        fun checkIfErrorPresent() {
            Assert.assertTrue(
                "ошибка не показана для невалидного email",
                emailInputErrorSelector.waitHasObject()
            )
        }

        fun checkIfNotErrorPresent() {
            Assert.assertTrue(
                "ошибка не исчезла для валидного email",
                emailInputErrorSelector.waitUntillGone()
            )
        }

    }


}