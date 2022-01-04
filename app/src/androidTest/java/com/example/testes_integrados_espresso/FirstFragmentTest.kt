package com.example.testes_integrados_espresso

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FirstFragmentTest : TestCase(){

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.testes_integrados_espresso", appContext.packageName)
    }

    @Test
    fun testeConfereTextoTituloTelaLogin() {
        onView(withText("App para Testes")).check(matches(isDisplayed()))
    }

    @Test
    fun testeDigitacaoEmailLogin() {
        onView(withId(R.id.edit_txt_email_login)).perform(typeText("joao@email.com"))
        closeSoftKeyboard()
        onView(withId(R.id.edit_txt_email_login)).check(matches(withText("joao@email.com")))
    }

    @Test
    fun testeDigitacaoSenhaLogin() {
        onView(withId(R.id.edit_txt_password_login)).perform(typeText("321"))
        closeSoftKeyboard()
    }

    @Test
    fun testeclickBotaologar(){
        onView(withId(R.id.button_first)).perform(click())
    }

    @Test
    fun testeLoginCompleto(){
        onView(withId(R.id.edit_txt_email_login)).perform(typeText("joao@email.com"))
        closeSoftKeyboard()
        onView(withId(R.id.edit_txt_password_login)).perform(typeText("321"))
        closeSoftKeyboard()
        onView(withId(R.id.button_first)).perform(click())
        onView(withText("Logado")).check(matches(isDisplayed()))
    }

    @Test
    fun testeLoginCompletoEVoltaATelaInicial(){
        onView(withId(R.id.edit_txt_email_login)).perform(typeText("joao@email.com"))
        closeSoftKeyboard()
        onView(withId(R.id.edit_txt_password_login)).perform(typeText("321"))
        closeSoftKeyboard()
        onView(withId(R.id.button_first)).perform(click())
        onView(withText("Logado")).check(matches(isDisplayed()))
        //Voltando
        onView(withText("Voltar")).perform(click())
        onView(withText("App para Testes")).check(matches(isDisplayed()))

    }

}