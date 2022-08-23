package mx.employees.employees.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateUtils {

    private static Logger log = LogManager.getLogger(DateUtils.class);

    public static final String DATE_FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
    public static final int ADULT_YEARS = 6570;

    public static Optional<Date> parseToDate(String stringDate) {

        try {

            return Optional.of(new SimpleDateFormat(DATE_FORMAT_yyyy_MM_dd).parse(stringDate));

        } catch (Exception e) {

            return Optional.empty();

        }

    }


    public static boolean isAdult(Date date) {

        long startMs = date.getTime();
        long endMs = new Date().getTime();
        long difference = endMs - startMs;
        double days = Math.floor(difference / (1000 * 60 * 60 * 24));

        if (days < ADULT_YEARS) {

            return false;

        }

        return true;
    }

}
