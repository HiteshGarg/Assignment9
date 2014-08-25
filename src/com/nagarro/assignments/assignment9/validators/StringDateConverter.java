package com.nagarro.assignments.assignment9.validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.assignments.assignment9.constants.Constants;
import com.nagarro.assignments.assignment9.exception.NewCustomException;

/**
 * This class is used as a utility to convert Date to string and vice versa.
 * 
 * @author Nagarro
 */
public class StringDateConverter {

    /**
     * Private constructor.
     */
    private StringDateConverter() {
    }

    /**
     * Validates and Converts a String into a Date object.
     * 
     * @param input
     *            - String to convert into Date object
     * @return converted string into Date
     * @throws NewCustomException
     */
    public static Date stringToDateConvertor(final String input)
            throws NewCustomException {

        final SimpleDateFormat formatter = new SimpleDateFormat(
                Constants.DATE_FORMAT);
        Date date = null;
        try {
            formatter.setLenient(false);
            date = formatter.parse(input);
        } catch (ParseException e) {
            throw new NewCustomException("Error in Date processing..."
                    + " Please Try again", e);
        }
        return date;
    }

    /**
     * Converts Date object into String.
     * 
     * @param date
     *            Input Date object
     * @return String
     * @throws NewCustomException
     */
    public static String dateToStringConvertor(final Date date)
            throws NewCustomException {
        try {
            final DateFormat formatter = new SimpleDateFormat(
                    Constants.DATE_FORMAT);
            return formatter.format(date);
        } catch (Exception e) {
            throw new NewCustomException("Error in Date Formatting", e);
        }
    }
}
