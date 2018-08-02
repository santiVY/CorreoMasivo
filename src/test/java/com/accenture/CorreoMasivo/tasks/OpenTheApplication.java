package com.accenture.CorreoMasivo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import com.accenture.CorreoMasivo.ui.GmailPage;


public class OpenTheApplication implements Task {

    GmailPage gmailPage;
    
    //el @Step es el reporte que va a parecer en el index.
    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(gmailPage)
        );
    }
}
