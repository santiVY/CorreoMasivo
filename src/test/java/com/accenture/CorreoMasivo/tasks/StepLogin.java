package com.accenture.CorreoMasivo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import com.accenture.CorreoMasivo.ui.LoginGmail;


public class StepLogin implements Task {

    private final String usuario;
    private final String clave;
    

    protected StepLogin(String usuario,String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Step("Open the Gmail")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario)
                     .into(LoginGmail.user)
                     .thenHit(ENTER),
                     Enter.theValue(clave)
                     .into(LoginGmail.password)
                     .thenHit(ENTER)                     
        );
    }

    public static StepLogin login (String usuario,String clave) {
        return instrumented(StepLogin.class, usuario, clave);
    }

}
