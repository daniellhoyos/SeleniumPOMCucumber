package utils;

import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FechasMTX {
	
	//Obtiene una fecha random no menor a la fecha actual
	public String FechaRandomMayorFechaActual(String formato) 
	{
		// Crear un SimpleDateFormat con el mes en inglés y en mayúsculas
        String randomDateFormat = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.ENGLISH);
        sdf.setCalendar(Calendar.getInstance(Locale.ENGLISH));

        try {
            // Obtener la fecha actual
            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();

            // Establecer un límite, por ejemplo, un año a partir de ahora
            calendar.add(Calendar.YEAR, 1);
            Date endDate = calendar.getTime();

            // Calcula la diferencia de tiempo en milisegundos
            long startMillis = currentDate.getTime();
            long endMillis = endDate.getTime();
            long diffMillis = endMillis - startMillis;

            // Genera un número aleatorio dentro del rango
            Random random = new Random();
            long randomMillis = (long) (random.nextDouble() * diffMillis);

            // Crea la nueva fecha
            Date randomDate = new Date(startMillis + randomMillis);
            randomDateFormat = sdf.format(randomDate).toUpperCase();
            System.out.println("Random Date: " + sdf.format(randomDate).toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return randomDateFormat;	
	}
	
	//Obtiene la hora actual
	public String HoraActual(String formato) 
	{
        String randomDateFormat = "";
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        randomDateFormat = currentTime.format(formatter);

        System.out.println("Hora actual: " + randomDateFormat);
		return randomDateFormat;	
	}
	
	//Obtiene la fecha actual menos n anos
	public String FechaActualMenosAnos(String formato, int anos) 
	{
        String dateFormat = "";
        try {
            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Subtract one year from the current date
            LocalDate dateLastYear = currentDate.minusYears(anos);

            // Define the formatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato, Locale.ENGLISH);

            // Format the date
            dateFormat = dateLastYear.format(formatter).toUpperCase();

            // Output the formatted date
            System.out.println(dateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return dateFormat;	
	}
	
	
	
}
