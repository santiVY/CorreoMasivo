package com.accenture.CorreoMasivo.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LoginGmail {
	
	//Mapeo de variables que necesito enviar por parametros.
	public static Target user = Target.the("Write user").located(By.name("identifier"));
	public static Target password = Target.the("Write password").located(By.name("password"));
}
