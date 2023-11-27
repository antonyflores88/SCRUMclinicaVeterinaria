package sv.edu.ufg.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TransformadorHorario {

    public static LocalTime convertToTime(String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return LocalTime.parse(hora, formatter);
    }
}