package com.accenture.CorreoMasivo.tasks;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static ArrayList<String> correos = new ArrayList<String>();
	
	public static ArrayList<String> getEmailExcel(){
		String nombreArchivo = "correos.xlsx";
	    String rutaArchivo = "C:\\Users\\santiago.velez\\eclipse-workspace\\CorreoMasivoSanty\\" + nombreArchivo;
	    //System.out.println(rutaArchivo);
	    //String hoja = "Sheet1";

	    try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
	        // leer archivo excel
	        XSSFWorkbook worbook = new XSSFWorkbook(file);
	        //obtener la hoja que se va leer
	        XSSFSheet sheet = worbook.getSheetAt(0);
	        //obtener todas las filas de la hoja excel
	        Iterator<Row> rowIterator = sheet.iterator();

	        Row row;
	        // se recorre cada fila hasta el final
	        while (rowIterator.hasNext()) {
	            row = rowIterator.next();
	            //se obtiene las celdas por fila
	            Iterator<Cell> cellIterator = row.cellIterator();
	            Cell cell;
	            //se recorre cada celda
	            while (cellIterator.hasNext()) {
	                // se obtiene la celda en espec�fico 
	                cell = cellIterator.next();
	                correos.add(row.getCell(0).getStringCellValue());               
	            }
	            //System.out.println();
	        }
	    } catch (Exception e) {
	        e.getMessage();
	    }
	    
	    return correos;

	}
}
