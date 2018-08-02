
package com.accenture.CorreoMasivo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
//import static org.openqa.selenium.Keys.ENTER;
import com.accenture.CorreoMasivo.ui.SendMail;

public class TaskEmail implements Task {

    
    private final String para;
    private final String asunto;
    private final String mensaje;
    
    
   
    public TaskEmail( String para, String asunto, String mensaje) {
		super();		
		this.para = para;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}

	@Step("Send the email")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        		//cuando es click no se pasa como parametros porque no mando ningun texto.
        		//evento para el click
        		Click.on(SendMail.Redactar),
        		//evento que se realiza para enviar un valor o parametro
                Enter.theValue(para)
                     .into(SendMail.para),
                Enter.theValue(asunto)
                     .into(SendMail.asunto),
                Enter.theValue(mensaje)
                	 .into(SendMail.mensaje),
                Click.on(SendMail.enviar)
                  
        );
    }
	
	//metodo contructor que permite llamar los metodos desde otra clase sin la necesidad de instanciar ningun objeto.
    public static TaskEmail enviarCorreo (String para, String asunto, String mensaje) {
        return instrumented(TaskEmail.class, para, asunto, mensaje);
    }

}
