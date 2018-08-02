package com.accenture.CorreoMasivo.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class SendMail {
	//Mapeo de variables que necesito para enviar un correo.
		public static Target Redactar = Target.the("clic in the bottom compose").located(By.xpath("//*[@id=\":kc\"]/div/div"));
		public static Target para = Target.the("Write the Email").located(By.name("to"));
		public static Target asunto = Target.the("Write the submit").located(By.name("subjectbox"));
		public static Target mensaje = Target.the("Write the mesage").located(By.xpath("/html[1]/body[1]/div[26]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]"));
		public static Target enviar = Target.the("Click in the bottom send").located(By.xpath("/html[1]/body[1]/div[26]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]"));
		
}
