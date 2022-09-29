package fpt.edu.appasm.XDate;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayBirthday {
    private static final String FORMAT_DATE = "dd/MM/yyyy";
    public static Date toDate(String date) throws ParseException {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat toDateFM = new SimpleDateFormat(FORMAT_DATE);
        return  toDateFM.parse(date);
    }

    public static String toDateString(Date date){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat toStringDate = new SimpleDateFormat(FORMAT_DATE);
        return toStringDate.format(date);
    }
}
