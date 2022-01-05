package com.example.testes_integrados_espresso.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.testes_integrados_espresso.MainActivity
import com.example.testes_integrados_espresso.home.robot.RobotHome
import com.example.testes_integrados_espresso.login.robot.RobotLogin
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TesteLogin {

    private val robotLogin = RobotLogin()
    private val robotHome = RobotHome()

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun testeConfereTextoTituloTelaLogin() {
        robotLogin.checaTitulo()
    }

    @Test
    fun testeDigitacaoEmailLogin() {
        robotLogin.digitaEmail()
        robotLogin.fechaTeclado()
        robotLogin.checaEmail()
    }

    @Test
    fun testeLoginCompleto() {
        robotLogin.digitaEmail()
        robotLogin.fechaTeclado()
        robotLogin.digitaSenhaCorreta()
        robotLogin.fechaTeclado()
        robotLogin.pressionaBotaologar()
        robotHome.verificaMensagemLogado()
    }

    @Test
    fun testeLoginCompletoEVoltaATelaInicial() {
        testeLoginCompleto()
        //Voltando
        robotHome.pressionaBotaoVoltar()
        robotLogin.checaTitulo()
    }
}