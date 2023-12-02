package sv.edu.ufg.models.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class GenerarcodigoService {
	
	public static String generateCodeAsString() {
        // Generate a random 4-digit number
        int randomNumber = (int) (Math.random() * 10000);
        
        // Get the current year
        int year = Calendar.getInstance().get(Calendar.YEAR);

        // Combine the year and the 4-digit number as a string
        String generatedCode = String.valueOf(randomNumber + (year * 10000));

        return generatedCode;
	}

}
