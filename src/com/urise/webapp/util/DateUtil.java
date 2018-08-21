package com.urise.webapp.util;

import java.time.LocalDate;
import java.time.Month;

public class DateUtil {
    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);
    // значение далеко впереди, все проверки в диапозон и тд будут работать.
    // pattern special case

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
    // используем этот метод для конструирвоание organization
}
