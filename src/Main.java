import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        LocalDateTime primeiraData = LocalDateTime.now();
        getVaccineSchedule(primeiraData);
    }
    public static void getVaccineSchedule(LocalDateTime primeiraData) {
        LocalDateTime segundaData = primeiraData.plusMonths(3);
        segundaData = handleWeekends(segundaData);

        LocalDateTime terceiraData = segundaData.plusMonths(3);
        terceiraData = handleWeekends(terceiraData);

        LocalDateTime quartaData = terceiraData.plusMonths(3);
        quartaData = handleWeekends(quartaData);

        System.out.println("Primeira dose: " + localDateTimeParser(primeiraData) + " " + getDayOfWeekPortuguese(primeiraData.getDayOfWeek().toString()));
        System.out.println("Segunda dose: " + localDateTimeParser(segundaData) + " " + getDayOfWeekPortuguese(segundaData.getDayOfWeek().toString()));
        System.out.println("Terceira dose: " + localDateTimeParser(terceiraData) + " " + getDayOfWeekPortuguese(terceiraData.getDayOfWeek().toString()));
        System.out.println("Quarta dose: " + localDateTimeParser(quartaData) + " " + getDayOfWeekPortuguese(quartaData.getDayOfWeek().toString()));
    }

    public static LocalDateTime handleWeekends(LocalDateTime date) {
        if (Objects.equals(date.getDayOfWeek().toString(), "SATURDAY")) {
            return date.minusDays(1);
        }
        if (Objects.equals(date.getDayOfWeek().toString(), "SUNDAY")) {
            return date.plusDays(1);
        }
        return date;
    }

    public static String localDateTimeParser(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDateTime);
    }

    public static String getDayOfWeekPortuguese(String dayOfWeekEn) {
        String dayOfWeekPort = "";
        switch(dayOfWeekEn) {
            case "MONDAY" -> dayOfWeekPort = "SEGUNDA-FEIRA";
            case "TUESDAY" -> dayOfWeekPort = "TERÇA-FEIRA";
            case "WEDNESDAY" -> dayOfWeekPort = "QUARTA-FEIRA";
            case "THURSDAY" -> dayOfWeekPort = "QUINTA-FEIRA";
            case "FRIDAY" -> dayOfWeekPort = "SEXTA-FEIRA";
            case "SATURDAY" -> dayOfWeekPort = "SÁBADO";
            case "SUNDAY" -> dayOfWeekPort = "DOMINGO";
        }
        return dayOfWeekPort;
    }
}