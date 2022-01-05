package com.example.testes_integrados_espresso.home.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.testes_integrados_espresso.home.constants.ConstantsHome.MSG_LOGADO
import com.example.testes_integrados_espresso.home.constants.ConstantsHome.TEXTO_BTN_VOLTAR

class RobotHome {
    fun verificaMensagemLogado() {
        onView(ViewMatchers.withText(MSG_LOGADO))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun pressionaBotaoVoltar() {
        onView(ViewMatchers.withText(TEXTO_BTN_VOLTAR)).perform(ViewActions.click())
    }

}