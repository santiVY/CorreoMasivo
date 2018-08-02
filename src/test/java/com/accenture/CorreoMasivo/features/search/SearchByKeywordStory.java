//Clase principal es a la que tiene la notacion @RunWith siempre se ejecuta primero

package com.accenture.CorreoMasivo.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.accenture.CorreoMasivo.tasks.OpenTheApplication;
import com.accenture.CorreoMasivo.tasks.ReadExcel;
import com.accenture.CorreoMasivo.tasks.StepLogin;
import com.accenture.CorreoMasivo.tasks.TaskEmail;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {
	
    Actor santiago = Actor.named("Santiago");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        santiago.can(BrowseTheWeb.with(herBrowser));
        herBrowser.manage().window().maximize();
    }

    @Test
    public void search_results_should_show_the_search_term_in_the_title() {
    	
    	//Precodindiciones, lo necesario para ejecutarla automatización ( lo que tiene que pasar antes para correr los paso que defina para automatizar)
        givenThat(santiago).wasAbleTo(openTheApplication);
        
        //Acciones de automatización.
        //when(santiago).attemptsTo(Search.forTheTerm("BDD In Action"));
        when(santiago).attemptsTo(StepLogin.login("Email", "Password"));
        
        
        //Se realiza un array que recorra los correos que se obtuvieron de la clase ReadExcel y se ejecuta el metodo when por cada nombre del array
        ArrayList<String> correo = new ArrayList<String>();
        correo.addAll(ReadExcel.getEmailExcel());
        for (String correos : correo) {
        	when(santiago).attemptsTo(TaskEmail.enviarCorreo(correos, "Correo automatizado con screenPlay", "Esto es una prueba"));
		}  
        
        
        
        //Validacion, esto siempre va al final para comprobar el resultado del test.
        //then(santiago).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}