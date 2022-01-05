package com.example.testes_integrados_espresso.login.robot

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.testes_integrados_espresso.R
import com.example.testes_integrados_espresso.home.constants.ConstantsHome
import com.example.testes_integrados_espresso.login.constants.ConstantsLogin.EMAIL_LOGIN
import com.example.testes_integrados_espresso.login.constants.ConstantsLogin.SENHA_LOGIN
import com.example.testes_integrados_espresso.login.constants.ConstantsLogin.TITULO

class RobotLogin {

    fun checaTitulo() {
        onView(ViewMatchers.withText(TITULO))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun digitaEmail() {
        onView(ViewMatchers.withId(EDITTEXT_EMAIL_LOGIN_ID))
            .perform(ViewActions.typeText(EMAIL_LOGIN))
    }

    fun fechaTeclado() {
        closeSoftKeyboard()
    }

    fun checaEmail() {
        onView(ViewMatchers.withId(EDITTEXT_EMAIL_LOGIN_ID))
            .check(ViewAssertions.matches(ViewMatchers.withText(EMAIL_LOGIN)))
    }

    fun digitaSenhaCorreta() {
        onView(ViewMatchers.withId(EDITTEXT_PASSWORD_LOGIN_ID))
            .perform(ViewActions.typeText(SENHA_LOGIN))
    }

    fun pressionaBotaologar() {
        onView(ViewMatchers.withId(BTN_LOGAR_ID)).perform(ViewActions.click())

    }

    companion object {
        val EDITTEXT_EMAIL_LOGIN_ID = R.id.edit_txt_email_login
        val EDITTEXT_PASSWORD_LOGIN_ID = R.id.edit_txt_password_login
        val BTN_LOGAR_ID = R.id.button_logar
    }


}